package fr.formation.twitterxs.errors;

import fr.formation.twitterxs.errors.impl.IsUserPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = IsUserPasswordValidator.class)
public @interface IsUserPassword {

    String message() default "{E_NOT_USERNAME_PASSWORD}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
