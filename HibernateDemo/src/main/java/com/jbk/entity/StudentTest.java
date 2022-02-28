package com.jbk.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity

public class StudentTest {
@Id

	private int id;
	private String name;
	private double marks;
	
	@OneToOne(cascade=CascadeType.ALL)
	
	private Address address;
	
	
	
	public StudentTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentTest(int id, String name, double marks, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentTest [id=" + id + ", name=" + name + ", marks=" + marks + ", address=" + address + "]";
	}
}
