package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		try (
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory()) {
			Session session = factory.getCurrentSession(); 
	
			Student studentForInsert = new Student("Alex", "Rybkin", "rybkin@mail.com");
	
			session.beginTransaction();
			
			
			/*
			 * Here, in method createQuery we show class (not table)
			 * and this query is sensitive to case (first char is in capital case)
			 * but column must be a table_fields
			 */
			List<Student> students = session.createQuery("from Student s where s.lastName != 'Rybkin'").list();
			
			displayStudents(students);
		
			session.getTransaction().commit();
			
			System.out.println("Done");
		
		}
	}
	
	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
