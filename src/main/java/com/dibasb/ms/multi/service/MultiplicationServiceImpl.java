package com.dibasb.ms.multi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dibasb.ms.multi.domain.Multiplication;
import com.dibasb.ms.multi.domain.MultiplicationResultAttempt;
import com.dibasb.ms.multi.domain.User;
import com.dibasb.ms.multi.repository.MultiplicationResultAttemptRepository;
import com.dibasb.ms.multi.repository.UserRepository;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

	@Autowired
	private RandomGeneratorService randomGeneratorService;
	@Autowired
	private MultiplicationResultAttemptRepository attemptRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public Multiplication createRandomMultiplication() {

		int factorA = randomGeneratorService.generateRandomFactor();
		int factorB = randomGeneratorService.generateRandomFactor();
		return new Multiplication(factorA, factorB);
	}

	@Transactional
	@Override
	public boolean checkAttempt(final MultiplicationResultAttempt attempt) {

		// Check if the user already exists for that alias
		Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());

		// Check if the attempt is correct
		boolean isCorrect = attempt.getResultAttempt() == attempt.getMultiplication().getFactorA()
				* attempt.getMultiplication().getFactorB();

		MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(user.orElse(attempt.getUser()),
				attempt.getMultiplication(), attempt.getResultAttempt(), isCorrect);

		// Stores the attempt
		attemptRepository.save(checkedAttempt);
		
		return isCorrect;
	}

	@Override
	public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
		return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
	}
}
