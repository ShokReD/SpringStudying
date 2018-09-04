package com.luv2code.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

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

			Course course = new Course("Pacman - How to Score One Million Points");
			
			System.out.println("Saving the course");
			
			session.save(course);
			
			System.out.println("Saved the course:" + course);
			
			Student student1 = new Student("John", "Cena", "John@mail.com");
			Student student2 = new Student("Mary", "Kay", "Mary@mail.com");
			
			course.addStudent(student1);
			course.addStudent(student2);
			
			System.out.println("Saving students...");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved students: " + course.getStudents());
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
	}

}
