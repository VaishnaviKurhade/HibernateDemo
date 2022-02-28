package com.jbk.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.ScrollMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import com.jbk.config.HibernateConfiguration;
import com.jbk.entity.Employee;

public class EmployeeService {

	public Employee prepareData(boolean b) {
		// Employee employee=new Employee();
		Scanner sc = new Scanner(System.in);
		String id = null;
		if (b == true) {
			System.out.println("Enter Employee ID");
			id = sc.next();
		} else {
			id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());

		}

		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.nextLine();
		System.out.println("Enter phone");
		String phone = sc.nextLine();
		System.out.println("Enter department");
		String department = sc.nextLine();
		System.out.println("Enter city");
		String city = sc.nextLine();
		System.out.println("Enter type");
		String type = sc.nextLine();
		System.out.println("Enter security question");
		String question = sc.nextLine();
		System.out.println("Enter answer");
		String answer = sc.nextLine();
		Employee employee = new Employee(id, username, password, phone, department, city, type, question, answer);

		/*
		 * employee.setId(id); employee.setUsername(username);
		 * employee.setPassword(password); employee.setPhone(phone);
		 * employee.setDepartment(department); employee.setCity(city);
		 * employee.setType(type); employee.setQuestion(question);
		 * employee.setAnswer(answer);
		 */
		return employee;

	}

	public boolean saveEmployee(Employee employee) {

		boolean b = false;
		SessionFactory sf = HibernateConfiguration.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		b = true;
		return b;
	}
	// ***********Fetch Employee******************

	public Employee getData(String id) {
		SessionFactory sf = HibernateConfiguration.getSessionFactory();
		Session session = sf.openSession();
		Employee employee = session.load(Employee.class, id);

		return employee;
	}
	// ***********update Employee******************

	public boolean updateEmployee(Employee employee) {
		boolean b = false;
		try {
			SessionFactory sf = HibernateConfiguration.getSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(employee);
			b = true;
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// ***********delete Employee******************

	public boolean DeleteEmployee(String id) {
		boolean b=false;
		try {
		SessionFactory sf = HibernateConfiguration.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee=session.load(Employee.class, id);
		session.delete(employee);
		b=true;
		transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	// ***********getAll Employee******************
	public Employee getAllEmployee() {
		SessionFactory sf = HibernateConfiguration.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria= session.createCriteria(Employee.class);
		List<Employee> employee= criteria.list();
		
		for(Employee emp: employee) {
			System.out.println(emp);
		}
		return (Employee) employee;
	}
	
	// ***********Criteria operation******************
	public List<Employee> CritriaOp(){
		SessionFactory sf=HibernateConfiguration.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria= session.createCriteria(Employee.class);
		
		//desc order
		//criteria.addOrder(Order.desc("username"));
		List<Employee> list=criteria.list();
		
		//criteria.setLockMode(LockMode.READ);
		//criteria.scroll(ScrollMode.FORWARD_ONLY);
		criteria.setFirstResult(1);
		return list;
		
	}
	
	// ***********Projection operation******************
	public List<Employee> ProjectionOp(){
		SessionFactory sf=HibernateConfiguration.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria= session.createCriteria(Employee.class);
		criteria.PROJECTION.transformList(null);
		List<Employee> list=criteria.list();
		return list;
	}
	// ***********Query operation******************
	public List<Employee> QueryOp(){
		
		SessionFactory sf=HibernateConfiguration.getSessionFactory();
		Session session = sf.openSession();
		Criteria criteria= session.createCriteria(Employee.class);
		session.createQuery("From Employee");
		List<Employee> list=criteria.list();
		
		return list;
		
	}
}
