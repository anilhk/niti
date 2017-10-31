package com.niti.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.niti.bo.UserBO;


@Component
public class UserRegistrationValidator implements Validator {

	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBO.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors error) {

		ValidationUtils.rejectIfEmpty(error, "emailAddress", "user.emailAddress.empty");
		ValidationUtils.rejectIfEmpty(error, "password", "user.password.empty");
		ValidationUtils.rejectIfEmpty(error, "confirmPassword", "user.confirmPassword.empty");

		UserBO userBO = (UserBO) obj;

		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		if (!(pattern.matcher(userBO.getEmailAddress()).matches())) {
			logger.error("email adress is not valid " + userBO.getEmailAddress());
			error.rejectValue("emailAddress", "user.emailAddress.invalid");
		}

		if (!userBO.getPassword().equals(userBO.getConfirmPassword())) {

			logger.error("cannot add user, user password and confirm password do not match.");
			error.rejectValue("confirmPassword", "user.confirmPassword.notMatched");
		}

		PasswordValidatorUtils.validatePasswordConstraints(userBO.getPassword(), error);
	}

	private static class PasswordValidatorUtils {

		private static PasswordValidator passwordValidator;

		private static final Logger logger = LoggerFactory.getLogger(PasswordValidatorUtils.class);

		static {

			passwordValidator = new PasswordValidator(
					Arrays.asList(new LengthRule(4, 10)));
						//	new CharacterRule(EnglishCharacterData.UpperCase, 1),
						//	new CharacterRule(EnglishCharacterData.LowerCase, 1),
						//	new CharacterRule(EnglishCharacterData.Digit, 1),
						//	new CharacterRule(EnglishCharacterData.Special, 1)));
		}

		public static void validatePasswordConstraints(String password, Errors error) {

			RuleResult ruleResult = passwordValidator.validate(new PasswordData(password));

			if (!ruleResult.isValid()) {
				logger.error("Password Validation failed :: ");
				final StringBuilder message = new StringBuilder();
				passwordValidator.getMessages(ruleResult).stream().forEach(message::append);
				String developerMessage = createMessagefromException(message.toString());
				logger.error("Password contrainsts validation failed " +developerMessage);
				error.rejectValue("password", "user.password.constraint");
			}

		}

		private static String createMessagefromException(String message) {

			StringBuilder developerMessage = new StringBuilder("The password has the following issues : ");
			String[] words = message.split(":|\\}");
			List<String> result = new ArrayList<String>();

			for (String word : words) {
				String wordToUpperCase = word.toUpperCase();
				if (wordToUpperCase.equals(word)) {
					result.add(word);
				}
			}

			for (String str : result) {
				developerMessage.append(str).append(",");
			}

			return developerMessage.toString();

		}

	}

}
