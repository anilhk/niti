package com.niti.authentication.service;

import org.springframework.validation.BindingResult;

import com.niti.bo.UserBO;
import com.niti.service.exception.ServiceBusinessException;

public interface AuthenticationService {

	public boolean userExists(String emailAddress) throws ServiceBusinessException;
	
	public UserBO authenticateUser(UserBO userBO, BindingResult result) throws ServiceBusinessException;
	
	public void createUser(UserBO userBO) throws ServiceBusinessException;
	
	public void resetPassword(String emailAddress, String password, String confirmPassword) throws ServiceBusinessException;
}
