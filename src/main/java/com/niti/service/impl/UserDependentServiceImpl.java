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

import com.niti.bo.UserDependentBO;
import com.niti.dao.DaoException;
import com.niti.dao.IUserDependentDAO;
import com.niti.dao.entity.UserDependentEntity;
import com.niti.service.IUserDependentService;
import com.niti.service.exception.ServiceBusinessException;
import com.niti.service.exception.ServiceException;

@Transactional
@Component("userDependentServiceImpl")
public class UserDependentServiceImpl implements IUserDependentService {

	@Autowired
	private IUserDependentDAO userDependentDAOImpl;

	private ModelMapper boToEntityMapper;

	private ModelMapper entityToBOMapper;

	@PostConstruct
	public void init() {
		boToEntityMapper = new ModelMapper();
		entityToBOMapper = new ModelMapper();

	}

	private static final Logger logger = LoggerFactory.getLogger(UserExperienceServiceImpl.class);

	
	@Override
	public UserDependentBO findUserDependentByUserDependentId(Integer userDependentId) throws ServiceBusinessException {
		
		UserDependentEntity dependentEntity;
		try {
			dependentEntity = userDependentDAOImpl.findUserDependentByUserDependentId(userDependentId);
			if (dependentEntity == null) {
				throw new ServiceBusinessException(
						"User with user Dependent Id " + userDependentId + " Not found in system",
						ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
			}

		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}

		return convertToBO(dependentEntity);
	}

	@Override
	public void addUserDependent(UserDependentBO userDependentBO) throws ServiceBusinessException {

		try {
			if (userDependentBO == null) {
				throw new ServiceBusinessException("Cannot add a null object",
						ServiceException.ErrorCode.NULL_OBJECT_REFERENCE);
			}

			if (userDependentBO.getUserDependentId() == null) {
				userDependentDAOImpl.addUserDependent(convertToEntity(userDependentBO));

			} else {
				if (userDependentDAOImpl
						.findUserDependentByUserDependentId(userDependentBO.getUserDependentId()) != null) {
					throw new ServiceBusinessException("User with User Dependent ID  "
							+ userDependentBO.getUserDependentId() + " already exists in system",
							ServiceException.ErrorCode.DATA_ALREADY_EXISTS);
				}
			}
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
		
	}

	@Override
	public void updateUserDependent(UserDependentBO userDependentBO) throws ServiceBusinessException {

		try {
			userDependentDAOImpl.updateUserDependent(convertToEntity(userDependentBO));
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
	}

	@Override
	public void deleteUserDependent(Integer userDependentId) throws ServiceBusinessException {

		UserDependentEntity dependentEntity;

		try {
			dependentEntity = userDependentDAOImpl.findUserDependentByUserDependentId(userDependentId);
			if (dependentEntity == null) {
				throw new ServiceBusinessException(
						"User with User Dependent ID  " + dependentEntity + " does not  exists in system",
						ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
			} else {
				userDependentDAOImpl.deleteUserDependentEntity(dependentEntity);
			}

		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}
		
	}

	@Override
	public List<UserDependentBO> getAllUserDependentsByUserId(Integer userId) throws ServiceBusinessException {
		
		List<UserDependentEntity> dependentEntities;
		List<UserDependentBO> userDependenteBOs = new ArrayList<UserDependentBO>();
		try {
			dependentEntities = userDependentDAOImpl.getAllUserDependentsByUserId(userId);
			if (dependentEntities == null || dependentEntities.size() == 0) {
				// throw new ServiceBusinessException("No User Experiences Found for the User id
				// " + userId +" in the system",
				// ServiceException.ErrorCode.DATA_NOT_FOUND_EXCEPTION);
				logger.info("No User Dependents Found for the User id " + userId + " in the system");
				;
				return userDependenteBOs;
			}

			dependentEntities.stream()
					.forEach(dependentEntity -> userDependenteBOs.add(convertToBO(dependentEntity)));
		} catch (DaoException e) {
			logger.error("Database exception ", e);
			throw new ServiceBusinessException("Technical Error", ServiceException.ErrorCode.TECHNICAL_ERROR);
		}

		return userDependenteBOs;
	}
	
	
	private UserDependentEntity convertToEntity(UserDependentBO userDependentBO) {
		return boToEntityMapper.map(userDependentBO, UserDependentEntity.class);

	}

	private UserDependentBO convertToBO(UserDependentEntity userDependentEntity) {
		return entityToBOMapper.map(userDependentEntity, UserDependentBO.class);
	}

}
