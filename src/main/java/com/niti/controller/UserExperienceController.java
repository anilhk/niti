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

import com.niti.bo.UserExperienceBO;
import com.niti.service.IUserExperienceService;
import com.niti.service.exception.ServiceBusinessException;
import com.niti.validator.UserExperienceValidator;

@Controller
public class UserExperienceController {

	@Autowired
	private UserExperienceValidator userExperienceValidator;
	
	@Autowired
	private IUserExperienceService userExperienceServiceImpl;
	
		
	@InitBinder("userExperienceBO")
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(userExperienceValidator);
	}
	
	@RequestMapping(value = "/user/{userId}/experiences", method = RequestMethod.GET)
	public String getUserExperiences(@PathVariable("userId") Integer userId, Model model) throws ServiceBusinessException {
			
					List<UserExperienceBO> userExperienceBOs = userExperienceServiceImpl.getAllUserExperiencesByUserId(userId);
					model.addAttribute("userExperienceBOs", userExperienceBOs);
					model.addAttribute("userId", userId);
					return "experience";
	}

	@RequestMapping(value = "/user/{userId}/experience/{experienceId}", method = RequestMethod.GET)
	public UserExperienceBO getUserExperienceInfo(@PathVariable("userId") Integer userId,
			@PathVariable("experienceId") Integer experienceId) throws ServiceBusinessException {
		return userExperienceServiceImpl.findUserExperienceByUserExperienceId(experienceId);

	}

	@RequestMapping(value = "/user/{userId}/experience/", method = RequestMethod.POST)
	public void addUserExperience(@ModelAttribute("userExperienceBO") @Validated UserExperienceBO userExperienceBO,
			BindingResult result, Model model) throws ServiceBusinessException {

		userExperienceServiceImpl.addUserExperience(userExperienceBO);
	}


	@RequestMapping(value = "/user/{userId}/experience/{experienceId}", method = RequestMethod.DELETE)
	public void updateUserExperience(@PathVariable("experienceId") Integer experienceId, Model model) throws ServiceBusinessException {
		userExperienceServiceImpl.deleteUserExperience(experienceId);
	}


	

}
