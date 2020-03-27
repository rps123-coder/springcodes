package com.springdemo.mvc;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Value("#{countryOptions}") 
    private Map<String, String> countryOptions;
    
	@RequestMapping("/studentForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add student object to the model
		theModel.addAttribute("student", theStudent);
	
	    // add the country options to the model 
	    theModel.addAttribute("theCountryOptions", countryOptions);
	    
		return "StudentForm";
	}
	
	@RequestMapping("/displayForm")
	public String processForm(@Valid @ModelAttribute("student") Student theStudent, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()){
			return "StudentForm";
		}
		else{
			return "StudentConfirmation";	
		}
	}
	
}









