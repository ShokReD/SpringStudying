package com.luv2code.springdemo.coach.impl;

import com.luv2code.springdemo.coach.Coach;
import com.luv2code.springdemo.services.FortuneService;

public class CricketCoach implements Coach {
	
	private FortuneService service;

	private String emailAddress;
	private String team;
	
	// create a no-arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-args constructor");
	}
	
	public void setFortuneService(FortuneService service) {
		System.out.println("CricketCoach: inside fortuneService setter");
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside emailAddress setter");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside team setter");
		this.team = team;
	}

}
