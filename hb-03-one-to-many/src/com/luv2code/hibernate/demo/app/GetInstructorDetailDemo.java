package com.luv2code.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		try (Session session = factory.getCurrentSession()) {
			int id = 9999;
			
			session.beginTransaction();
			
			InstructorDetail detail = session.get(InstructorDetail.class, id); 
			System.out.println("Found instructor: " + detail);
			
			if (detail != null) {
				System.out.println("Selecting detail: " + detail);
				System.out.println("Selecting instructor: " + detail.getInstructor());
//				session.delete(detail);
			}
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
	}

}
