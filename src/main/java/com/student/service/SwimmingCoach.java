package com.student.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class SwimmingCoach implements CoachService{
	
	// define our init method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("In doMyStartUpStuff : "+getClass().getSimpleName());
	}

	@Override
	public String giveInstructions() {
		return "Practice Swimming daily upto 3 hrs !";
	}
	
	// define our destroy method
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("In doMyCleanUpStuff : "+getClass().getSimpleName());
	}

}
