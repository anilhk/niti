package com.niti.service;

import java.util.List;

import com.niti.bo.UserBO;
import com.niti.service.exception.ServiceBusinessException;

public interface IUserService {

    public UserBO findUserByUserId(Integer userId) throws ServiceBusinessException;
	
	public void addUser(UserBO userBO) throws ServiceBusinessException;
	
	public void updateUser(UserBO userBO) throws ServiceBusinessException;
	
	public void deleteUser(Integer userId) throws ServiceBusinessException;
	
	public List<UserBO> getAllUsers() throws ServiceBusinessException;

}
