package com.csi.jpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Service {

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee("SWARAJ", 85000.96);

		session.persist(employee);

		transaction.commit();

	}

}
