package com.luv2code.springdemo.coaches.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.services.FortuneService;

@Component
public class HokkeyCoach implements Coach {

	private FortuneService service;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Autowired
	@Qualifier("randomService")
	// here I can name method with any name and 
	// annotation @Autowired will understand it
	public void doSomeCrazyStuff(FortuneService service) {
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
