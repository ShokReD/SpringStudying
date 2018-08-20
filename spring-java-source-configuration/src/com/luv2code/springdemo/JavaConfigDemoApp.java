package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.springdemo.coaches.impl.SwimCoach;
import com.luv2code.springdemo.configuration.SportConfig;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class)) {
		
		SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
		
		System.out.println(coach.getWorkout());
		System.out.println(coach.getFortuneService());
		
		System.out.println(coach.getTeam());
		System.out.println(coach.getEmail());
		}
	}
}
