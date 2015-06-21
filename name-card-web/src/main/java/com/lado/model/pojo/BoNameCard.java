package com.lado.model.pojo;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

public class BoNameCard implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userDeviceId;
	private String name;
	private String email;
	private String address;
	private String phoneNumber;
	private String company;

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("userDeviceId", userDeviceId)
				.add("name", name)
				.add("email", email)
				.add("address", address)
				.add("phoneNumber", phoneNumber)
				.add("company", company)
				.toString();
	}

	public String getUserDeviceId() {
		return userDeviceId;
	}

	public void setUserDeviceId(String userDeviceId) {
		this.userDeviceId = userDeviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
