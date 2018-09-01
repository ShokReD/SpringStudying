package com.luv2code.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		try (Session session = factory.getCurrentSession()) {
			int id = 3;
			
			session.beginTransaction();
			
			InstructorDetail detail = session.get(InstructorDetail.class, id); 
			System.out.println("Found instructorDetail: " + detail);
			
			if (detail != null) {
				System.out.println("Deleting: " + detail);
				
				// remove the associated object reference
				// break bi-directional link
				detail.getInstructor().setInstructorDetail(null);
				
				session.delete(detail);
			}
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
	}

}
