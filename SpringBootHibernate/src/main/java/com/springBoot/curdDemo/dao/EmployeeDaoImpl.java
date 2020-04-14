package com.springBoot.curdDemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
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

		Session session = entityManager.unwrap(Session.class);

		Query<Employee> theQuery = session.createQuery("from Employee", Employee.class);

		List<Employee> allEmployee = theQuery.getResultList();

		return allEmployee;
	}

	@Override
	public Employee findById(int theId) {
		Session session = entityManager.unwrap(Session.class);

		Employee employee = session.get(Employee.class, theId);

		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		
		Query theQuery = session.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();
	}

}
