package com.niti.authentication.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordValidator;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.RuleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.niti.service.exception.ServiceBusinessException;
import com.niti.service.exception.ServiceException;


public class PasswordConstraintValidator  {

	private static final Logger logger = LoggerFactory.getLogger(PasswordConstraintValidator.class);

	public static boolean validatePassword(String password) throws ServiceBusinessException {
		
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
				
			logger.error("Password Validation failed :: ");
			final StringBuilder message = new StringBuilder();
			passwordValidator.getMessages(ruleResult).stream().forEach(message::append);
			String developerMessage = createMessagefromException(message.toString());
			throw new ServiceBusinessException(developerMessage, ServiceException.ErrorCode.PASSWORD_VALIDATION_FAILED);
		}
		
		return isPasswordValid;
	}
	
	

	private static String createMessagefromException(String message) {
		
		StringBuilder developerMessage = new StringBuilder("The password has the following issues : ");
		 String[] words = message.split(":|\\}");
		    List<String> result = new ArrayList<String>();

		    for(String word : words) {
		        String wordToUpperCase = word.toUpperCase();
		        if(wordToUpperCase.equals(word)) {
		            result.add(word);
		        }
		    }
		    
		    for (String str : result) {
		    	developerMessage.append(str).append(",");
		    }
		    
			return developerMessage.toString();
		
	}
	
}
