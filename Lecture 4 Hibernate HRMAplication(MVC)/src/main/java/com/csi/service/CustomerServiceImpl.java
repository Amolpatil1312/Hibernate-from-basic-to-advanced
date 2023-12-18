package com.csi.service;

import java.util.List;

import com.csi.dao.CustomerDao;
import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDaoImpl = new CustomerDaoImpl();

	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub
		customerDaoImpl.signUp(customer);
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub
		return customerDaoImpl.signIn(custEmailId, custPassword);
	}

	@Override
	public Customer findById(int custId) {
		// TODO Auto-generated method stub
		return customerDaoImpl.findById(custId);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDaoImpl.findAll();
	}

	@Override
	public void updateData(int custId, Customer customer) {
		// TODO Auto-generated method stub
		customerDaoImpl.updateData(custId, customer);
	}

	@Override
	public void deleteById(int custId) {
		// TODO Auto-generated method stub
		customerDaoImpl.deleteById(custId);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		customerDaoImpl.deleteAll();
	}

}
