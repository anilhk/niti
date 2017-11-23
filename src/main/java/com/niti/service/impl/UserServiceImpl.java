package com.niti.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niti.bo.UserBO;
import com.niti.dao.DaoException;
import com.niti.dao.IUserDAO;
import com.niti.dao.entity.UserEntity;
import com.niti.service.IUserService;
import com.niti.service.exception.ServiceBusinessException;
import com.niti.service.exception.ServiceException;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements IUserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
	public UserBO findUserByUserId(Integer userId) throws ServiceBusinessException {

		UserEntity userEntity;

		try {
			userEntity = userDAOImpl.findUserByUserId(userId);
			if (userEntity == null) {
				throw new ServiceBusinessException("User with Userid " + userId +" Not found in system", ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
			}
			
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}

		return convertToBO(userEntity);
	}

	@Override
	public void addUser(UserBO userBO) throws ServiceBusinessException {
		try {
			if (userBO == null) {
				throw new ServiceBusinessException("Cannot add a null object", ServiceException.ErrorCode.NULL_OBJECT_REFERENCE);
			}
			
			if (userBO.getUserId() == null) {
				userDAOImpl.addUser(convertToEntity(userBO));
			}else {
			
				if (userDAOImpl.findUserByUserId(userBO.getUserId()) != null) {
					throw new ServiceBusinessException("User with Userid " + userBO.getUserId() +" already exists in system", ServiceException.ErrorCode.DATA_ALREADY_EXISTS);
				}
	
			}	
					
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
	}

	@Override
	public void updateUser(UserBO userBO) throws ServiceBusinessException {

		UserEntity userDBEntity = null;
		try {
			 userDBEntity = userDAOImpl.findUserByUserId(userBO.getUserId());
			if (userDBEntity == null) {
				throw new ServiceBusinessException("User with Userid " + userBO.getUserId() +" does not  exists in system", ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
			}
			userDBEntity.setFirstName(userBO.getFirstName());
			userDBEntity.setLastName(userBO.getLastName());
			userDBEntity.setMiddleName(userBO.getMiddleName());
			userDBEntity.setPrimaryContactNumber(userBO.getPrimaryContactNumber());
			userDBEntity.setSecondaryContactNumber(userBO.getSecondaryContactNumber());
			userDBEntity.setEmailAddress(userBO.getEmailAddress());
			userDBEntity.setStatus(userBO.getStatus());
			userDBEntity.setSalary(userBO.getSalary());
			userDBEntity.setStartDate(userBO.getStartDate());
			userDBEntity.setEndDate(userBO.getEndDate());
			userDAOImpl.updateUser(userDBEntity);
			
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
	}

	@Override
	public void deleteUser(Integer userId) throws ServiceBusinessException {

		UserEntity userEntity;
		try {
			userEntity = userDAOImpl.findUserByUserId(userId);
			if (userEntity == null) {
				throw new ServiceBusinessException("User with Userid " + userId +" Not found in system", ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
			}else {
				userDAOImpl.deleteUser(userEntity);
			}
			
		}catch(DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
			
		} 
	}

	@Override
	public List<UserBO> getAllUsers() throws ServiceBusinessException {
		
		List<UserBO> users = new ArrayList<UserBO>();
		List<UserEntity> userentities;
		
		try {
			userentities = userDAOImpl.getAllUsers();
			
			System.out.println(userentities);
		}catch(DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
		
		userentities.stream().forEach(entity -> users.add(convertToBO(entity)));
		return users;
	}

	private UserEntity convertToEntity(UserBO userBO) {
		return boToEntityMapper.map(userBO, UserEntity.class);

	}

	private UserBO convertToBO(UserEntity userEntity) {
		return entityToBOMapper.map(userEntity, UserBO.class);
	}

	@Override
	public void updateUserOfficialInformation(UserBO userBO) throws ServiceBusinessException {

		UserEntity userDBEntity = null;
		try {
			 userDBEntity = userDAOImpl.findUserByUserId(userBO.getUserId());
			if (userDBEntity == null) {
				throw new ServiceBusinessException("User with Userid " + userBO.getUserId() +" does not  exists in system", ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
			}
			userDBEntity.setFirstName(userBO.getFirstName());
			userDBEntity.setLastName(userBO.getLastName());
			userDBEntity.setMiddleName(userBO.getMiddleName());
			userDBEntity.setPrimaryContactNumber(userBO.getPrimaryContactNumber());
			userDBEntity.setSecondaryContactNumber(userBO.getSecondaryContactNumber());
			userDBEntity.setEmailAddress(userBO.getEmailAddress());
			userDBEntity.setStatus(userBO.getStatus());
			userDBEntity.setSalary(userBO.getSalary());
			userDBEntity.setStartDate(userBO.getStartDate());
			userDBEntity.setEndDate(userBO.getEndDate());
			userDAOImpl.updateUser(userDBEntity);
			
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
	}

	@Override
	public void updateUserProfileInformation(UserBO userBO) throws ServiceBusinessException {
		
		UserEntity userDBEntity = null;
		try {
			 userDBEntity = userDAOImpl.findUserByUserId(userBO.getUserId());
			if (userDBEntity == null) {
				throw new ServiceBusinessException("User with Userid " + userBO.getUserId() +" does not  exists in system", ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
			}
			userDBEntity.setDrivingLicense(userBO.getDrivingLicense());
			userDBEntity.setDrivingLicenseExpiry(userBO.getDrivingLicenseExpiry());
			userDBEntity.setDateOfBirth(userBO.getDateOfBirth());
			userDBEntity.setBloodGroup(userBO.getBloodGroup());
			userDBEntity.setMaritalStatus(userBO.getMaritalStatus());
			userDBEntity.setEthnicity(userBO.getEthnicity());
			userDBEntity.setGender(userBO.getGender());
			userDBEntity.setSalary(userBO.getSalary());
			userDBEntity.setStartDate(userBO.getStartDate());
			userDBEntity.setEndDate(userBO.getEndDate());
			userDAOImpl.updateUser(userDBEntity);
			
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
	}

}
