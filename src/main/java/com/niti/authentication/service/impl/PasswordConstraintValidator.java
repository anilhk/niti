package com.niti.authentication.service.impl;

import java.util.Arrays;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordValidator;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.RuleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PasswordConstraintValidator  {

	private static final Logger Logger = LoggerFactory.getLogger(PasswordConstraintValidator.class);

	public static boolean validatePassword(String password) throws PasswordValidatorException {
		
		boolean isPasswordValid = false; 
		
		PasswordValidator passwordValidator = new PasswordValidator(
				Arrays.asList(
							new LengthRule(4,10),
							new CharacterRule(EnglishCharacterData.UpperCase,1), 
							new CharacterRule(EnglishCharacterData.LowerCase,1),
							new CharacterRule(EnglishCharacterData.Digit,1),
							new CharacterRule(EnglishCharacterData.Special,1)
						));
		
		
		RuleResult ruleResult = passwordValidator.validate(new PasswordData(password));
		
		if (ruleResult.isValid()) {
			isPasswordValid = true;
		}else {
			final StringBuilder message = new StringBuilder();
			passwordValidator.getMessages(ruleResult).stream().forEach(message::append);
			System.out.println("password message for error " +message);
			throw new PasswordValidatorException(message.toString());
		}
		
		return isPasswordValid;
	}
	
}
