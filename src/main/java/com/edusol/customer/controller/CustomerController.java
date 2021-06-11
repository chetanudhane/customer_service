package com.edusol.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.customer.model.Customer;
import com.edusol.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerService customerService;

	@GetMapping("/get-customers")
	public Object getCustomers() {
		@SuppressWarnings("unchecked")
		List<Customer> customers = (List<Customer>) customerService.getCustomers();
		logger.info(customers.toString());
		return customers;
	}
	
	@GetMapping("/get-customerbyid")
	public Object getCustomersById(@RequestParam int id) {
		return customerService.getCustomersById(id);
	}
	
	@GetMapping("/get-customerbyname")
	public Object getCustomersByName(@RequestParam String name) {
		return customerService.getCustomersByName(name);
	}

	@GetMapping("/get-customerbycity")
	public Object getCustomer(@RequestParam String city) {
		return customerService.getCustomers(city);
	}

	@PostMapping("add-customer")
	public Object addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}

	@PutMapping("/update-customer")
	public Object updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	@DeleteMapping("/delete-customer")
	public Object deleteCustomer(@RequestParam int customerId) {
		return customerService.deleteCustomer(customerId);
	}

}
