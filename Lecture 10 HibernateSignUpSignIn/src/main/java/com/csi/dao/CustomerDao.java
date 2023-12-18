package com.csi.dao;

import com.csi.model.Customer;

public interface CustomerDao {
	
	void signUp(Customer customer);
	
	boolean signIn(String custEmailId, String custPassword);

}
