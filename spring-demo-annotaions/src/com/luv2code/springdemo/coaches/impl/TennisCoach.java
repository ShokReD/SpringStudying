package com.luv2code.springdemo.coaches.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.services.FortuneService;

@Component
// available scope values: prototype, singleton
@Scope("prototype")
public class TennisCoach implements Coach {

	private FortuneService service;
	
	/*
	 * Annotations @PostConstruct and @PreDestroy 
	 * may be before methods with any modifiers
	 * (public, default, private, protected)
	 * 
	 * Also it may return any type
	 * 
	 * Also it may be any method name
	 * 
	 * Also it cannot contain ANY arguments
	 */
	
	@PostConstruct
	public void createMethod() {
		System.out.println("Inside createMethod");
	}
	
	@PreDestroy
	// this annotation does not work for prototype scope
	public void cleanMethod() {
		System.out.println("Inside cleanMethod");
	}
	// This annotation is telling to Spring to looking for
	// an implementation of interface "FortuneService"
	// and automatic inject it to this constructor
	
	// also in spring 4.3 and later such annotation may be leave
	// and this annotation is not required
//	@Autowired
	public TennisCoach(
			@Qualifier("randomService") 
			FortuneService service
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
