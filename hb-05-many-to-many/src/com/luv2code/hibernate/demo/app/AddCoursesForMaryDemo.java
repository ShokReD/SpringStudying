package com.luv2code.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try (Session session = factory.getCurrentSession()) {
			session.beginTransaction();

			Student mary = session.get(Student.class, 2);
			
			System.out.println(mary);
			
			Course course1 = new Course("Rubik's cube");
			Course course2 = new Course("Atari 2600");
			
			course1.addStudent(mary);
			course2.addStudent(mary);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
	}

}
