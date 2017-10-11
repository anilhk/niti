package com.niti.service;

import java.util.List;

import com.niti.bo.UserExperienceBO;
import com.niti.service.exception.ServiceBusinessException;

public interface IUserExperienceService {

	 public UserExperienceBO findUserExperienceByUserExperienceId(Integer userExperienceId) throws ServiceBusinessException;
		
		public void addUserExperience(UserExperienceBO userExperienceBO) throws ServiceBusinessException;
		
		public void updateUserExperience(UserExperienceBO userExperienceBO) throws ServiceBusinessException;
		
		public void deleteUserExperience(Integer userExperienceId) throws ServiceBusinessException;
		
		public List<UserExperienceBO> getAllUserExperiencesByUserId(Integer userId) throws ServiceBusinessException;
}
