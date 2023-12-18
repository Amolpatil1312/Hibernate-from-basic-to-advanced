package com.csi.jpa;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int custId;

	private String custName;

	private String custAddress;

	private long custContactNumber;

	private double custAccountBalance;

	private Date custDOB;

	private String custEmailId;

	private String custPassword;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String custName, String custAddress, long custContactNumber, double custAccountBalance,
			Date custDOB, String custEmailId, String custPassword) {
		super();
		this.custName = custName;
		this.custAddress = custAddress;
		this.custContactNumber = custContactNumber;
		this.custAccountBalance = custAccountBalance;
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

	public long getCustContactNumber() {
		return custContactNumber;
	}

	public void setCustContactNumber(long custContactNumber) {
		this.custContactNumber = custContactNumber;
	}

	public double getCustAccountBalance() {
		return custAccountBalance;
	}

	public void setCustAccountBalance(double custAccountBalance) {
		this.custAccountBalance = custAccountBalance;
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
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		String custDOBDate = dateFormat.format(custDOB);
		return "Customer [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", custContactNumber=" + custContactNumber + ", custAccountBalance=" + custAccountBalance
				+ ", custDOB=" + custDOBDate + ", custEmailId=" + custEmailId + ", custPassword=" + custPassword + "]";
	}

}
