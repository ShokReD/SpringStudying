package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HomeController {
	
	@RequestMapping("/showForm")
	public String showPage() {
		return "main-menu";
	}
}
