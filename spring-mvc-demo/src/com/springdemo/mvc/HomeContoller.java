package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeContoller {
	
	@RequestMapping("/")
	public String showPage(){
		return "MainMenu";
	}
	
	@RequestMapping("/showForm")
	public String showForm(){
		return "ShowForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm(HttpServletRequest request, Model model){
		String theName=request.getParameter("studentName");
		model.addAttribute("theName", theName);
		return "ProcessForm";
	}

	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(@RequestParam("studentName") String theName, Model model){
		model.addAttribute("theName", theName);
		return "ProcessForm";
	}
}
