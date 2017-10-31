package com.niti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niti.bo.UserBO;
import com.niti.service.IUserService;
import com.niti.service.exception.ServiceBusinessException;

@Controller
public class UserController {

	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping(value = "/user/{userId}/official", method = RequestMethod.GET)
	public String getUserOfficialInfo(@PathVariable("userId") Integer userId, Model model) throws ServiceBusinessException {
			
					UserBO userBO = userServiceImpl.findUserByUserId(userId);
					model.addAttribute("user", userBO);
					model.addAttribute("userId", userId);
					return "official";
	}
	
	@RequestMapping(value = "/user/{userId}/personal", method = RequestMethod.GET)
	public String getUserPersonalInfo(@PathVariable("userId") Integer userId, Model model) throws ServiceBusinessException {
			
					UserBO userBO = userServiceImpl.findUserByUserId(userId);
					model.addAttribute("user", userBO);
					model.addAttribute("userId", userId);
					return "personal";
	}
}
