package com.springBoot.curdDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBoot.curdDemo.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

		List<Employee> allEmployee = theQuery.getResultList();

		return allEmployee;
	}

	@Override
	public Employee findById(int theId) {
		
		Employee employee = entityManager.find(Employee.class, theId);

		return employee;
	}

	@Override
	public void save(Employee employee) {
		Employee dbEmployee=entityManager.merge(employee);
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
				
		Employee employee = entityManager.find(Employee.class, theId);

		entityManager.remove(employee);
	}

}
