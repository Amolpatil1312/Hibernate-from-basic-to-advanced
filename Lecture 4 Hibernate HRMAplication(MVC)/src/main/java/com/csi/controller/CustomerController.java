package com.csi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import com.csi.service.CustomerServiceImpl;

public class CustomerController {

	CustomerService customerServiceImpl = new CustomerServiceImpl();

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public static void main(String[] args) throws ParseException {
		CustomerController controller = new CustomerController();

		 controller.signUp();

		// controller.signIn();

		// controller.findById(4);

		// controller.findAll();

		// controller.updateData(4);

		// controller.deleteById(4);

		// controller.findByName("SWARA");

		// controller.findByContactNumber(9229898989L);

		// controller.sortByName();

		//controller.sortByAccBalance();
		
		//controller.filterByAccBalance();
		//controller.deleteAll();
	}

	void signUp() throws ParseException {
		Customer customer = new Customer("SWARAJ", "PCMC", 96000, 9229844989L, dateFormat.parse("11-11-1998"),
				"SWARAJ@CS.COM", "SWARAJ@2020");
		customerServiceImpl.signUp(customer);

	}

	void signIn() {
		if (customerServiceImpl.signIn("SHUBHAM@CS.COM", "VAIBHAV@2020")) {
			System.out.println("SignIn Successfully");
		} else {
			System.out.println("Invalid credentials");
		}
	}

	void findById(int custId) {
		System.out.println(customerServiceImpl.findById(custId));
	}

	void findAll() {
		customerServiceImpl.findAll().forEach(System.out::println);
	}

	void updateData(int custId) throws ParseException {

		// Customer customer = new Customer("SHUBHAM", "INDIA", 89000,
		// 9229898459L,dateFormat.parse("11-11-2002"), "SHUBHAM@CS.COM",
		// "SHUBHAM@2020");

		Customer customer = new Customer();

		customer.setCustName("SWARAJ"); // Defect we need to FIX it
		customerServiceImpl.updateData(custId, customer);
	}

	void deleteById(int custId) {
		customerServiceImpl.deleteById(custId);
	}

	void findByName(String custName) {

		customerServiceImpl.findAll().stream().filter(c -> c.getCustName().equals(custName))
				.forEach(System.out::println);
	}

	void findByContactNumber(long custContactNumber) {
		customerServiceImpl.findAll().stream().filter(c -> c.getCustContactNumber() == custContactNumber)
				.forEach(System.out::println);
	}

	void sortByName() {
		customerServiceImpl.findAll().stream().sorted(Comparator.comparing(Customer::getCustName))
				.forEach(System.out::println);
	}

	void sortByAccBalance() {
		customerServiceImpl.findAll().stream()
				.sorted(Comparator.comparingDouble(Customer::getCustAccountBalance).reversed())
				.forEach(System.out::println);
	}

	void filterByAccBalance() {
		customerServiceImpl.findAll().stream().filter(c -> c.getCustAccountBalance() >= 50000.00)
				.forEach(System.out::println);
	}
	
	void deleteAll() {
		customerServiceImpl.deleteAll();
	}

}
