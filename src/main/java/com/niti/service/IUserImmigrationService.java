package com.niti.service;

import java.util.List;

import com.niti.bo.UserImmigrationBO;
import com.niti.service.exception.ServiceBusinessException;

public interface IUserImmigrationService {

	 	public UserImmigrationBO findUserImmigrationByUserImmigrationId(Integer userImmigrationId) throws ServiceBusinessException;
		
		public void addUserImmigration(UserImmigrationBO userImmigrationBO) throws ServiceBusinessException;
		
		public void updateUserImmigration(UserImmigrationBO userImmigrationBO) throws ServiceBusinessException;
		
		public void deleteUserImmigration(Integer userImmigrationId) throws ServiceBusinessException;
		
		public List<UserImmigrationBO> getAllUserImmigrationsByUserId(Integer userId) throws ServiceBusinessException;
}
