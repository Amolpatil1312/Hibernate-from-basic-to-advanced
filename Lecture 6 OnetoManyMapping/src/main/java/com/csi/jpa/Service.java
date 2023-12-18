package com.csi.jpa;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {
		Service service = new Service();

		//service.saveData();

		//service.findById(2);
		
		service.deleteById(1);
	}

	void saveData() {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Address address1 = new Address("ABC MALL", "PCMC", "MH", "INDIA", 411044);

		Address address2 = new Address("XYZ MALL", "PUNE", "MH", "INDIA", 411028);

		session.save(address1);

		session.save(address2);

		List<Address> addresses = new LinkedList<Address>();

		addresses.add(address1);
		addresses.add(address2);

		Employee employee = new Employee("SHUBHAM", 96000, addresses);

		session.save(employee);

		transaction.commit();
	}

	void findById(int empId) {

		Session session = factory.openSession();

		Employee employee = (Employee) session.get(Employee.class, empId);

		System.out.println(employee);
	}

	void deleteById(int empId) {
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, empId);

		session.delete(employee);
		transaction.commit();

	}

}
