package fr.formation.twitterxs.errors.impl;

import fr.formation.twitterxs.errors.Adult;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AdultValidator implements ConstraintValidator<Adult, LocalDate> {

    private int age;

    protected AdultValidator(){}

    @Override
    public void initialize(Adult constraintAnnotation) {
        age = constraintAnnotation.age();
        if(age < 0) {
            throw new IllegalArgumentException("age must be positive");
        }
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if(null == value){
            return true;
        }
        return LocalDate.now().minusYears(age).isAfter(value);
    }
}
