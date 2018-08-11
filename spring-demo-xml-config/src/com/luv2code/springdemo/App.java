package com.luv2code.springdemo;

import com.luv2code.springdemo.coach.Coach;
import com.luv2code.springdemo.coach.impl.BaseballCoach;

public class App {

	public static void main(String[] args) {
		Coach coach = new BaseballCoach();
		
		System.out.println(coach.getDailyWorkout());
	}

}
