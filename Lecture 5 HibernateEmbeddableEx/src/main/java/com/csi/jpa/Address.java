package com.csi.jpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String addressStreet;

	private String addressCity;

	private String addressState;

	private String addressCountry;

	private long addressPinCode;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String addressStreet, String addressCity, String addressState, String addressCountry,
			long addressPinCode) {
		super();
		this.addressStreet = addressStreet;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
		this.addressPinCode = addressPinCode;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public long getAddressPinCode() {
		return addressPinCode;
	}

	public void setAddressPinCode(long addressPinCode) {
		this.addressPinCode = addressPinCode;
	}

	@Override
	public String toString() {
		return "Address [addressStreet=" + addressStreet + ", addressCity=" + addressCity + ", addressState="
				+ addressState + ", addressCountry=" + addressCountry + ", addressPinCode=" + addressPinCode + "]";
	}

}
