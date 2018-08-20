package com.luv2code.springdemo.coaches.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.services.FortuneService;

@Component
public class SoccerCoach implements Coach {

	@Autowired
	@Qualifier("randomService")
	private FortuneService service;
	
	public String getDailyWorkout() {
		return "Rich ten goals in this game";
	}

	@Override
	public String getDailyFortune() {
		return service.getFortune();
	}

}
