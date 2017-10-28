package com.niti.authentication.service.impl;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.niti.bo.UserBO;

public class UserLoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.getClass().equals(UserBO.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		
	}

	
}
