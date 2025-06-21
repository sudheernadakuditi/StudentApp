package com.student.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentDetailsController {
	
	@Value("${my.name}")
	String myName;
	
	@Value("${greet.the.person}")
	String greet;
	
	@GetMapping("/wish")
	public String greet() {
		return greet+" "+"i am"+" "+myName;
	}
	
	
}
