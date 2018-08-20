package com.luv2code.springdemo.coaches.impl;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.services.FortuneService;

@Component
public class TennisCoach implements Coach {

    private FortuneService service;
    
    public TennisCoach(FortuneService service) {
    	this.service = service;
    }
	
	@Override
	public String getWorkout() {
		return "Work as hard as a horse";
	}

	@Override
	public String getFortuneService() {
		return service.getFortuneService();
	}

}
