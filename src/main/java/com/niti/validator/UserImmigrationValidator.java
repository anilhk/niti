package com.niti.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.niti.bo.UserImmigrationBO;

@Component
public class UserImmigrationValidator implements Validator {

	private static final Logger logger = LoggerFactory.getLogger(UserImmigrationValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return UserImmigrationBO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {

		ValidationUtils.rejectIfEmpty(error, "passportNumber", "userimmigration.passportNumber.empty");
		ValidationUtils.rejectIfEmpty(error, "passportIssueDate", "userimmigration.passportIssueDate.empty");
		ValidationUtils.rejectIfEmpty(error, "passportExpiryDate", "userimmigration.passportExpiryDate.empty");
		ValidationUtils.rejectIfEmpty(error, "visaNumber", "userimmigration.visaNumber.empty");
		ValidationUtils.rejectIfEmpty(error, "visaIssueDate", "userimmigration.visaIssueDate.empty");
		ValidationUtils.rejectIfEmpty(error, "visaExpiryDate", "userimmigration.visaExpiryDate.empty");
		ValidationUtils.rejectIfEmpty(error, "i94Number", "userimmigration.i94Number.empty");


		
	}

}
