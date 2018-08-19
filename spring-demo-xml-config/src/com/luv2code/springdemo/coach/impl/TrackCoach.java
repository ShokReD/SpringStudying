package com.luv2code.springdemo.coach.impl;

import com.luv2code.springdemo.coach.Coach;
import com.luv2code.springdemo.services.FortuneService;

public class TrackCoach implements Coach {

	private FortuneService service;
	
	public TrackCoach(FortuneService service) {
		this.service = service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it: " + service.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	// add a destroy method
	public void doMyCleanStuff() {
		System.out.println("TrackCoach: inside method doMyCleanStuff");
	}
}
