package com.edusol.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusol.customer.model.Customer;
import com.edusol.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Object getCustomers() {
		
		return customerRepository.findAll();
	}

	public Object addCustomer(Customer customer) {
		customerRepository.save(customer);
		
		return "Customer added successfully";
	}
	
	public Object getCustomersById(int id) {
		return customerRepository.findById(id);
	}
	
	public Object getCustomersByName(String name) {
		
		return customerRepository.findByCustomerName(name);
	}

	public Object getCustomers(String city) {
		return customerRepository.findByCustomerCity(city);
	}

	public Object updateCustomer(Customer customer) {
		
		int id=customer.getCustomerId();
		
		Customer cust=customerRepository.getOne(id);
		
		cust.setCustomerCity(customer.getCustomerCity());
		// cust.setCustomerName(customer.getCustomerName());
		
		customerRepository.save(cust);
		
		return "Record updated successfully";
	}

	public Object deleteCustomer(int customerId) {
		
		customerRepository.deleteById(customerId);
		
		return "Customer Deleted Successfully.";
	}

	
}