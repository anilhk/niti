package com.niti.rest.v1.resource;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niti.bo.UserBO;
import com.niti.service.IUserService;
import com.niti.service.exception.ServiceBusinessException;

@Path("/users")
@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	@Autowired
	private IUserService userServiceImpl;
	
	@Autowired
	private UserExperienceResource userExperienceResource;
	
	@GET
	public List<UserBO> getUsers() throws ServiceBusinessException {
		return userServiceImpl.getAllUsers();
	}
	
	@GET
	@Path("/{userId}")
	public UserBO getUserById(@PathParam("userId") Integer userId) throws ServiceBusinessException {
		System.out.println("user " +userId);
		return userServiceImpl.findUserByUserId(userId);
	}
	
	
	@POST
	public void addUser(UserBO user) throws ServiceBusinessException {
		userServiceImpl.addUser(user);;
		
	}
	
	@DELETE
	@Path("/{userId}")
	public void deleteUser(@PathParam("userId") Integer userId) throws ServiceBusinessException {
			userServiceImpl.deleteUser(userId);;
	}
	
	@PUT
	@Path("/{userId}")
	public void updateUser(@PathParam("userId") Integer userId, UserBO user) throws ServiceBusinessException {
			userServiceImpl.updateUser(user);
	}
	
	@Path("/{userId}/experience")
	public UserExperienceResource getUserExperience(@PathParam("userId") Integer userId) {
		userExperienceResource.setUserId(userId);
		return userExperienceResource;
	}
	
}
