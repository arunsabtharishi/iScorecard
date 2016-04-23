package com.dragonfly.iscorecard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dragonfly.iscorecard.domain.SampleData;

public interface SampleDataJpaRepository extends JpaRepository<SampleData, String> {
	
}
