package com.niti.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niti.authentication.service.AuthenticationService;
import com.niti.bo.UserBO;
import com.niti.service.exception.ServiceBusinessException;

import org.slf4j.Logger;

@Controller
public class RegistrationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	private static final Logger Logger = LoggerFactory.getLogger(RegistrationController.class);

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String register(Model  model) {
		model.addAttribute("user", new UserBO());
		return "createUser";
	}
	
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public String persistUser(@ModelAttribute UserBO user) throws ServiceBusinessException {
		if (!authenticationService.userExists(user.getEmailAddress())) {
				authenticationService.createUser(user);
		}
		
		return "userDetails";
	}
	
}
