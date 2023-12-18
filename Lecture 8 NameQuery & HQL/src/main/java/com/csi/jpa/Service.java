package com.csi.jpa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class Service {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	public static void main(String[] args) {
		Service service = new Service();

		// service.saveData();

		//service.findByName("KUMAR");
		
		//service.findById(2);
		
		//service.hcql();
		
		service.aggFunctions();
	}

	void saveData() {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee("SWARA", 25000);

		session.save(employee);

		transaction.commit();
	}

	void findByName(String empName) {

		Session session = factory.openSession();
		Query query = session.getNamedQuery("findbyname");

		List<Employee> employees = query.setParameter("empName", empName).list();

		System.out.println(employees);
	}

	void findById(int empId) {

		Session session = factory.openSession();
		Query query = session.getNamedQuery("findbyid");

		List<Employee> employees = query.setParameter("empId", empId).list();

		System.out.println(employees);
	}
	
	void hcql() {
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(Employee.class);
		
		Criterion criterion = Restrictions.eq("empName", "KUMAR");
		
		List<Employee> employees = criteria.add(criterion).list();
		
		System.out.println(employees);
	}
	
	void aggFunctions() {
		Session session = factory.openSession();
		
		List<Employee> employees = session.createQuery("select AVG(empSalary) from Employee").list();
		
		System.out.println(employees);
	}

}
