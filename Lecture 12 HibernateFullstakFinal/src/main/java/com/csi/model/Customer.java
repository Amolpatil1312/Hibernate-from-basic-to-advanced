package com.csi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	private int custId;

	private String custName;

	private String custAddress;

	private double custAccBalance;

	private long custContactNumber;

	private String custGender;

	private String custDepartment;

	private String custState;

	private Date custDOB;

	private String custEmailId;

	private String custPassword;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String custName, String custAddress, double custAccBalance, long custContactNumber,
			String custGender, String custDepartment, String custState, Date custDOB, String custEmailId,
			String custPassword) {
		super();
		this.custName = custName;
		this.custAddress = custAddress;
		this.custAccBalance = custAccBalance;
		this.custContactNumber = custContactNumber;
		this.custGender = custGender;
		this.custDepartment = custDepartment;
		this.custState = custState;
		this.custDOB = custDOB;
		this.custEmailId = custEmailId;
		this.custPassword = custPassword;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public double getCustAccBalance() {
		return custAccBalance;
	}

	public void setCustAccBalance(double custAccBalance) {
		this.custAccBalance = custAccBalance;
	}

	public long getCustContactNumber() {
		return custContactNumber;
	}

	public void setCustContactNumber(long custContactNumber) {
		this.custContactNumber = custContactNumber;
	}

	public String getCustGender() {
		return custGender;
	}

	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}

	public String getCustDepartment() {
		return custDepartment;
	}

	public void setCustDepartment(String custDepartment) {
		this.custDepartment = custDepartment;
	}

	public String getCustState() {
		return custState;
	}

	public void setCustState(String custState) {
		this.custState = custState;
	}

	public Date getCustDOB() {
		return custDOB;
	}

	public void setCustDOB(Date custDOB) {
		this.custDOB = custDOB;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", custAccBalance=" + custAccBalance + ", custContactNumber=" + custContactNumber + ", custGender="
				+ custGender + ", custDepartment=" + custDepartment + ", custState=" + custState + ", custDOB="
				+ custDOB + ", custEmailId=" + custEmailId + ", custPassword=" + custPassword + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(custAccBalance, custAddress, custContactNumber, custDOB, custDepartment, custEmailId,
				custGender, custId, custName, custPassword, custState);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Double.doubleToLongBits(custAccBalance) == Double.doubleToLongBits(other.custAccBalance)
				&& Objects.equals(custAddress, other.custAddress) && custContactNumber == other.custContactNumber
				&& Objects.equals(custDOB, other.custDOB) && Objects.equals(custDepartment, other.custDepartment)
				&& Objects.equals(custEmailId, other.custEmailId) && Objects.equals(custGender, other.custGender)
				&& custId == other.custId && Objects.equals(custName, other.custName)
				&& Objects.equals(custPassword, other.custPassword) && Objects.equals(custState, other.custState);
	}

}
