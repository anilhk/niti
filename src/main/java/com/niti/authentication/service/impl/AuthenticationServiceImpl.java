package com.niti.authentication.service.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

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
	public UserBO authenticateUser(UserBO userBO, BindingResult result) throws ServiceBusinessException {

		
		UserEntity userEntity;
		UserBO user;
		try {

			userEntity = userDAOImpl.getUserByEmailAddress(userBO.getEmailAddress());
			if (userEntity == null) {
				logger.error("Cannot login user, Invalid user id or password ");
				result.reject("global","Invalid user id or Password");
			}

			user = convertToBO(userEntity);
			if (!PasswordUtils.checkPassword(userBO.getPassword(), user.getPassword())) {

				logger.error("Cannot login user, Invalid user id or password ");
				result.reject("global", "Invalid user id or passwords");

			}

		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
		return user;
	}

	@Override
	public void createUser(UserBO userBO) throws ServiceBusinessException {
		try {

			addSaltAndHash(userBO);
			userDAOImpl.addUser(convertToEntity(userBO));

		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}

	}

	private void addSaltAndHash(UserBO userBO) {

		userBO.setPassword(PasswordUtils.hashPassword(userBO.getPassword()));
		userBO.setConfirmPassword(userBO.getPassword());
	}

	
	@Override
	public void resetPassword(String emailAddress, String password, String confirmPassword)
			throws ServiceBusinessException {
		// TODO Auto-generated method stub

	}

	private UserEntity convertToEntity(UserBO userBO) {
		return boToEntityMapper.map(userBO, UserEntity.class);

	}

	private UserBO convertToBO(UserEntity userEntity) {
		return entityToBOMapper.map(userEntity, UserBO.class);
	}

	
	
}
