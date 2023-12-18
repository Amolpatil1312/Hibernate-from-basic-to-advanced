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

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public static void main(String[] args) throws ParseException {

		Service service = new Service();
		// service.saveData();
		// service.findById(3);
		// service.updateData(2);

		// service.deleteById(2);

		//service.deleteAllData();
		///service.findAll();
		
		service.filterByPrice();

	}

	void saveData() throws ParseException {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Product product = new Product("APPLE TV", 45000, dateFormat.parse("11-11-2000"));

		session.save(product);

		transaction.commit();

	}

	void findById(int productId) {

		Session session = factory.openSession();

		Product product = (Product) session.load(Product.class, productId);

		System.out.println(product);

	}

	void findAll() {

		Session session = factory.openSession();

		session.createQuery("from Product").list().forEach(System.out::println);

	}

	void updateData(int productId) throws ParseException {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Product product = (Product) session.load(Product.class, productId);

		product.setProductName("LENOVO LAPTOP");
		product.setProductPrice(65000);
		product.setProductLaunchDate(dateFormat.parse("22-11-2020"));

		session.update(product);

		transaction.commit();
	}

	void deleteById(int productId) {
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Product product = (Product) session.load(Product.class, productId);

		session.delete(product);

		transaction.commit();

	}

	void deleteAllData() {

		Session session = factory.openSession();

		List<Product> products = session.createQuery("from Product").list();

		for (Product product : products) {
			Transaction transaction = session.beginTransaction();
			session.delete(product);
			transaction.commit();
		}

	}

	void filterByPrice() {

		Session session = factory.openSession();

		List<Product> products = session.createQuery("from Product").list();// .forEach(System.out::println);

		products.stream().filter(p -> p.getProductPrice() >= 50000).forEach(System.out::println);
	}

}
