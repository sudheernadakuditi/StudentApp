package com.student.service;

import org.springframework.stereotype.Service;

@Service
public class SwimmingCoach implements CoachService{

	@Override
	public String giveInstructions() {
		return "Practice Swimming daily upto 3 hrs !";
	}

}
