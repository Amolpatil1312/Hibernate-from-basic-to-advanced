package com.csi.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int productId;

	private String productName;

	private double productPrice;

	private Date productLaunchDate;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, double productPrice, Date productLaunchDate) {

		this.productName = productName;
		this.productPrice = productPrice;
		this.productLaunchDate = productLaunchDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductLaunchDate() {
		return productLaunchDate;
	}

	public void setProductLaunchDate(Date productLaunchDate) {
		this.productLaunchDate = productLaunchDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productLaunchDate=" + productLaunchDate + "]";
	}

}
