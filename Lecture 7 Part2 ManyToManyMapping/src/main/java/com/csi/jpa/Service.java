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

		service.saveData();
	}

	void saveData() {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		List<Employee> empList = new LinkedList<Employee>();

		List<Address> addressList = new LinkedList<Address>();

		Employee employee1 = new Employee("SWARA", 65000, addressList);

		Employee employee2 = new Employee("SHUBHAM", 95000, addressList);

		empList.add(employee1);
		empList.add(employee2);
		session.save(employee1);

		session.save(employee2);

		Address address1 = new Address("INSPIRIA MALL", "PCMC", "MH", "INDIA", 411044, empList);

		Address address2 = new Address("AMANORA MALL", "PUNE", "MH", "INDIA", 411028, empList);

		addressList.add(address1);
		addressList.add(address2);
		session.save(address1);

		session.save(address2);

		transaction.commit();

	}

}
