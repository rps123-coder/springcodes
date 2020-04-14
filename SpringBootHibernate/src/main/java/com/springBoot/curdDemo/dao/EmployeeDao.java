package com.springBoot.curdDemo.dao;

import java.util.List;

import com.springBoot.curdDemo.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee employee);
	
	public void deleteById(int theId);

}
