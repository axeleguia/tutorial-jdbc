package com.example.code.service;

import java.util.List;

import com.example.code.model.Customer;

public interface CustomerService {

	Customer findCustomerById(int id);
	List<Customer> getCustomerList();
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(int id);
	boolean addCustomer(Customer customer);
	
}
