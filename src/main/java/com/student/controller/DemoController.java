package com.student.controller;

import org.springframework.web.bind.annotation.GetMapping;


public class DemoController {

	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
}
