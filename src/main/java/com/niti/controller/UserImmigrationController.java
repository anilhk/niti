package com.niti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niti.bo.UserImmigrationBO;
import com.niti.service.IUserImmigrationService;
import com.niti.service.exception.ServiceBusinessException;
import com.niti.validator.UserImmigrationValidator;

@Controller
public class UserImmigrationController {

	@Autowired
	private UserImmigrationValidator userImmigrationValidator;
	
	@Autowired
	private IUserImmigrationService userImmigrationServiceImpl;
	
	
	
	@InitBinder("userImmigrationBO")
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(userImmigrationValidator);
	}
	
	@RequestMapping(value = "/user/{userId}/immigrations", method = RequestMethod.GET)
	public String getUserImmigrations(@PathVariable("userId") Integer userId, Model model) throws ServiceBusinessException {
			
					List<UserImmigrationBO> userImmigrations = userImmigrationServiceImpl.getAllUserImmigrationsByUserId(userId);
					model.addAttribute("userImmigrationsBOs", userImmigrations);
					model.addAttribute("userId", userId);
					return "immigration";
	}

	@RequestMapping(value = "/user/{userId}/immigration/{userImmigrationId}", method = RequestMethod.GET)
	public UserImmigrationBO getUserImmigrationInfo(@PathVariable("userId") Integer userId,
			@PathVariable("userImmigrationId") Integer userImmigrationId) throws ServiceBusinessException {
		return userImmigrationServiceImpl.findUserImmigrationByUserImmigrationId(userImmigrationId);

	}

	@RequestMapping(value = "/user/{userId}/immigration/", method = RequestMethod.POST)
	public void addUserImmigration(@ModelAttribute("userImmigrationBO") @Validated UserImmigrationBO userImmigrationBO,
			BindingResult result, Model model) throws ServiceBusinessException {

		userImmigrationServiceImpl.addUserImmigration(userImmigrationBO);
	}


	@RequestMapping(value = "/user/{userId}/immigration/{userImmigrationId}", method = RequestMethod.DELETE)
	public void updateUserImmigration(@PathVariable("experienceId") Integer userImmigrationId, Model model) throws ServiceBusinessException {
		userImmigrationServiceImpl.deleteUserImmigration(userImmigrationId);
	}


}
