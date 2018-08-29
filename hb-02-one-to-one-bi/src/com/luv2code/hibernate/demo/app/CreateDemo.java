package com.luv2code.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		try (Session session = factory.getCurrentSession()) {
			Instructor instructor = new Instructor("john", "wurst", "wurst@mail.com");
			InstructorDetail detail = new InstructorDetail("wurst_channel", "singing");
			
			instructor.setInstructorDetail(detail);
			
			session.beginTransaction();
			
			// this will also save the details object
			// cause of CascadeType.ALL
			System.out.println("Saving instructor: " + instructor);
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
	}

}
