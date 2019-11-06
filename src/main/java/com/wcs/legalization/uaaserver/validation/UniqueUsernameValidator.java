package com.wcs.legalization.uaaserver.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.wcs.legalization.uaaserver.repository.UserRepository;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String>{
	
	private UserRepository userRepository;

	@Override
	public boolean isValid(String user, ConstraintValidatorContext context) {
		return user != null && userRepository.findByUsername(user) == null;
	}
}
