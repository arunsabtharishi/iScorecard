package com.dragonfly.iscorecard.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragonfly.iscorecard.domain.Team;

@Repository
public interface TeamJpaRepository extends JpaRepository<Team, Long> {

}
