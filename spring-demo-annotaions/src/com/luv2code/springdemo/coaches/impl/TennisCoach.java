package com.luv2code.springdemo.coaches.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.services.FortuneService;

@Component
public class TennisCoach implements Coach {

	private FortuneService service;
	
	
	// This annotation is telling to Spring to looking for
	// an implementation of interface "FortuneService"
	// and automatic inject it to this constructor
	
	// also in spring 4.3 and later such annotation may be leave
	// and this annotation is not required
	@Autowired
	public TennisCoach(
			@Qualifier("randomService") FortuneService service
	) {
		this.service = service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
	
	public String getDailyFortune() {
		return service.getFortune();
	}
}
