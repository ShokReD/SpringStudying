package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory()) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			session.delete(student);
			
			session.getTransaction().commit();
			
			// delete a list
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student where last_name = 'Rybkin'").executeUpdate();
			
			session.getTransaction().commit();

		}
		
	}

}
