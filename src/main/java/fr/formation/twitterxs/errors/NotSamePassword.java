package fr.formation.twitterxs.errors;

import fr.formation.twitterxs.errors.impl.NotSamePasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = NotSamePasswordValidator.class)
public @interface NotSamePassword {

    String message() default "{E_NOT_SAME_PASSWORD}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
