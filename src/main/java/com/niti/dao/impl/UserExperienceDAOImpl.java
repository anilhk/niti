package com.niti.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.niti.dao.DaoException;
import com.niti.dao.IUserExperienceDAO;
import com.niti.dao.entity.UserExperienceEntity;

@Repository("userExperienceDAOImpl")
public class UserExperienceDAOImpl implements IUserExperienceDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserExperienceEntity findUserExperienceByUserExperienceId(Integer userExperienceId) throws DaoException {
		return entityManager.find(UserExperienceEntity.class, userExperienceId);
	}

	@Override
	public void addUserExperience(UserExperienceEntity userExperience) throws DaoException {
		entityManager.persist(userExperience);
	}

	@Override
	public void updateUserExperience(UserExperienceEntity userExperience) throws DaoException {
		entityManager.merge(userExperience);
	}

	@Override
	public void deleteUserExperienceEntity(UserExperienceEntity userExperience) throws DaoException {
		entityManager.remove(userExperience);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserExperienceEntity> getAllUserExperiencesByUserId(Integer userId) throws DaoException {
		Query query = entityManager.createQuery("select e from UserExperienceEntity e where e.user.userId = :userId");
		query.setParameter("userId", userId);
		return (List<UserExperienceEntity>) query.getResultList();

	}

}
