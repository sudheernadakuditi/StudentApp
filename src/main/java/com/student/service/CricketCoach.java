package com.student.service;

import org.springframework.stereotype.Service;

@Service
public class CricketCoach implements CoachService {

	@Override
	public String giveInstructions() {

		return "Practice bowling and batting till two hours !";
	}

}
