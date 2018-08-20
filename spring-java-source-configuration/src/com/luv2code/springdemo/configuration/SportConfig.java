package com.luv2code.springdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.luv2code.springdemo.coaches.Coach;
import com.luv2code.springdemo.coaches.impl.SwimCoach;
import com.luv2code.springdemo.services.FortuneService;
import com.luv2code.springdemo.services.impl.HappyFortuneService;

@Configuration
// We can either use annotation ComponentScan or
// explicit define beans 
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	@Bean
	public Coach swimCoach(FortuneService service) {
		return new SwimCoach(service);
	}
	
	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(happyFortuneService());
	}
}
