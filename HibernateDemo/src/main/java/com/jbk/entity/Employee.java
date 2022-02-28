
package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="id")
	private String id;
	public Employee(String id, String username, String password, String phone, String department, String city,
			String type, String question, String answer) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.department = department;
		this.city = city;
		this.type = type;
		this.question = question;
		this.answer = answer;
	}
	private String username;
	private String password;
	private String phone;
	private String department;
	private String city;
	private String type;
	private String question;
	private String answer;
	public Employee(String id, String username, String password, String phone, String department, String city,
			String type, String question, String answer, String status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.department = department;
		this.city = city;
		this.type = type;
		this.question = question;
		this.answer = answer;
		this.status = status;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	//@Column(columnDefinition="String default inactive")
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", department=" + department + ", city=" + city + ", type=" + type + ", question=" + question
				+ ", answer=" + answer + ", status=" + status + "]";
	}


}