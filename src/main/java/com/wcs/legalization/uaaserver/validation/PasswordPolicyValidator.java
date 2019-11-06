package com.wcs.legalization.uaaserver.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.CharacterCharacteristicsRule;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RepeatCharacterRegexRule;
import org.passay.Rule;
import org.passay.RuleResult;

public class PasswordPolicyValidator implements ConstraintValidator<UniqueUsername, String>{
	
	private static final int MIN_COMPLEX_RULES = 3;
	private static final int MIN_UPPER_CASE_CHARS = 1;
	private static final int MIN_LOWER_CASE_CHARS = 1;
	private static final int MIN_DIGIT_CASE_CHARS = 1;
	private static final int MIN_SPECIAL_CASE_CHARS = 1;
	private static final int MAX_REPETITIVE_CHARS = 3;

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		List<Rule> passwordRules = new ArrayList<Rule>();
		passwordRules.add(new LengthRule(10, 128));
		CharacterCharacteristicsRule charRules = new CharacterCharacteristicsRule(
				MIN_COMPLEX_RULES,
				new CharacterRule(EnglishCharacterData.UpperCase,MIN_UPPER_CASE_CHARS),
				new CharacterRule(EnglishCharacterData.LowerCase, MIN_LOWER_CASE_CHARS),
				new CharacterRule(EnglishCharacterData.Digit, MIN_DIGIT_CASE_CHARS),
				new CharacterRule(EnglishCharacterData.Special, MIN_SPECIAL_CASE_CHARS));
		passwordRules.add(charRules);
		passwordRules.add(new RepeatCharacterRegexRule(MAX_REPETITIVE_CHARS));
		PasswordValidator passwordValidator = new PasswordValidator(passwordRules);
		PasswordData passwordData = new PasswordData(password);
		RuleResult result = passwordValidator.validate(passwordData);
		return result.isValid();
	}
}