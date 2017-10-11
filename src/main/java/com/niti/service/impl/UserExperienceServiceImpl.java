package com.niti.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niti.bo.UserExperienceBO;
import com.niti.dao.DaoException;
import com.niti.dao.IUserExperienceDAO;
import com.niti.dao.entity.UserExperienceEntity;
import com.niti.service.IUserExperienceService;
import com.niti.service.exception.ServiceBusinessException;
import com.niti.service.exception.ServiceException;

@Transactional
@Component("userExperienceServiceImpl")
public class UserExperienceServiceImpl implements IUserExperienceService {

	@Autowired
	private IUserExperienceDAO userExperienceDAOImpl;
	
	private ModelMapper boToEntityMapper;

	private ModelMapper entityToBOMapper;

	@PostConstruct
	public void init() {
		boToEntityMapper = new ModelMapper();
		entityToBOMapper = new ModelMapper();
	}
	
	
	private static final Logger logger = LoggerFactory.getLogger(UserExperienceServiceImpl.class);
	
	/**
	 * check if userExperienceId exists in the system.
	   if exits get the UserExperienceEntity, else throw not found exception.
	   convert entity to BO using object mappper.
	   return userExperienceBO
	 * 
	 */
	@Override
	public UserExperienceBO findUserExperienceByUserExperienceId(Integer userExperienceId) throws ServiceBusinessException {
		
		UserExperienceEntity experienceEntity;
		try {
			experienceEntity = userExperienceDAOImpl.findUserExperienceByUserExperienceId(userExperienceId);
			if (experienceEntity == null) {
				throw new ServiceBusinessException("User with user Experience Id " + userExperienceId +" Not found in system", ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
			}
			
		}catch(DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
		
		return convertToBO(experienceEntity);
		
	}

	/**
	 *  checks if the userExperienceBO object is not null. 
	 *  if null, throws NULL_OBJECT_REFERENCE exception
	 *  if object is valid or not. Is valid -> object Id is null else invalid.
	 *  if valid, persists to db. if invalid, check if Id exists in the system and throw error.
	 */
	@Override
	public void addUserExperience(UserExperienceBO userExperienceBO) throws ServiceBusinessException {
		try {
			 if (userExperienceBO == null) {
				throw new ServiceBusinessException("Cannot add a null object", ServiceException.ErrorCode.NULL_OBJECT_REFERENCE);
			 }
			
			 if (userExperienceBO.getUserExperienceId() == null) {
				 	userExperienceDAOImpl.addUserExperience(convertToEntity(userExperienceBO));
				 
			 } else {
				  if (userExperienceDAOImpl.findUserExperienceByUserExperienceId(userExperienceBO.getUserExperienceId()) != null) {
						throw new ServiceBusinessException("User with User Experience ID  " + userExperienceBO.getUserExperienceId() +" already exists in system", ServiceException.ErrorCode.DATA_ALREADY_EXISTS);
				  }
			 }
		}catch(DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
		
	}

	@Override
	public void updateUserExperience(UserExperienceBO userExperienceBO) throws ServiceBusinessException {
		
		try {
			userExperienceDAOImpl.updateUserExperience(convertToEntity(userExperienceBO));
		}catch(DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
		
	}

	@Override
	public void deleteUserExperience(Integer userExperienceId) throws ServiceBusinessException {
		
		UserExperienceEntity experienceEntity;
		
		try {
			experienceEntity = userExperienceDAOImpl.findUserExperienceByUserExperienceId(userExperienceId);
			 if (experienceEntity == null) {
				 throw new ServiceBusinessException("User with User Experience ID  " + userExperienceId +" does not  exists in system", ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
			 }else {
				 userExperienceDAOImpl.deleteUserExperienceEntity(experienceEntity);
			 }
			
		}catch(DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
		
	}

	@Override
	public List<UserExperienceBO> getAllUserExperiencesByUserId(Integer userId) throws ServiceBusinessException {
		
		List<UserExperienceEntity> experienceEntities;
		List<UserExperienceBO> userExperienceBOs = new ArrayList<UserExperienceBO>();
		try {
				experienceEntities = userExperienceDAOImpl.getAllUserExperiencesByUserId(userId);
				System.out.println("experiences = " +experienceEntities);
				System.out.println("experiences size " +experienceEntities.size());
				experienceEntities.forEach(entity -> entity.toString());
				 if (experienceEntities == null || experienceEntities.size() ==0 ) {
					 throw new ServiceBusinessException("No User Experiences Found for the User id " + userId +" in the system", ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
				 }
		
			experienceEntities.stream().forEach(experienceEntity -> userExperienceBOs.add(convertToBO(experienceEntity)));
		}catch(DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
		
		return userExperienceBOs;
	}
	
	private UserExperienceEntity convertToEntity(UserExperienceBO userExperienceBO) {
		return boToEntityMapper.map(userExperienceBO, UserExperienceEntity.class);

	}

	private UserExperienceBO convertToBO(UserExperienceEntity userExperienceEntity) {
		return entityToBOMapper.map(userExperienceEntity, UserExperienceBO.class);
	}

	
	

}
