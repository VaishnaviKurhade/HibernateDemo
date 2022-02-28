package com.jbk.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jbk.config.HibernateConfiguration;
import com.jbk.entity.Employee;
import com.jbk.service.EmployeeService;

public class TestController {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		EmployeeService service = new EmployeeService();
		char c;
		int Choice;
		do {
			System.out.println("1. Save Employee");
			System.out.println("2. Fetch Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Get all Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Criteria  operation");
			System.out.println("7. projection operation");
			System.out.println("8. Query Operation");
			System.out.println("9");
			System.out.println("Enter Your Choice!!!!!");
			Choice = sc.nextInt();

			switch (Choice) {
			case 1: {
				Employee employee = service.prepareData(false);
				boolean b = service.saveEmployee(employee);
				if (b == true) {
					System.out.println("data saved successfully***");
				} else {
					System.out.println("Somthing went wrong ###");
				}
				break;
			}

			case 2: {
				System.out.println("Enter Employee ID");
				String id = sc.next();

				Employee employee = service.getData(id);

				System.out.println(employee);

				break;
			}
			case 3: {
				Employee employee = service.prepareData(true);
				boolean b = service.updateEmployee(employee);
				System.out.println(b);
				break;
			}
			case 4: {
				System.out.println("All Employee list");
				Employee employee = service.getAllEmployee();

				break;
			}
			case 5: {
				String id = null;
				System.out.println("Enter Employee ID");
				id = sc.next();
				boolean employee = service.DeleteEmployee(id);

				// System.out.println(employee);
				break;
			}
			case 6: {
				List<Employee> list = service.CritriaOp();
				for (Employee employee : list) {
					System.out.println(employee);
				}
				break;
			}
			case 7: {
				List<Employee> list = service.ProjectionOp();
				for (Employee employee : list) {
					System.out.println(employee.getId());
				}

				break;
			}

			case 8: {
				List<Employee> list = service.QueryOp();
				for (Employee employee : list) {
					System.out.println(employee);
				}

				break;
			}

			case 9: {

				SessionFactory sf = HibernateConfiguration.getSessionFactory();
				Session session = sf.openSession();
				Criteria criteria = session.createCriteria(Employee.class);
				// String query = "from Employee where city='pune' and username='vaishnavi'";
				// Query q = session.createQuery(query);
				// List<Employee> list = q.list();
				// for (Employee employee : list) {
				// System.out.println(employee);
				// }

				/*
				 * Transaction transaction = session.beginTransaction();
				 * 
				 * String query = "delete from Employee e where e.city=:c"; Query q =
				 * session.createQuery(query); q.setParameter("c", "mumbai"); int a =
				 * q.executeUpdate(); System.out.println("deleted"+a); tra
				 *nsaction.commit();*/
				
				//*************Implementing pagination
				Query q=session.createQuery("from Employee");
				q.setFirstResult(0);
				q.setMaxResults(2);
				List<Employee> list=q.list();
				for (Employee employee : list) {
					System.out.println(employee);
					 }
				break;
			}
			default:
				System.out.println("Enter Invalid Choice!!!!");
				break;
			}
			System.out.println("Do You Want To Continue Press Y/N");
			c = sc.next().charAt(0);
		} while (c == 'y' || c == 'Y');
		{
			System.out.println("Program Finished......");
		}
	}

}
