package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.coach.impl.CricketCoach;

public class SetterDemoApp {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml")) {
		
		CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		}
	}

}
