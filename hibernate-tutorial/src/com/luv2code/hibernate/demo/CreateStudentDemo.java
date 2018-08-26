package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create a session factory
		try (
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session currectSession = factory.getCurrentSession()) {

			// create a student object
			Student student = new Student("Alex", "Rybkin", "rybkin@mail.com");
			
			// start a transaction
			currectSession.beginTransaction();
			
			// save the student object
			currectSession.save(student);
			
			// commit transaction
			currectSession.getTransaction().commit();
			
			System.out.println("Done!");
		}
	}
}
