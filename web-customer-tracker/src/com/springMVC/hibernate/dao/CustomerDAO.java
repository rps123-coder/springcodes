package com.springMVC.hibernate.dao;

import java.util.List;

import com.springMVC.hibernate.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

}
