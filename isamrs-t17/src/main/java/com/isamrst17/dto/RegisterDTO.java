package com.isamrst17.dto;

import com.isamrst17.model.Address;
import com.isamrst17.model.City;
import com.isamrst17.model.User;

public class RegisterDTO {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String city;

	public RegisterDTO(User user, Address address, City city) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.phoneNumber = user.getPhoneNumber();
		this.address = address.getAddress();
		this.city = city.getName();		
	}
	
	public RegisterDTO() {
		super();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
