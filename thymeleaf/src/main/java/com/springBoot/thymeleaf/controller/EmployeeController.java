package com.springBoot.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.thymeleaf.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private List<Employee> theEmployee;
	
	@PostConstruct
	private void loadData(){
		Employee emp1=new Employee(1,"Raj","Singh","abc@gmail.com");
		Employee emp2=new Employee(2,"Vikas","Singh","abc@gmail.com");
		Employee emp3=new Employee(3,"Papu","Singh","abc@gmail.com");
		Employee emp4=new Employee(4,"Chintu","Singh","abc@gmail.com");
		
		theEmployee=new ArrayList<Employee>();
		theEmployee.add(emp1);
		theEmployee.add(emp2);
		theEmployee.add(emp3);
		theEmployee.add(emp4);
	}
	
	@GetMapping("/list")
	public String getList(Model model){
		model.addAttribute("employee",theEmployee);
		return "list-employees";
	}

}
