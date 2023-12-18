package com.csi.service;

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

}
