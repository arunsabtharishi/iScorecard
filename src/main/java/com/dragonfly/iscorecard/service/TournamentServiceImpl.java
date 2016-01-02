package com.dragonfly.iscorecard.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragonfly.iscorecard.domain.BattingStats;
import com.dragonfly.iscorecard.domain.Game;
import com.dragonfly.iscorecard.domain.GameTeam;
import com.dragonfly.iscorecard.domain.Player;
import com.dragonfly.iscorecard.domain.PlayerTeam;
import com.dragonfly.iscorecard.domain.Team;
import com.dragonfly.iscorecard.domain.Tournament;
import com.dragonfly.iscorecard.repository.BattingStatsJpaRepository;
import com.dragonfly.iscorecard.repository.BowlingStatsJpaRepository;
import com.dragonfly.iscorecard.repository.FieldingStatsJpaRepository;
import com.dragonfly.iscorecard.repository.GameJpaRepository;
import com.dragonfly.iscorecard.repository.GameTeamJpaRepository;
import com.dragonfly.iscorecard.repository.PlayerJpaRepository;
import com.dragonfly.iscorecard.repository.PlayerTeamJpaRepository;
import com.dragonfly.iscorecard.repository.TeamJpaRepository;
import com.dragonfly.iscorecard.repository.TournamentJpaRepository;
import com.dragonfly.iscorecard.request.GameTeamRequest;
import com.dragonfly.iscorecard.request.PlayerStatsRequest;
import com.dragonfly.iscorecard.request.PlayerTeamRequest;
import com.dragonfly.iscorecard.response.BattingStatsResponse;
import com.dragonfly.iscorecard.response.GameTeamResponse;

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
	private TeamJpaRepository teamRepository;
	
	@Autowired
	private GameTeamJpaRepository gameTeamRepository;
	
	@Autowired
	private PlayerTeamJpaRepository playerTeamRepository; 
	
	@Autowired
	private GameJpaRepository gameRepository;
	
	@Autowired
	private PlayerJpaRepository playerRepository;
	
	@Autowired
	private PlayerTeamJpaRepository playerteamRepository;

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
	public void enterStats(PlayerStatsRequest playerStatsRequests) {
			String id = playerStatsRequests.getBattingStats().getPlayer().getId() + playerStatsRequests.getBattingStats().getGame().getId();
			playerStatsRequests.getBattingStats().setId(id);
			playerStatsRequests.getBowlingStats().setId(id);
			playerStatsRequests.getFieldingStats().setId(id);
			battingStatsJpaRepository.save(playerStatsRequests.getBattingStats());
			bowlingStatsJpaRepository.save(playerStatsRequests.getBowlingStats());	
			fieldingStatsJpaRepository.save(playerStatsRequests.getFieldingStats());			
	}
	
	@Override
	public void enterBattingStats(PlayerStatsRequest playerStatsRequests) {
			String id = playerStatsRequests.getBattingStats().getPlayer().getId() + playerStatsRequests.getBattingStats().getGame().getId();
			playerStatsRequests.getBattingStats().setId(id);
			battingStatsJpaRepository.save(playerStatsRequests.getBattingStats());			
	}
	
	@Override
	public void enterBowlingStats(PlayerStatsRequest playerStatsRequests) {
			String id = playerStatsRequests.getBattingStats().getPlayer().getId() + playerStatsRequests.getBattingStats().getGame().getId();
			playerStatsRequests.getBowlingStats().setId(id);
			bowlingStatsJpaRepository.save(playerStatsRequests.getBowlingStats());	
	}
	
	@Override
	public void enterFieldingStats(PlayerStatsRequest playerStatsRequests) {
			String id = playerStatsRequests.getBattingStats().getPlayer().getId() + playerStatsRequests.getBattingStats().getGame().getId();
			playerStatsRequests.getFieldingStats().setId(id);
			fieldingStatsJpaRepository.save(playerStatsRequests.getFieldingStats());			
	}
	
	public List<GameTeamResponse> fetchGameDetails(String gameId) {
		Game game =  gameRepository.findById(gameId);
		List<GameTeam> gameTeams = gameTeamRepository.findByGame(game);
		List<GameTeamResponse> gameTeamResponses = new ArrayList<GameTeamResponse>();
		GameTeamResponse gameTeamResponse = new GameTeamResponse();
		BattingStatsResponse battingStatsResponse = new BattingStatsResponse();
		for(GameTeam gameTeam: gameTeams) {
			String teamName = gameTeam.getTeam().getTeamName();
			gameTeamResponse.setTeams(teamName);
			
			List<BattingStats> battingStatss = battingStatsJpaRepository.findByGameId(gameId);
			List<BattingStatsResponse> battingStatsResponses = new ArrayList<BattingStatsResponse>();
			Collections.sort(battingStatss, new Comparator<BattingStats>() {
		        @Override public int compare(BattingStats b1, BattingStats b2) {
		            return b1.getBattingPosition() - b2.getBattingPosition(); // Ascending
		        }

		    });
			for(BattingStats battingStats : battingStatss){
				String playerId = battingStats.getPlayer().getId();
				Player player = playerRepository.findById(playerId);
				PlayerTeam playerTeam = playerTeamRepository.findByPlayerId(playerId);
				gameTeamResponse.setTeams(teamName);
				if(playerTeam.getTeam().getTeamName().equals(teamName)) {				
					battingStatsResponse.setPlayerName(player.getFirstName());
					battingStatsResponse.setBallsFaced(battingStats.getBallsFaced());
					battingStatsResponse.setRunsScored(battingStats.getRunsScored());
					battingStatsResponse.setBattingPosition(battingStats.getBattingPosition());
					battingStatsResponse.setFours(battingStats.getFours());
					battingStatsResponse.setSixes(battingStats.getSixes());
					battingStatsResponses.add(battingStatsResponse);
					battingStatsResponse = new BattingStatsResponse();
				}
			}
			gameTeamResponse.setBattingStatsResponse(battingStatsResponses);
			gameTeamResponses.add(gameTeamResponse);
			gameTeamResponse = new GameTeamResponse();
		}		
		return gameTeamResponses;
	}
}
