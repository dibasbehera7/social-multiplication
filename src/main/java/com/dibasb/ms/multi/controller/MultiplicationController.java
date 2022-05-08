package com.dibasb.ms.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dibasb.ms.multi.domain.Multiplication;
import com.dibasb.ms.multi.service.MultiplicationService;

/**
* This class implements a REST API for our Multiplication
application.
*/
@RestController
@RequestMapping("/multiplications")
public final class MultiplicationController {

	@Autowired
	private MultiplicationService multiplicationService;
	
	@GetMapping("/random")
	Multiplication getRandomMultiplication()
	{
		return multiplicationService.createRandomMultiplication();
	}
	
}
