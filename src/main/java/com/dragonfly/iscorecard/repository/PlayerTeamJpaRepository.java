package com.dragonfly.iscorecard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragonfly.iscorecard.domain.PlayerTeam;

@Repository
public interface PlayerTeamJpaRepository extends JpaRepository<PlayerTeam, Long> {
	PlayerTeam findByPlayerId(String playerId);
}
