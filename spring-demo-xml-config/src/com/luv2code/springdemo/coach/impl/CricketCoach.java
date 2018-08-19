package com.luv2code.springdemo.coach.impl;

import com.luv2code.springdemo.coach.Coach;
import com.luv2code.springdemo.services.FortuneService;

public class CricketCoach implements Coach {
	
	private FortuneService service;

	// create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-args constructor");
	}
	
	public void setFortuneService(FortuneService service) {
		System.out.println("CricketCoach: inside setter method");
		this.service = service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return service.getFortune();
	}

}
