package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.csi.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	
	
	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public void signUp(Customer customer) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.persist(customer);

		transaction.commit();
	}

	@Override
	public boolean signIn(String custEmailId, String custPassword) {
		// TODO Auto-generated method stub

		boolean flag = false;

		for (Customer customer : findAll()) {
			if (customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)) {
				flag = true;
			}
		}

		return flag;
	}

	@Override
	public Customer findById(int custId) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		Customer customer = (Customer) session.get(Customer.class, custId);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		return session.createQuery("from Customer").list();
	}

	@Override
	public void updateData(int custId, Customer customer) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Customer customer2 = findById(custId);

		customer2.setCustName(customer.getCustName());
		customer2.setCustAccountBalance(customer.getCustAccountBalance());
		customer2.setCustAddress(customer.getCustAddress());
		customer2.setCustContactNumber(customer.getCustContactNumber());
		customer2.setCustDOB(customer.getCustDOB());
		customer2.setCustEmailId(customer.getCustEmailId());
		customer2.setCustPassword(customer.getCustPassword());

		session.merge(customer2);
		transaction.commit();

	}

	@Override
	public void deleteById(int custId) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Customer customer2 = findById(custId);

		session.delete(customer2);
		transaction.commit();

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		for (Customer customer : findAll()) {
			Transaction transaction = session.beginTransaction();

			session.delete(customer);

			transaction.commit();
		}
	}

}
