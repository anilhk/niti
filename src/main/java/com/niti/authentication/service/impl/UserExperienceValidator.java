package com.niti.authentication.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.niti.bo.UserExperienceBO;

@Component
public class UserExperienceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserExperienceBO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {

		ValidationUtils.rejectIfEmpty(error, "clientName", "userexperience.clientName.empty");
		ValidationUtils.rejectIfEmpty(error, "reportingManager", "userexperience.reportingManager.empty");
		ValidationUtils.rejectIfEmpty(error, "accountManager", "userexperience.accountManager.empty");
		
		ValidationUtils.rejectIfEmpty(error, "jobTitle", "userexperience.jobTitle.empty");
		ValidationUtils.rejectIfEmpty(error, "noOfYears", "userexperience.noOfYears.empty");
		ValidationUtils.rejectIfEmpty(error, "clientStartDate", "userexperience.clientStartDate.empty");
		ValidationUtils.rejectIfEmpty(error, "clientEndDate", "userexperience.clientEndDate.empty");
	
	}

}
