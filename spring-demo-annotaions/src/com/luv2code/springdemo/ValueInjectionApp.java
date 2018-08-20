package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.coaches.impl.HokkeyCoach;

public class ValueInjectionApp {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml")) {
		
			HokkeyCoach coach = context.getBean("hokkeyCoach", HokkeyCoach.class);
		
			System.out.println(coach.getEmail());
			System.out.println(coach.getTeam());
		
		}
	}

}
