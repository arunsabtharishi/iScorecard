package com.dragonfly.iscorecard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragonfly.iscorecard.domain.GameTeam;
import com.dragonfly.iscorecard.domain.Player;
import com.dragonfly.iscorecard.domain.PlayerStats;
import com.dragonfly.iscorecard.domain.PlayerTeam;
import com.dragonfly.iscorecard.domain.Team;
import com.dragonfly.iscorecard.domain.Tournament;
import com.dragonfly.iscorecard.repository.BattingStatsJpaRepository;
import com.dragonfly.iscorecard.repository.BowlingStatsJpaRepository;
import com.dragonfly.iscorecard.repository.FieldingStatsJpaRepository;
import com.dragonfly.iscorecard.repository.GameTeamJpaRepository;
import com.dragonfly.iscorecard.repository.PlayerJpaRepository;
import com.dragonfly.iscorecard.repository.PlayerTeamJpaRepository;
import com.dragonfly.iscorecard.repository.TeamJpaRepository;
import com.dragonfly.iscorecard.repository.TournamentJpaRepository;
import com.dragonfly.iscorecard.request.GameTeamRequest;
import com.dragonfly.iscorecard.request.PlayerTeamRequest;

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
	private PlayerJpaRepository playerRepository;
	
	@Autowired
	private TeamJpaRepository teamRepository;
	
	@Autowired
	private GameTeamJpaRepository gameTeamRepository;
	
	@Autowired
	private PlayerTeamJpaRepository playerTeamRepository; 

	@Override
	public void enterTournamentDetails(Tournament tournament) {
		tournamentJpaRepository.save(tournament);
	}
	
	@Override
	public void createTeam(Team team) {
		teamRepository.save(team);
	}


	@Override
	public void createGame(GameTeamRequest gameTeamRequest) {
		List<GameTeam> gameTeams = new ArrayList<GameTeam>();

		for(Entry<String, Integer> hm : gameTeamRequest.getTeamsInnigsPostionMap().entrySet()) {			
			GameTeam gameTeam = new GameTeam();
			List<Team> teams = teamRepository.findById(hm.getKey());
			Team team = (teams.isEmpty() ? new Team() : teams.get(0));
			gameTeam.setTeam(team);
			
			gameTeam.setGame(gameTeamRequest.getGame());
			gameTeam.setInningsPosition(hm.getValue());
			
			gameTeams.add(gameTeam);
		}
		gameTeamRepository.save(gameTeams);
	}
	
	@Override
	public void createPlayer(PlayerTeamRequest playerTeamRequest) {
		List<PlayerTeam> playerTeams = new ArrayList<PlayerTeam>();
		for(Entry<String, String> hm : playerTeamRequest.getPlayerTeamMap().entrySet()) {
			Player player = new Player();
			player.setFirstName(hm.getKey());
			
			Team team = new Team();
			team.setId(hm.getValue());
			
			PlayerTeam playerTeam = new PlayerTeam();
			playerTeam.setPlayer(player);
			playerTeam.setTeam(team);
			
			playerTeams.add(playerTeam);
		}
		playerTeamRepository.save(playerTeams);
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
