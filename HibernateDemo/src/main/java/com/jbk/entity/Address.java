package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
 private int aid;
	private String city;
	private String state;
	private int pincode;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int aid, String city, String state, int pincode) {
		super();
		this.aid = aid;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
}
