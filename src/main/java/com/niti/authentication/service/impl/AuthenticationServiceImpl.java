package com.niti.authentication.service.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niti.authentication.service.AuthenticationService;
import com.niti.bo.UserBO;
import com.niti.dao.DaoException;
import com.niti.dao.IUserDAO;
import com.niti.dao.entity.UserEntity;
import com.niti.service.exception.ServiceBusinessException;
import com.niti.service.exception.ServiceException;
import com.niti.utils.PasswordUtils;

@Transactional
@Component("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
	
	@Autowired
	private IUserDAO userDAOImpl;
	
	private ModelMapper boToEntityMapper;

	private ModelMapper entityToBOMapper;
	
	@PostConstruct
	public void init() {
		boToEntityMapper = new ModelMapper();
		entityToBOMapper = new ModelMapper();
	}
	
	@Override
	public boolean userExists(String emailAddress) throws ServiceBusinessException {
		
		boolean userExists = false;
		try {
			userExists = userDAOImpl.findUserByEmailAddress(emailAddress);
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
		return userExists;
	}

	@Override
	public UserBO authenticateUser(String emailAddress, String password) throws ServiceBusinessException{
		return null;
	}

	@Override
	public void createUser(UserBO userBO) throws ServiceBusinessException {
		try {
	
			validateUser(userBO);
			addSaltAndHash(userBO); 
            userDAOImpl.addUser(convertToEntity(userBO));
			
		}catch(DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
		
	}

	private void addSaltAndHash(UserBO userBO) {

			userBO.setPassword(PasswordUtils.hashPassword(userBO.getPassword()));
			userBO.setConfirmPassword(userBO.getPassword());
	}
	

	public void validateUser(UserBO userBO) throws ServiceBusinessException {

		if (userBO == null) {
			logger.error("cannot add user, user is null" , userBO);
			throw new ServiceBusinessException("Cannot add a null object", ServiceException.ErrorCode.NULL_OBJECT_REFERENCE);
		}
		 if (userBO.getEmailAddress() == null || userBO.getEmailAddress().isEmpty()) {
			 logger.error("cannot add user, user email address cannot be null or empty ", userBO.getEmailAddress());
			 //TODO :: throw email address cannot be null.
			 throw new ServiceBusinessException("Cannot add a null object", ServiceException.ErrorCode.NULL_OBJECT_REFERENCE);
		 }
		 
		 if (userExists(userBO.getEmailAddress())) {
			 logger.error("cannot add user, user email address already exists ", userBO.getEmailAddress());
			 //TODO :: throw user already exists exception
			 throw new ServiceBusinessException("Cannot add a null object", ServiceException.ErrorCode.NULL_OBJECT_REFERENCE);
		 }
		 
		 if (userBO.getPassword() == null || userBO.getPassword().isEmpty() || userBO.getConfirmPassword() == null ||
				 userBO.getConfirmPassword().isEmpty()) {
			 logger.error("cannot add user, either user password or confirm password is null or empty " +userBO.getPassword() + " Confirm password = " +userBO.getConfirmPassword());
			//TODO :: throw error password and confirm password field cannot be empty. // in case javascript validation disabled . validate server side.
			 throw new ServiceBusinessException("Cannot add a null object", ServiceException.ErrorCode.NULL_OBJECT_REFERENCE);
		 }
		 
		 if (!userBO.getPassword().equals(userBO.getConfirmPassword())) {
			 logger.error("cannot add user, user password and confirm password do not match. Password " +userBO.getPassword() + " Confirm password = " +userBO.getConfirmPassword());
			//TODO :: throw error password and confirm password should be same . // in case javascript validation disabled . validate server side.
			 throw new ServiceBusinessException("Cannot add a null object", ServiceException.ErrorCode.NULL_OBJECT_REFERENCE);
		 }
		
	}

	@Override
	public void resetPassword(String emailAddress, String password, String confirmPassword) throws ServiceBusinessException  {
		// TODO Auto-generated method stub
		
	}
	
	private UserEntity convertToEntity(UserBO userBO) {
		return boToEntityMapper.map(userBO, UserEntity.class);

	}

	private UserBO convertToBO(UserEntity userEntity) {
		return entityToBOMapper.map(userEntity, UserBO.class);
	}

}
