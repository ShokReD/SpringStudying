package com.luv2code.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		try (Session session = factory.getCurrentSession()) {
			session.beginTransaction();

			int id = 16;
			
			Course course = session.get(Course.class, id);
			System.out.println(course);
			
			session.delete(course);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
	}

}
