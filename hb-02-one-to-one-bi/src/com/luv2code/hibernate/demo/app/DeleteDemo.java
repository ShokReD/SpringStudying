package com.luv2code.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		try (Session session = factory.getCurrentSession()) {
			int id = 1;
			
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, id); 
			System.out.println("Found instructor: " + instructor);
			
			if (instructor != null) {
				System.out.println("Deleting: " + instructor);
				session.delete(instructor);
			}
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
	}

}
