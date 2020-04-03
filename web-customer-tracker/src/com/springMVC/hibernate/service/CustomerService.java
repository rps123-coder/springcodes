package com.springMVC.hibernate.service;

import java.util.List;

import com.springMVC.hibernate.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

}
