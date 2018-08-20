package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.coaches.Coach;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load spring config file
		try (ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml")) {
		
			// retrieve bean from spring container
			Coach firstCoach = context.getBean("tennisCoach", Coach.class);
			Coach secondCoach = context.getBean("tennisCoach", Coach.class);
			
			System.out.println(firstCoach == secondCoach);
		}
	}

}
