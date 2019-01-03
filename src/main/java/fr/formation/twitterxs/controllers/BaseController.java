package fr.formation.twitterxs.controllers;

import fr.formation.twitterxs.errors.ApiErrors;
import fr.formation.twitterxs.errors.MessageNotReadableError;
import fr.formation.twitterxs.errors.ValidationError;
import fr.formation.twitterxs.security.Principal;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseController  extends ResponseEntityExceptionHandler {

    protected BaseController() {
    }

    /**
     * Returns the authenticated user (principal) identifier.
     *
     * @return the authenticated user identifier
     * @see Principal#getUserId()
     */
    protected static Long getUserId() {
        return getPrincipal().getUserId();
    }

    protected static Principal getPrincipal() {
        return (Principal) getAuthentication().getPrincipal();
    }

    /**
     * Returns the authorities for the authenticated user.
     *
     * @return the authorities for the authenticated user
     */
    protected static Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthentication().getAuthorities();
    }

    protected static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        // Intercept field errors
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ValidationError> errors = new ArrayList<>(fieldErrors.size());
        ValidationError error = null;
        for (FieldError fieldError : fieldErrors) {
            String entityName = fieldError.getObjectName();
            String fieldName = fieldError.getField();
            String errorCode = fieldError.getDefaultMessage();
            error = ValidationError.ofFieldType(entityName, fieldName, errorCode);
            errors.add(error);
        }

        // Intercept global errors such as multi-fields errors
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        for (ObjectError globalError : globalErrors) {
            String entityName = globalError.getObjectName();
            String fieldName = globalError.getCode();
            String errorCode = globalError.getDefaultMessage();
            error = ValidationError.ofGlobalType(entityName, fieldName, errorCode);
            errors.add(error);
        }

        ApiErrors<ValidationError> apiErrors = new ApiErrors<>(errors, status.value(), getRequestURI());
        return new ResponseEntity<>(apiErrors, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        // Intercept not readable messages including conversion errors
        List<MessageNotReadableError> errors = new ArrayList<>();
        errors.add(new MessageNotReadableError(ex.getMessage()));
        ApiErrors<MessageNotReadableError> apiErrors = new ApiErrors<>(errors, status.value(), getRequestURI());
        return new ResponseEntity<>(apiErrors, status);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    /**
     * Convenient method returning the request URI.
     *
     * @return the request URI
     */
    protected static String getRequestURI() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes();
        return attr.getRequest().getRequestURI();
    }
}
