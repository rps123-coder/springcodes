package com.springMVC.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springMVC.hibernate.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public List<Customer> getCustomers() {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery=currentSession.createQuery("from Customer", Customer.class);
		
		List<Customer> customerList=theQuery.getResultList();
		
		return customerList;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.save(customer);
		
	}

}
