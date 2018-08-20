package com.luv2code.springdemo.services.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.services.FortuneService;

@Component
public class RandomService implements FortuneService {

	@Override
	public String getFortune() {
		if (new Random().nextInt(2) == 1) {
			return "Don't cry";
		} else {
			return "You can";
		}
	}

}
