package com.luv2code.springdemo.coaches.impl;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.coaches.Coach;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}
	
}
