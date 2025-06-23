package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.service.CoachService;

@RestController
public class CoachController {

	private CoachService coachService;

	@Autowired
	public CoachController(@Qualifier("swimmingCoach") CoachService coachService) {
		this.coachService = coachService;
	}

	@GetMapping("/coach")
	public String getCoachInstructions() {

		return coachService.giveInstructions();
	}

}
