package com.dragonfly.iscorecard.service;

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
	
	public GameTeamResponse fetchGameDetails(String gameId);
}
