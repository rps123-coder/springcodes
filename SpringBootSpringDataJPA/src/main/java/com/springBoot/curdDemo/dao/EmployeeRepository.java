package com.springBoot.curdDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.curdDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//No need to write any code more..!!

}
