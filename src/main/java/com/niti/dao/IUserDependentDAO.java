package com.niti.dao;

import java.util.List;

import com.niti.dao.entity.UserDependentEntity;

public interface IUserDependentDAO {

public UserDependentEntity findUserDependentByUserDependentId(Integer userDependentId) throws DaoException;
	
	public void addUserDependent(UserDependentEntity userDependent) throws DaoException;
	
	public void updateUserDependent(UserDependentEntity userDependent) throws DaoException;
	
	public void deleteUserDependentEntity(UserDependentEntity userDependent) throws DaoException;
	
	public List<UserDependentEntity> getAllUserDependentsByUserId(Integer userId) throws DaoException;
}
