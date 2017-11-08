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

import com.niti.bo.UserDependentBO;
import com.niti.service.IUserDependentService;
import com.niti.service.exception.ServiceBusinessException;
import com.niti.validator.UserDependentValidator;

@Controller
public class UserDependentController {

	@Autowired
	private UserDependentValidator userDependentValidator;
	
	@Autowired
	private IUserDependentService userDependentServiceImpl;
	
		
	@InitBinder("userDependentBO")
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(userDependentValidator);
	}
	
	@RequestMapping(value = "/user/{userId}/dependents", method = RequestMethod.GET)
	public String getUserDependents(@PathVariable("userId") Integer userId, Model model) throws ServiceBusinessException {
			
					List<UserDependentBO> userDependentBOs = userDependentServiceImpl.getAllUserDependentsByUserId(userId);
					model.addAttribute("userDependentBOs", userDependentBOs);
					model.addAttribute("userId", userId);
					return "dependent";
	}

	@RequestMapping(value = "/user/{userId}/dependent/{dependentId}", method = RequestMethod.GET)
	public UserDependentBO getUserDependentInfo(@PathVariable("userId") Integer userId,
			@PathVariable("dependentId") Integer dependentId) throws ServiceBusinessException {
		return userDependentServiceImpl.findUserDependentByUserDependentId(dependentId);

	}

	@RequestMapping(value = "/user/{userId}/dependent/", method = RequestMethod.POST)
	public void addUserDependent(@ModelAttribute("userDependentBO") @Validated UserDependentBO userDependentBO,
			BindingResult result, Model model) throws ServiceBusinessException {

		userDependentServiceImpl.addUserDependent(userDependentBO);
	}


	@RequestMapping(value = "/user/{userId}/dependent/{dependentId}", method = RequestMethod.DELETE)
	public void updateUserDependent(@PathVariable("dependentId") Integer dependentId, Model model) throws ServiceBusinessException {
		userDependentServiceImpl.deleteUserDependent(dependentId);
	}


	

}
