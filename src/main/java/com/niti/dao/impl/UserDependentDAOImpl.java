package com.niti.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.niti.dao.DaoException;
import com.niti.dao.IUserDependentDAO;
import com.niti.dao.entity.UserDependentEntity;

@Repository("userDependentDAOImpl")
public class UserDependentDAOImpl implements IUserDependentDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public UserDependentEntity findUserDependentByUserDependentId(Integer userDependentId) throws DaoException {
		return entityManager.find(UserDependentEntity.class, userDependentId);
	}

	@Override
	public void addUserDependent(UserDependentEntity userDependent) throws DaoException {
		entityManager.persist(userDependent);
	}

	@Override
	public void updateUserDependent(UserDependentEntity userDependent) throws DaoException {
		entityManager.merge(userDependent);
	}

	@Override
	public void deleteUserDependentEntity(UserDependentEntity userDependent) throws DaoException {
		entityManager.remove(userDependent);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDependentEntity> getAllUserDependentsByUserId(Integer userId) throws DaoException {
		Query query = entityManager.createQuery("select e from UserDependentEntity e where e.user.userId = :userId");
		query.setParameter("userId", userId);
		return (List<UserDependentEntity>) query.getResultList();
	}

}
