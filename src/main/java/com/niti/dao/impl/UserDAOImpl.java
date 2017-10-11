package com.niti.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.niti.dao.DaoException;
import com.niti.dao.IUserDAO;
import com.niti.dao.entity.UserEntity;


@Repository("userDAOImpl")
public class UserDAOImpl implements IUserDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public UserEntity findUserByUserId(Integer userId) throws DaoException {
		return entityManager.find(UserEntity.class, userId);
	}

	@Override
	public void addUser(UserEntity user) throws DaoException {
		entityManager.persist(user);
	}

	@Override
	public void updateUser(UserEntity user) throws DaoException {
		entityManager.merge(user);
	}

	@Override
	public void deleteUser(UserEntity user)  throws DaoException{
		entityManager.remove(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserEntity> getAllUsers() throws DaoException {
		return (List<UserEntity>)entityManager.createQuery("select e from UserEntity e").getResultList();
		
	}

	

	
}
