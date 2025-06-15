package com.student.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentDetailsController {
	
	@GetMapping("/greet")
	public String getGreetStudent() {
		return "Hi student, welcome to 2025 academic year !";
	}

}
