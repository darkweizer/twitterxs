package fr.formation.twitterxs.errors.impl;

import fr.formation.twitterxs.errors.UsernameExist;
import fr.formation.twitterxs.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameExistValidator implements ConstraintValidator<UsernameExist, String> {

    private UserService userService;

    public UsernameExistValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.isEmpty()) {
            return true;
        }
        return userService.isUsernameExsit(value);
    }
}
