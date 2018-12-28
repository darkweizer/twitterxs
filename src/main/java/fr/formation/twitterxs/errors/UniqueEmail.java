package fr.formation.twitterxs.errors;

import fr.formation.twitterxs.errors.impl.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {

    String message() default "{E_EMAIL_EXIST}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
