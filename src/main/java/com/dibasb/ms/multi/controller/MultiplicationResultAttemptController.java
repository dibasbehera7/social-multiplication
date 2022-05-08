package com.dibasb.ms.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dibasb.ms.multi.domain.MultiplicationResultAttempt;
import com.dibasb.ms.multi.service.MultiplicationService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/results")
public final class MultiplicationResultAttemptController {

	@Autowired
	private MultiplicationService multiplicationService;

	// Here we'll implement our POST later
	@RequiredArgsConstructor
	@NoArgsConstructor(force = true)
	@Getter
	private static final class ResultResponse {
		private final boolean correct;
	}

	@PostMapping
	ResponseEntity<ResultResponse> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
		return ResponseEntity.ok(new ResultResponse(multiplicationService.checkAttempt(multiplicationResultAttempt)));
	}
}
