package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.coach.Coach;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		try (ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml")) {
			
			// retrieve bean from spring container
			Coach firstCoach = context.getBean("myCoach", Coach.class);
			Coach secondCoach = context.getBean("myCoach", Coach.class);
			
			// check if they are the same
			System.out.println(firstCoach == secondCoach);
		}
	}

}
