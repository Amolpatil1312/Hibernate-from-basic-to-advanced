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
		//service.findAll();
		
		service.updateData(1);
		
		//service.deleteById(2);
	}

	void saveData() {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Address address = new Address("AMANORA MALL", "PUNE", "MH", "INDIA", 411028);

		Employee employee = new Employee("SHUBHAM", 95000, 779898998, address);

		session.save(employee);

		transaction.commit();
	}

	void findById(int empId) {
		Session session = factory.openSession();

		Employee employee = (Employee) session.get(Employee.class, empId);

		System.out.println(employee);
	}

	void findAll() {

		Session session = factory.openSession();

		session.createQuery("from Employee").list().forEach(System.out::println);
	}

	void updateData(int empId) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = (Employee) session.get(Employee.class, empId);

		Address address = new Address();
		
		address.setAddressCity(employee.getAddress().getAddressCity());
		address.setAddressState("GJ");

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
