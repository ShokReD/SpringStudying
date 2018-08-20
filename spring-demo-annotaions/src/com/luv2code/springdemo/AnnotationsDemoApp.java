package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.coaches.Coach;

class AnnotationsDemoApp {

	public static void main(String[] args) {

		// read spring config file
		try (ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml")) {
		
			
			// get the bean from spring container
			// instead of using special bean id we can use class name of required bean
			Coach coach = context.getBean("soccerCoach", Coach.class);
		
			// call a method on the bean
			System.out.println(coach.getDailyWorkout());
		
			// call method to get the daily fortune
			System.out.println(coach.getDailyFortune());

		}
	}
}
