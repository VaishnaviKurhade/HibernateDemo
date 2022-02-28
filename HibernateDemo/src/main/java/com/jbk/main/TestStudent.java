package com.jbk.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jbk.config.HibernateConfiguration;
import com.jbk.entity.Address;
import com.jbk.entity.StudentTest;

public class TestStudent {
	public static void main(String[] args) {

		SessionFactory sessionfactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionfactory.openSession();
		Transaction transaction = session.beginTransaction();

//		Address address = new Address(1, "pune", "MH", 411046);
//		StudentTest student = new StudentTest(10, "vaishnavi", 60.60, address);
//		session.save(student);
//		transaction.commit();
//		
//		Address address2 = new Address(2, "pune", "MH", 411046);
//		StudentTest student2 = new StudentTest(20, "radhika", 20.60, address2);
//		session.save(student2);
//		transaction.commit();
//		
//		Address address3 = new Address(3, "mumbai", "MH", 411046);
//		StudentTest student3 = new StudentTest(30, "ashish", 10.60, address3);
//		session.save(student3);
//		transaction.commit();

		
	StudentTest st=	session.get(StudentTest.class, 30);
	System.out.println(st);
	}

}
