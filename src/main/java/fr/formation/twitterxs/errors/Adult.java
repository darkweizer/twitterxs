package fr.formation.twitterxs.errors;

import fr.formation.twitterxs.errors.impl.AdultValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = AdultValidator.class)
public @interface Adult {

    int age() default 18;

    String message() default "{E_NOT_ADULT}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
