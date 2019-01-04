package fr.formation.twitterxs.errors.impl;

import fr.formation.twitterxs.dto.UpdatePasswordDto;
import fr.formation.twitterxs.errors.NotSamePassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotSamePasswordValidator implements ConstraintValidator<NotSamePassword, UpdatePasswordDto> {

    @Override
    public boolean isValid(UpdatePasswordDto value, ConstraintValidatorContext context) {
        return !value.getPassword().equals(value.getNewPassword());
    }
}
