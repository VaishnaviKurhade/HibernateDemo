
package com.jbk.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jbk.entity.Address;
import com.jbk.entity.Employee;
import com.jbk.entity.StudentTest;

public class HibernateConfiguration {

	public static SessionFactory getSessionFactory() {

		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class).addAnnotatedClass(StudentTest.class)
				.addAnnotatedClass(Address.class);

		SessionFactory sf = cfg.buildSessionFactory();
		return sf;

	}

}
