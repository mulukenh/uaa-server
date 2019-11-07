package com.wcs.legalization.uaaserver.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.wcs.legalization.uaaserver.dto.UserDto;

public class PasswordConfirmValidator implements ConstraintValidator<UniqueUsername, Object>{

	@Override
	public boolean isValid(Object user, ConstraintValidatorContext context) {
		String password = ((UserDto)user).getPassword();
		String confirmedPassword= ((UserDto)user).getConfirmedPassword();
		return password.equals(confirmedPassword);
	}
}