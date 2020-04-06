package com.springdemo.controller;

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

import com.springdemo.entity.Customer;
import com.springdemo.exception.CustomerNotFoundException;
import com.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/customers")
	public List<Customer> getCustomer(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId){
		Customer customer=customerService.getCustomer(customerId);
		
		if(customer==null){
			throw new CustomerNotFoundException("Customer Id is not available :"+customerId);
		}
		
		return customer;
	}
	
	@PostMapping("/customers")
	public void addCustomer(@RequestBody Customer customer){
		customer.setId(0); //optional
		customerService.saveCustomer(customer);
	}
	
	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer customer){
		customerService.saveCustomer(customer);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public void updateCustomer(@PathVariable int customerId){
		customerService.deleteCustomer(customerId);
	}
	

}
