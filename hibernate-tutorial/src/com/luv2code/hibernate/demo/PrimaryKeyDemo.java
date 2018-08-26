package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		try (
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		Session currectSession = factory.getCurrentSession()) {

			// create 3 student objects
			Student student1 = new Student("Alex", "Rybkin", "rybkin@mail.com");
			Student student2 = new Student("John", "Cena", "Cena@mail.com");
			Student student3 = new Student("Conchita", "Wurst", "wurst@mail.com");
			
			// start a transaction
			currectSession.beginTransaction();
			
			// save the student object
			currectSession.save(student1);
			currectSession.save(student2);
			currectSession.save(student3);
			
			// commit transaction
			currectSession.getTransaction().commit();
			
			System.out.println("Done!");
		}
	}

}
