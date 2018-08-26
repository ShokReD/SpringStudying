package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		try (SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory()) {
			
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student selectStudent = session.get(Student.class, 2);
			System.out.println(selectStudent);
			
			selectStudent.setFirstName("L");
			
			session.getTransaction().commit();
			
			
			// update all students
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email = 'gateway@mail.com'").executeUpdate();
			
			session.getTransaction().commit();
		}
	}

}
