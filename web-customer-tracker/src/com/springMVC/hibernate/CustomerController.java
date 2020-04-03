package com.springMVC.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springMVC.hibernate.dao.CustomerDAO;
import com.springMVC.hibernate.entity.Customer;
import com.springMVC.hibernate.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	/*@RequestMapping("/list") : this request mapping is a Get or Post request. we can replace it with below annotation also*/
	@GetMapping("/list")   /*for Post method use @PostMapping("/list")*/
	public String listCustomer(Model model){
		
		List<Customer> theCustomer=customerService.getCustomers();
		
		model.addAttribute("theCustomer",theCustomer);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		
		Customer customer=new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute(name="customer")Customer customer){
		
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}

}
