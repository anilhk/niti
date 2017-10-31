package com.niti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niti.authentication.service.AuthenticationService;
import com.niti.bo.UserBO;
import com.niti.service.exception.ServiceBusinessException;
import com.niti.validator.UserRegistrationValidator;

@Controller
public class RegistrationController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private UserRegistrationValidator userRegistrationValidator;


	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(userRegistrationValidator);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new UserBO());
		return "createUser";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String persistUser(@ModelAttribute("user") @Validated UserBO user, BindingResult result)
			throws ServiceBusinessException {
		
		if (authenticationService.userExists(user.getEmailAddress())) {
				result.rejectValue("emailAddress", "user.emailAddress.exists");
				return "createUser";
		} 
		
		if (result.hasErrors()) {
				return "createUser";
		}
		
			authenticationService.createUser(user);
			return "dashboard";
		}

}

