package com.niti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niti.bo.UserBO;

@Controller
public class LoginController {

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String register(Model  model) {
		model.addAttribute("user", new UserBO());
		return "createUser";
	}
	
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public String saveUser(Model model) {
		
		return "";
	}
	
}
