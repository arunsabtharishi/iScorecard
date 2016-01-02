package com.dragonfly.iscorecard.service;

import java.util.List;

import com.dragonfly.iscorecard.domain.Team;
import com.dragonfly.iscorecard.domain.Tournament;
import com.dragonfly.iscorecard.request.GameTeamRequest;
import com.dragonfly.iscorecard.request.PlayerStatsRequest;
import com.dragonfly.iscorecard.request.PlayerTeamRequest;
import com.dragonfly.iscorecard.response.GameTeamResponse;

public interface TournamentService {
	public void enterTournamentDetails(Tournament tournament);
	
	public void createTeam(Team team);
	
	public void createGame(GameTeamRequest gameTeamRequest);
	
	public void createPlayer(PlayerTeamRequest playerTeamRequest);
	
	public void enterStats(PlayerStatsRequest playerStatsRequests);
	
	public void enterBattingStats(PlayerStatsRequest playerStatsRequests);
	
	public void enterBowlingStats(PlayerStatsRequest playerStatsRequests);
	
	public void enterFieldingStats(PlayerStatsRequest playerStatsRequests);
	
	public List<GameTeamResponse> fetchGameDetails(String gameId);
}
