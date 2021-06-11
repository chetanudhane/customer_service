package com.edusol.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByCustomerName(String name);
	List<Customer> findByCustomerCity(String city);
 
}
