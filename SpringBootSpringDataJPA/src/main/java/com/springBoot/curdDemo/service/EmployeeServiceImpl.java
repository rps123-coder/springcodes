package com.springBoot.curdDemo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.curdDemo.dao.EmployeeRepository;
import com.springBoot.curdDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		Optional<Employee> result= employeeRepository.findById(theId);
		
		Employee theEmployee=null;
		
		if(result.isPresent()){
			return result.get();
		}
		
		return theEmployee; 
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
