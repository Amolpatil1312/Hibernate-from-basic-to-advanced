package com.csi.service;

import java.util.List;

import com.csi.model.Customer;

public interface CustomerService {
	
	void signUp(Customer customer);
	
	boolean signIn(String custEmailId, String custPassword);
	
	List<Customer> findAll();


}
