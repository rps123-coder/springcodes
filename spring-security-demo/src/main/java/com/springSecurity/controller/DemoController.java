package com.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping("/")
	public String sayHello(){
		return "hello";
	}
	
	@GetMapping("/showLoginPage")
	public String loginPage(){
		return "login-page";
	}
	
	@GetMapping("/leaders")
	public String leadersPage(){
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String adminPage(){
		return "admin";
	}
	
	@GetMapping("/access-denied")
	public String exceptionPage(){
		return "access-denied";
	}

}
