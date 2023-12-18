package com.csi.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = "findbyname", query = "from Employee e where e.empName=:empName"),
		@NamedQuery(name = "findbyid", query = "from Employee e where e.empId=:empId") })

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int empId;

	private String empName;

	private double empSalary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, double empSalary) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}

}
