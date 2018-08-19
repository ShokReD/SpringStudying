package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.coaches.Coach;

class AnnotationsDemoApp {

	public static void main(String[] args) {

		// read spring config file
		try (ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml")) {
		
			
			// get the bean from spring container
			Coach coach = context.getBean("thatSillyCoach", Coach.class);
		
			
			// call a method on the bean
			System.out.println(coach.getDailyWorkout());
		
		}
	}
}
