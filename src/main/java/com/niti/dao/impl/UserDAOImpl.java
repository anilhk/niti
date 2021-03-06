package com.niti.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public boolean findUserByEmailAddress(String emailAddress) throws DaoException {
		Query query = entityManager.createQuery("select e from UserEntity e where e.emailAddress = :emailAddress");
		query.setParameter("emailAddress", emailAddress);
		return (query.getResultList() != null && !query.getResultList().isEmpty() && query.getResultList().size() > 0);
		
	}

	@Override
	public UserEntity findUserByEmailAddressAndPassword(String emailAddress, String password) throws DaoException {
		Query query = entityManager.createQuery("select e from UserEntity e where e.emailAddress = :emailAddress and e.password = :password");
		query.setParameter("emailAddress", emailAddress);
		query.setParameter("password", password);
		return null;
	}

	@Override
	public UserEntity getUserByEmailAddress(String emailAddress) throws DaoException {
		Query query = entityManager.createQuery("select e from UserEntity e where e.emailAddress = :emailAddress");
		query.setParameter("emailAddress", emailAddress);
		
		if (query.getResultList() == null || query.getResultList().isEmpty() || query.getResultList().size() == 0) {
			return null;
		}else {
			return (UserEntity)query.getResultList().get(0);
		}
	}

	

	
}
