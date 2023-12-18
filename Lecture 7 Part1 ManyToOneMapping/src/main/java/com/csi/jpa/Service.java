package com.csi.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {

		Service service = new Service();

		// service.saveData();

		// service.findById(1);

		// service.updateData(1);
		
		service.deleteById(2);
	}

	void saveData() {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Address address = new Address("INSPIRIA MALL", "PCMC", "MH", "INDIA", 411044);

		session.save(address);

		Employee employee1 = new Employee("SWARA", 65000, address);

		Employee employee2 = new Employee("VAIBHAV", 97000, address);

		session.save(employee1);
		session.save(employee2);

		transaction.commit();
	}

	void findById(int empId) {
		Session session = factory.openSession();

		Employee employee = (Employee) session.load(Employee.class, empId);

		System.out.println(employee);
	}

	void updateData(int empId) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = (Employee) session.load(Employee.class, empId);

		Address address = employee.getAddress();

		address.setAddressStreet("AMANORA MALL");

		employee.setAddress(address);

		session.update(employee);

		transaction.commit();

	}

	void deleteById(int empId) {
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = (Employee) session.load(Employee.class, empId);

		session.delete(employee);

		transaction.commit();
	}

}
