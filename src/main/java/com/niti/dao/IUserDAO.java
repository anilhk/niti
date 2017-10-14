package com.niti.dao;

import java.util.List;

import com.niti.dao.entity.UserEntity;

public interface IUserDAO {

	public UserEntity findUserByUserId(Integer userId) throws DaoException;
	
	public void addUser(UserEntity user) throws DaoException;
	
	public void updateUser(UserEntity user) throws DaoException;
	
	public void deleteUser(UserEntity user) throws DaoException;
	
	public List<UserEntity> getAllUsers() throws DaoException;
	
	public boolean findUserByEmailAddress(String emailAddress) throws DaoException;
	
}