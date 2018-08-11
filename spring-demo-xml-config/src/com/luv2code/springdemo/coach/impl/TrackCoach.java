package com.luv2code.springdemo.coach.impl;

import com.luv2code.springdemo.coach.Coach;

public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
}
