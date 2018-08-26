package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		try (
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory()) {
		// create session
		Session currentSession = factory.getCurrentSession(); 

			// create a student object
			Student studentForInsert = new Student("Alex", "Rybkin", "rybkin@mail.com");
			
			// start a transaction
			currentSession.beginTransaction();
			
			// save the student object
			currentSession.save(studentForInsert);

			// commit transaction
			currentSession.getTransaction().commit();
			
			System.out.println("Done inserted!");

			currentSession = factory.getCurrentSession();
			currentSession.beginTransaction();
			
			System.out.println(currentSession.get(Student.class, new Student().getId()));
		
		}
	}
}
