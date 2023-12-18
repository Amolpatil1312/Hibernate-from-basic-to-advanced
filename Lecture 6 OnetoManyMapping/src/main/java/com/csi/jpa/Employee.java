package com.csi.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int empId;

	private String empName;

	private double empSalary;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, double empSalary, List<Address> addresses) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
		this.addresses = addresses;
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

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", addresses="
				+ addresses + "]";
	}

}
