package com.niti.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.niti.dao.DaoException;
import com.niti.dao.IUserImmigrationDAO;
import com.niti.dao.entity.UserImmigrationEntity;

@Repository("userImmigrationDAOImpl")
public class UserImmigrationDAOImpl implements IUserImmigrationDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public UserImmigrationEntity findUserImmigrationByUserExperienceId(Integer userImmigrationId) throws DaoException {
		return entityManager.find(UserImmigrationEntity.class, userImmigrationId);
		
	}

	@Override
	public void addUserImmigration(UserImmigrationEntity userImmigration) throws DaoException {
		 entityManager.persist(userImmigration);
		
	}

	@Override
	public void updateUserImmigration(UserImmigrationEntity userImmigration) throws DaoException {
		entityManager.merge(userImmigration);
	}

	@Override
	public void deleteUserImmigration(UserImmigrationEntity userImmigration) throws DaoException {
		entityManager.remove(userImmigration);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserImmigrationEntity> getAllUserImmigrationByUserId(Integer userId) throws DaoException {
		Query query = entityManager.createQuery("select e from UserImmigrationEntity e where e.user.userId = :userId");
		query.setParameter("userId", userId);
		return (List<UserImmigrationEntity>) query.getResultList();
	
	}

}
