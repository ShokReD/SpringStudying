package com.luv2code.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		try (Session session = factory.getCurrentSession()) {
			session.beginTransaction();

			Course course = new Course("Pacman");
			
			course.addReview(new Review("Great course"));
			course.addReview(new Review("Cool course"));
			course.addReview(new Review("Course for idiots"));
			
			System.out.println("Saving the course: " + course);
			session.save(course);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
	}

}
