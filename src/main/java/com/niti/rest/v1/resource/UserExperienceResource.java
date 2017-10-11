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

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niti.bo.UserBO;
import com.niti.bo.UserExperienceBO;
import com.niti.service.IUserExperienceService;
import com.niti.service.exception.ServiceBusinessException;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class UserExperienceResource {

	@Autowired
	private IUserExperienceService userExperienceServiceImpl;
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(UserExperienceResource.class);
	
	private Integer userId;
	
	@GET
	@Path("/{userExperienceId}")
	public UserExperienceBO getUserExperienceByid(@PathParam("userExperienceId") Integer userExperienceId) throws ServiceBusinessException {
		System.out.println("userexperienceid " +userExperienceId);
		return userExperienceServiceImpl.findUserExperienceByUserExperienceId(userExperienceId);
	}
	
	@GET
	public List<UserExperienceBO> getAllUserExperiencesByUserId() throws ServiceBusinessException {
		logger.debug("User id :" +getUserId());
		return userExperienceServiceImpl.getAllUserExperiencesByUserId(getUserId());
	}
	
	@DELETE
	@Path("/{userExperienceId}")
	public void deleteUserExperience(@PathParam("userExperienceId") Integer userExperienceId) throws ServiceBusinessException {
		 userExperienceServiceImpl.deleteUserExperience(userExperienceId);
	}
	
	@POST
	public void addUserExperience(UserExperienceBO userExperienceBO) throws ServiceBusinessException {
		userExperienceBO.getUser().setUserId(getUserId());
		userExperienceServiceImpl.addUserExperience(userExperienceBO);
	}

	@PUT
	@Path("/{userExperienceId}")
	public void updateUserExperience(@PathParam("userExperienceId") Integer userExperienceId, UserExperienceBO userExperienceBO) throws ServiceBusinessException {
		userExperienceBO.getUser().setUserId(getUserId());
		userExperienceServiceImpl.updateUserExperience(userExperienceBO);
	}
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
}
