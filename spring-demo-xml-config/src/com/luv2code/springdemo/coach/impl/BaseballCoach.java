package com.luv2code.springdemo.coach.impl;

import com.luv2code.springdemo.coach.Coach;
import com.luv2code.springdemo.services.FortuneService;

public class BaseballCoach implements Coach {
	
	// define a private field for the dependency
	public FortuneService service;
	
	// define a constructor for dependency injection
	public BaseballCoach(FortuneService service) {
		this.service = service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return service.getFortune();
	}
}
