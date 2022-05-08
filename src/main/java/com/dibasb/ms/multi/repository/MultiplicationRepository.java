package com.dibasb.ms.multi.repository;

import org.springframework.data.repository.CrudRepository;

import com.dibasb.ms.multi.domain.Multiplication;

/**
 * This interface allows us to save and retrieve Multiplications
 */
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {
}