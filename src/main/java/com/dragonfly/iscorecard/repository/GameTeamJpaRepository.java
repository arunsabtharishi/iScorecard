package com.dragonfly.iscorecard.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragonfly.iscorecard.domain.Game;
import com.dragonfly.iscorecard.domain.GameTeam;

@Repository
public interface GameTeamJpaRepository extends JpaRepository<GameTeam, Long> {
	List<GameTeam> findByGame(Game game);
}
