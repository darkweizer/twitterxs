package fr.formation.twitterxs.errors;

import fr.formation.twitterxs.errors.impl.UsernameExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = UsernameExistValidator.class)
public @interface UsernameExist {

    String message() default "{E_NOT_USERNAME_EXIST}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
