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

import com.niti.bo.UserImmigrationBO;
import com.niti.dao.DaoException;
import com.niti.dao.IUserImmigrationDAO;
import com.niti.dao.entity.UserImmigrationEntity;
import com.niti.service.IUserImmigrationService;
import com.niti.service.exception.ServiceBusinessException;
import com.niti.service.exception.ServiceException;

@Component("userImmigrationServiceImpl")
@Transactional
public class UserImmigrationServiceImpl implements IUserImmigrationService {

	private static final Logger logger = LoggerFactory.getLogger(UserImmigrationServiceImpl.class);

	@Autowired
	private IUserImmigrationDAO userImmigrationDAOImpl;

	private ModelMapper boToEntityMapper;

	private ModelMapper entityToBOMapper;

	@PostConstruct
	public void init() {
		boToEntityMapper = new ModelMapper();
		entityToBOMapper = new ModelMapper();

	}

	@Override
	public UserImmigrationBO findUserImmigrationByUserImmigrationId(Integer userImmigrationId)
			throws ServiceBusinessException {

		UserImmigrationEntity immigrationEntity;
		try {
			immigrationEntity = userImmigrationDAOImpl.findUserImmigrationByUserExperienceId(userImmigrationId);
			if (immigrationEntity == null) {
				throw new ServiceBusinessException(
						"User with user Immigration Id " + userImmigrationId + " Not found in system",
						ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
			}

		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}

		return convertToBO(immigrationEntity);

	}

	@Override
	public void addUserImmigration(UserImmigrationBO userImmigrationBO) throws ServiceBusinessException {
		try {
			if (userImmigrationBO == null) {
				throw new ServiceBusinessException("Cannot add a null object",
						ServiceException.ErrorCode.NULL_OBJECT_REFERENCE);
			}

			if (userImmigrationBO.getUserImmigrationId() == null) {
				userImmigrationDAOImpl.addUserImmigration((convertToEntity(userImmigrationBO)));

			} else {
				if (userImmigrationDAOImpl
						.findUserImmigrationByUserExperienceId(userImmigrationBO.getUserImmigrationId()) != null) {
					throw new ServiceBusinessException("User with User Immigration ID  "
							+ userImmigrationBO.getUserImmigrationId() + " already exists in system",
							ServiceException.ErrorCode.DATA_ALREADY_EXISTS);
				}
			}
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}

	}

	@Override
	public void updateUserImmigration(UserImmigrationBO userImmigrationBO) throws ServiceBusinessException {

		try {
			userImmigrationDAOImpl.updateUserImmigration((convertToEntity(userImmigrationBO)));
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}

	}

	@Override
	public void deleteUserImmigration(Integer userImmigrationId) throws ServiceBusinessException {

		UserImmigrationEntity userImmigrationEntity;

		try {
			userImmigrationEntity = userImmigrationDAOImpl.findUserImmigrationByUserExperienceId(userImmigrationId);
			if (userImmigrationEntity == null) {
				throw new ServiceBusinessException(
						"User with User Immigration ID  " + userImmigrationId + " does not  exists in system",
						ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
			} else {
				userImmigrationDAOImpl.deleteUserImmigration(userImmigrationEntity);
			}

		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}

	}

	@Override
	public List<UserImmigrationBO> getAllUserImmigrationsByUserId(Integer userId) throws ServiceBusinessException {

		List<UserImmigrationEntity> immigrationEntities;
		List<UserImmigrationBO> userImmigrationBOs = new ArrayList<UserImmigrationBO>();
		try {
			immigrationEntities = userImmigrationDAOImpl.getAllUserImmigrationByUserId(userId);
			immigrationEntities.forEach(entity -> entity.toString());
			if (immigrationEntities == null || immigrationEntities.size() == 0) {
				// throw new ServiceBusinessException("No User Experiences Found for the User id
				// " + userId +" in the system",
				// ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
				logger.info("No User Immigrations Found for the User id " + userId + " in the system");
				;
				return userImmigrationBOs;
			}

			immigrationEntities.stream()
					.forEach(immigrationEntity -> userImmigrationBOs.add(convertToBO(immigrationEntity)));
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}

		return userImmigrationBOs;

	}

	private UserImmigrationEntity convertToEntity(UserImmigrationBO userImmigrationBO) {
		return boToEntityMapper.map(userImmigrationBO, UserImmigrationEntity.class);

	}

	private UserImmigrationBO convertToBO(UserImmigrationEntity userImmigrationEntity) {
		return entityToBOMapper.map(userImmigrationEntity, UserImmigrationBO.class);
	}

}
