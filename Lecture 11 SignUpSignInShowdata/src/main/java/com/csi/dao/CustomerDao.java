package com.csi.dao;

import java.util.List;

import com.csi.model.Customer;

public interface CustomerDao {
	
	void signUp(Customer customer);
	
	boolean signIn(String custEmailId, String custPassword);
	
	List<Customer> findAll();

}
