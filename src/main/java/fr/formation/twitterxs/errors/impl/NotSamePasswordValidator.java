package fr.formation.twitterxs.errors.impl;

import fr.formation.twitterxs.dto.ChangePasswordDto;
import fr.formation.twitterxs.errors.NotSamePassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotSamePasswordValidator implements ConstraintValidator<NotSamePassword, ChangePasswordDto> {

    @Override
    public boolean isValid(ChangePasswordDto value, ConstraintValidatorContext context) {
        return !value.getPassword().equals(value.getNewPassword());
    }
}
