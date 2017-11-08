package com.niti.service;

import java.util.List;

import com.niti.bo.UserDependentBO;
import com.niti.service.exception.ServiceBusinessException;

public interface IUserDependentService {

	public UserDependentBO findUserDependentByUserDependentId(Integer userDependentId) throws ServiceBusinessException;

	public void addUserDependent(UserDependentBO userDependentBO) throws ServiceBusinessException;

	public void updateUserDependent(UserDependentBO userDependentBO) throws ServiceBusinessException;

	public void deleteUserDependent(Integer userDependentId) throws ServiceBusinessException;

	public List<UserDependentBO> getAllUserDependentsByUserId(Integer userId) throws ServiceBusinessException;
}
