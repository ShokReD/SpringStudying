package com.luv2code.springdemo.coach.impl;

import com.luv2code.springdemo.coach.Coach;

public class BaseballCoach implements Coach {
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}
}
