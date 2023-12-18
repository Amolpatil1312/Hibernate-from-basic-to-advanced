package com.csi.service;

import com.csi.model.Customer;

public interface CustomerService {

	void signUp(Customer customer);

	boolean signIn(String custEmailId, String custPassword);
}
