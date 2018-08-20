package com.luv2code.springdemo.coaches.impl;

import org.springframework.beans.factory.annotation.Value;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.services.FortuneService;

public class SwimCoach implements Coach {
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	private FortuneService service;

	public SwimCoach(FortuneService service) {
		this.service = service;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
	@Override
	public String getWorkout() {
		return "Swim like a dolphin";
	}
	
	public String getFortuneService() {
		return service.getFortuneService();
	}
}
