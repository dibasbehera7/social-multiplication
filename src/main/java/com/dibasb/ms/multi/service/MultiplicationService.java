package com.dibasb.ms.multi.service;

import com.dibasb.ms.multi.domain.Multiplication;
import com.dibasb.ms.multi.domain.MultiplicationResultAttempt;

public interface MultiplicationService {

	/**
	 * Generates a random {@link Multiplication} object.
	 *
	 * @return a multiplication of randomly generated numbers
	 */
	Multiplication createRandomMultiplication();

	/**
	 * @return true if the attempt matches the result of the multiplication, false
	 *         otherwise.
	 */
	boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}
