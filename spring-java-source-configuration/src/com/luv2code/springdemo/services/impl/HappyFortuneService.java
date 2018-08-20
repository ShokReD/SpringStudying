package com.luv2code.springdemo.services.impl;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.services.FortuneService;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortuneService() {
		return "Today is your happy day!";
	}

}
