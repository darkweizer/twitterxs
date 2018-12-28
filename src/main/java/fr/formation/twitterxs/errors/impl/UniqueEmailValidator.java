package fr.formation.twitterxs.errors.impl;

import fr.formation.twitterxs.errors.UniqueEmail;
import fr.formation.twitterxs.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    protected UserService userService;

    public UniqueEmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.isEmpty()) {
            return true;
        }
        return !userService.isEmailExist(value);
    }
}
