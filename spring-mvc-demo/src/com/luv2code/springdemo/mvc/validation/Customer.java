package com.luv2code.springdemo.mvc.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.InitBinder;

public class Customer {
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min = 1, message="is required")
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}