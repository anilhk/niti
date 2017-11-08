package com.niti.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.niti.bo.UserDependentBO;

@Component
public class UserDependentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDependentBO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		
		ValidationUtils.rejectIfEmpty(error, "name", "userdependent.name.empty");
		ValidationUtils.rejectIfEmpty(error, "dob", "userdependent.dob.empty");
		ValidationUtils.rejectIfEmpty(error, "relation", "userdependent.relation.empty");
		
	}

}
