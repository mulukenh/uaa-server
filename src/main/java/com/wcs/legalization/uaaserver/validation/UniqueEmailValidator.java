package com.wcs.legalization.uaaserver.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.wcs.legalization.uaaserver.repository.UserRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueUsername, String>{
	
	private UserRepository userRepository;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return email != null && userRepository.findByEmail(email) == null;
	}
}