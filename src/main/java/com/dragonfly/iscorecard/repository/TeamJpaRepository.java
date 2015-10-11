package com.dragonfly.iscorecard.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragonfly.iscorecard.domain.Team;

@Repository
public interface TeamJpaRepository extends JpaRepository<Team, Long> {
	List<Team> findById(String teamId);
}
