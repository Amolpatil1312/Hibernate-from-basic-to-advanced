package com.csi.jpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Service {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) throws ParseException {

		Service service = new Service();

		service.saveData();
		service.findAll();
	}

	void saveData() throws ParseException {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Customer customer = new Customer("SHUBHAM", "PUNE", 98989887867L, 45000, dateFormat.parse("09-09-2020"),
				"SHUBHAM@CS.COM", "SHUBHAM");

		session.save(customer);

		transaction.commit();

	}

	void findAll() {

		Session session = factory.openSession();

		session.createQuery("from Customer").list().forEach(System.out::println);;

		

	}
}
