package com.example.code.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.code.model.Customer;
import com.example.code.service.CustomerService;
import com.example.code.service.impl.CustomerServiceImpl;

public class CustomerController {

	private static final Logger log = LogManager.getLogger(CustomerController.class);

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		log.info("#CustomerController");

		CustomerController controller = new CustomerController();

		Scanner scanner = new Scanner(System.in);
		int optionSelected = 1;

		System.out.println("TYPE THE NUMBER IN THE CONSOLE TO EXECUTE METHOD: [1] getCustomerlist [2] addCustomer [3] updateCustomer [4] deleteCustomer [5] findCustomerId");
		optionSelected = scanner.nextInt();
		log.info("Option selected: " + optionSelected + "\n");

		switch (optionSelected) {
		case 1:
			controller.getCustomerList();
			break;
		case 2:
			controller.addCustomer();
			break;
		case 3:
			controller.updateCustomer();
			break;
		case 4:
			controller.deleteCustomer();
			break;
		case 5:
			controller.findCustomerById();
			break;
		}

	}

	public void addCustomer() {

		CustomerService customerService = new CustomerServiceImpl();
		Customer customer = new Customer();
		customer.setCompanyName("MonsterCorp");
		customer.setContactName("Kun Lao");
		customer.setAddress(null);
		customer.setMailContact("kunlao@example.com");
		customer.setPhoneNumber(null);
		customerService.addCustomer(customer);

	}

	@SuppressWarnings("unused")
	public void findCustomerById() {

		CustomerService customerService = new CustomerServiceImpl();
		Customer customer = customerService.findCustomerById(3);

	}

	public void updateCustomer() {

		CustomerService customerService = new CustomerServiceImpl();
		Customer customer = customerService.findCustomerById(3);
		customer.setAddress("Grand Line");
		customer.setPhoneNumber("999-999991");
		customerService.updateCustomer(customer);

	}

	public void deleteCustomer() {

		CustomerService customerService = new CustomerServiceImpl();
		customerService.deleteCustomer(3);

	}

	public void getCustomerList() {

		CustomerService customerService = new CustomerServiceImpl();
		List<Customer> customerList = customerService.getCustomerList();
		for (Customer customer : customerList) {
			System.out.println(customer);
		}

	}

}
