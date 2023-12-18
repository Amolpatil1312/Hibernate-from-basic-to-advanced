package com.csi.service;

import java.util.List;

import com.csi.model.Customer;

public interface CustomerService {

	public void signUp(Customer customer);

	public boolean signIn(String custEmailId, String custPassword);

	public Customer findById(int custId);

	public List<Customer> findAll();

	public void updateData(int custId, Customer customer);

	public void deleteById(int custId);

	public void deleteAll();

}
