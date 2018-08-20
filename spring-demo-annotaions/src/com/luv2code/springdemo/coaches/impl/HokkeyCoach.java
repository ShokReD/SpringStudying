package com.luv2code.springdemo.coaches.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.services.FortuneService;

@Component
public class HokkeyCoach implements Coach {

	private FortuneService service;
	
	@Autowired
	public void setFortuneService(FortuneService service) {
		this.service = service;
	}
	
	public String getDailyWorkout() {
		return "Throw one hundred pucks";
	}

	@Override
	public String getDailyFortune() {
		return service.getFortune();
	}

}
