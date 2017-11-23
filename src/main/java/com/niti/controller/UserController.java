package com.niti.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niti.bo.UserBO;
import com.niti.constants.Ethnicity;
import com.niti.constants.Gender;
import com.niti.constants.MaritalStatus;
import com.niti.service.IUserService;
import com.niti.service.exception.ServiceBusinessException;

@Controller
public class UserController {

	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping(value = "/user/{userId}/official", method = RequestMethod.GET)
	public String getUserOfficialInfo(@PathVariable("userId") Integer userId, Model model) throws ServiceBusinessException {
			
					UserBO userBO = userServiceImpl.findUserByUserId(userId);
					System.out.println("get call for secondary contact info " +userBO.getSecondaryContactNumber());
					model.addAttribute("user", userBO);
					model.addAttribute("userId", userId);
					model.addAttribute("genders", EnumSet.allOf(Gender.class));
					return "official";
	}
	
	
	@RequestMapping(value = "/user/{userId}/official", method = RequestMethod.POST)
	public String updateUserOfficialInfo(@PathVariable("userId") String userId, @ModelAttribute("user") UserBO user,BindingResult result, Model model) throws ServiceBusinessException {
			
					System.out.println("secondaryContactNumber =" +user.getSecondaryContactNumber());
					userServiceImpl.updateUserOfficialInformation(user);
					UserBO userBO = userServiceImpl.findUserByUserId(Integer.parseInt(userId));
					model.addAttribute("user", userBO);
					model.addAttribute("userId", userId);
					model.addAttribute("genders", EnumSet.allOf(Gender.class));
					return "official";
	}
	
	@RequestMapping(value = "/user/{userId}/personal", method = RequestMethod.GET)
	public String getUserPersonalInfo(@PathVariable("userId") Integer userId, Model model) throws ServiceBusinessException {
			
					UserBO userBO = userServiceImpl.findUserByUserId(userId);
					model.addAttribute("user", userBO);
					model.addAttribute("userId", userId);
					model.addAttribute("genders", EnumSet.allOf(Gender.class));
					model.addAttribute("maritalStatuses", EnumSet.allOf(MaritalStatus.class));
					model.addAttribute("ethnicities", EnumSet.allOf(Ethnicity.class));
					System.out.println(EnumSet.allOf(Ethnicity.class));
					return "personal";
	}
	
	
	@RequestMapping(value = "/user/{userId}/personal", method = RequestMethod.POST)
	public String updatePersonalInfo(@PathVariable("userId") Integer userId, @ModelAttribute("user") UserBO user,BindingResult result, Model model) throws ServiceBusinessException {
			
					System.out.println("&&&&&&&&&&&&&&&&&&&&" +user.getDateOfBirth());
					userServiceImpl.updateUserProfileInformation(user);
					UserBO userBO = userServiceImpl.findUserByUserId(userId);
					model.addAttribute("user", userBO);
					model.addAttribute("userId", userId);
					model.addAttribute("genders", EnumSet.allOf(Gender.class));
					model.addAttribute("maritalStatuses", EnumSet.allOf(MaritalStatus.class));
					model.addAttribute("ethnicities", EnumSet.allOf(Ethnicity.class));
					System.out.println(EnumSet.allOf(Ethnicity.class));
					return "personal";
	}
}
