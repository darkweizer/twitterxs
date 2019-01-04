package fr.formation.twitterxs.security;

import org.springframework.security.access.annotation.Secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Secured({"ROLE_ACTUATOR", "ROLE_ADMIN", "ROLE_USER"})
public @interface AnyRole {
    //
}
