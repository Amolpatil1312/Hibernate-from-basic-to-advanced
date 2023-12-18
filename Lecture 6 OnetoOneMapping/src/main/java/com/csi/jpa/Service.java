package com.csi.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {
		Service service = new Service();

		//service.saveData();
		//service.findById(1);
		
		service.deleteById(1);
	}

	void saveData() {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Address address = new Address("AMANORA MALL", "PUNE", "MH", "INDIA", 411044);

		session.save(address);

		Employee employee = new Employee("SHUBHAM", 86000, address);

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
		Employee employee = (Employee) session.load(Employee.class, empId);
		session.delete(employee);

		transaction.commit();
	}

}
