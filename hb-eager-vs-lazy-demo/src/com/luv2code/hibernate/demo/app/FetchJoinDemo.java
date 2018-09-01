package com.luv2code.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// there are 2 options for resolving trouble with 
					// fetching data (if fetchType=LAZY) after closing session
					// 1. we can fetch data before closing
					//    and after closing session we can  
					//    get data from memory
					// 2. we can use HQL
//					System.out.println(instructor.getCourses());
		
		try (Session session = factory.getCurrentSession()) {
			session.beginTransaction();

			int id = 1;
			
			Query<Instructor> query =
					session.createQuery("select i from Instructor i "
										+ "JOIN FETCH i.courses "
										+ "where i.id=:theInstructorId", 
							Instructor.class);
			
//			Instructor instructor = session.get(Instructor.class, id);
			
			query.setParameter("theInstructorId", id);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println("Instructor: " + instructor);

			
			
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
	}

}
