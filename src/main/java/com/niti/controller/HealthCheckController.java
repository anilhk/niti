package com.niti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HealthCheckController {

	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
}
