package com.niti.dao;

import java.util.List;

import com.niti.dao.entity.UserImmigrationEntity;

public interface IUserImmigrationDAO {

	public UserImmigrationEntity findUserImmigrationByUserExperienceId(Integer userImmigrationId) throws DaoException;
	
	public void addUserImmigration(UserImmigrationEntity userImmigration) throws DaoException;
	
	public void updateUserImmigration(UserImmigrationEntity userImmigration) throws DaoException;
	
	public void deleteUserImmigration(UserImmigrationEntity userImmigration) throws DaoException;
	
	public List<UserImmigrationEntity> getAllUserImmigrationByUserId(Integer userId) throws DaoException;
}

