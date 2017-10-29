package com.niti.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niti.authentication.service.AuthenticationService;
import com.niti.bo.UserBO;
import com.niti.service.exception.ServiceBusinessException;

@Controller
public class LoginController {

	private static final Logger Logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("user", new UserBO());
		return "login";
	}
	
	@RequestMapping(value="/validateUser" , method=RequestMethod.POST)
	public String processLoginInfo(@ModelAttribute("user") @Validated UserBO user, BindingResult result, Model model) throws ServiceBusinessException {
		
		UserBO userBO = authenticationService.authenticateUser(user,result);
		model.addAttribute("user",userBO);	
			if (result.hasErrors()) {
				return "login";
			}
			
			return "dashboard";
	
}	
	
}
