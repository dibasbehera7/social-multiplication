package com.dibasb.ms.multi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dibasb.ms.multi.domain.MultiplicationResultAttempt;
import com.dibasb.ms.multi.service.MultiplicationService;

@RestController
@RequestMapping("/results")
public final class MultiplicationResultAttemptController {

	@Autowired
	private MultiplicationService multiplicationService;

	@PostMapping
	ResponseEntity<MultiplicationResultAttempt> postResult(
			@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {

		boolean isCorrect = multiplicationService.checkAttempt(multiplicationResultAttempt);
		MultiplicationResultAttempt attemptCopy = new MultiplicationResultAttempt(multiplicationResultAttempt.getUser(),
				multiplicationResultAttempt.getMultiplication(), multiplicationResultAttempt.getResultAttempt(),
				isCorrect);
		return ResponseEntity.ok(attemptCopy);
	}

	@GetMapping
	ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(@RequestParam("alias") String alias) {
		return ResponseEntity.ok(multiplicationService.getStatsForUser(alias));
	}
}
