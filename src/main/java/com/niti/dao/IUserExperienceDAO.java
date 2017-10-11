package com.niti.dao;

import java.util.List;

import com.niti.dao.entity.UserExperienceEntity;

public interface IUserExperienceDAO {

	public UserExperienceEntity findUserExperienceByUserExperienceId(Integer userExperienceId) throws DaoException;
	
	public void addUserExperience(UserExperienceEntity userExperience) throws DaoException;
	
	public void updateUserExperience(UserExperienceEntity userExperience) throws DaoException;
	
	public void deleteUserExperienceEntity(UserExperienceEntity userExperience) throws DaoException;
	
	public List<UserExperienceEntity> getAllUserExperiencesByUserId(Integer userId) throws DaoException;
}
