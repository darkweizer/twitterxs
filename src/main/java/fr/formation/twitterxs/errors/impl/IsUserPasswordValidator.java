package fr.formation.twitterxs.errors.impl;

import fr.formation.twitterxs.dto.ChangePasswordDto;
import fr.formation.twitterxs.errors.IsUserPassword;
import fr.formation.twitterxs.services.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsUserPasswordValidator implements ConstraintValidator<IsUserPassword, ChangePasswordDto> {

    protected UserService userService;

    protected IsUserPasswordValidator(UserService userService){this.userService = userService;}

    @Override
    public boolean isValid(ChangePasswordDto value, ConstraintValidatorContext context) {
        return userService.isUserPassword(value.getUsername(), value.getPassword());
    }
}
