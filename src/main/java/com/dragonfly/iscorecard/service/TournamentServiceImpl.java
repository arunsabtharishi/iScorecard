package com.dragonfly.iscorecard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragonfly.iscorecard.domain.Game;
import com.dragonfly.iscorecard.domain.Player;
import com.dragonfly.iscorecard.domain.PlayerStats;
import com.dragonfly.iscorecard.domain.Team;
import com.dragonfly.iscorecard.domain.Tournament;
import com.dragonfly.iscorecard.repository.BattingStatsJpaRepository;
import com.dragonfly.iscorecard.repository.BowlingStatsJpaRepository;
import com.dragonfly.iscorecard.repository.FieldingStatsJpaRepository;
import com.dragonfly.iscorecard.repository.GameJpaRepository;
import com.dragonfly.iscorecard.repository.PlayerJpaRepository;
import com.dragonfly.iscorecard.repository.TeamJpaRepository;
import com.dragonfly.iscorecard.repository.TournamentJpaRepository;

@Service
public class TournamentServiceImpl implements TournamentService {
	@Autowired
	private TournamentJpaRepository tournamentJpaRepository;
	
	@Autowired
	private BattingStatsJpaRepository battingStatsJpaRepository;
	
	@Autowired
	private BowlingStatsJpaRepository bowlingStatsJpaRepository;
	
	@Autowired
	private FieldingStatsJpaRepository fieldingStatsJpaRepository;
	
	@Autowired
	private GameJpaRepository gamejpaRepository;
	
	@Autowired
	private PlayerJpaRepository playerRepository;
	
	@Autowired
	private TeamJpaRepository teamRepository;

	@Override
	public void enterTournamentDetails(Tournament tournament) {
		tournamentJpaRepository.save(tournament);
	}
	
	@Override
	public void createTeam(Team team) {
		teamRepository.save(team);
	}


	@Override
	public void createGame(Game game) {
		gamejpaRepository.save(game);
	}
	
	@Override
	public void createPlayer(Player player) {
		playerRepository.save(player);		
	}

	@Override
	public void enterStats(List<PlayerStats> playerStats) {
		
		for(PlayerStats playerStat: playerStats) {
			battingStatsJpaRepository.save(playerStat.getBattingStats());
			bowlingStatsJpaRepository.save(playerStat.getBowlingStats());
			fieldingStatsJpaRepository.save(playerStat.getFieldingStats());			
		}

	}

}
