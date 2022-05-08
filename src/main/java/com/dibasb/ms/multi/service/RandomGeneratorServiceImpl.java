package com.dibasb.ms.multi.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorServiceImpl implements RandomGeneratorService {

	final static int MIN_FACTOR = 11;
	final static int MAX_FACTOR = 99;

	@Override
	public int generateRandomFactor() {
		return new Random().nextInt((MAX_FACTOR - MIN_FACTOR) + 1) + MIN_FACTOR;
	}
}
