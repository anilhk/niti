package com.niti.authentication.service;

import com.niti.bo.UserBO;
import com.niti.service.exception.ServiceBusinessException;

public interface AuthenticationService {

	public boolean userExists(String emailAddress) throws ServiceBusinessException;
	
	public UserBO authenticateUser(String emailAddress, String password) throws ServiceBusinessException;
	
	public void createUser(UserBO userBO) throws ServiceBusinessException;
	
	public void resetPassword(String emailAddress, String password, String confirmPassword) throws ServiceBusinessException;
}
