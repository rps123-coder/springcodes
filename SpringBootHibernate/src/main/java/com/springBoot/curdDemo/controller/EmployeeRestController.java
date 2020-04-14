package com.springBoot.curdDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.curdDemo.entity.Employee;
import com.springBoot.curdDemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeId}")
	public Employee getAllEmployee(@PathVariable int employeId) {
		return employeeService.findById(employeId);
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}

	@DeleteMapping("/employees/{employeId}")
	public void deleteEmployee(@PathVariable int employeId) {
		employeeService.deleteById(employeId);
	}

}
