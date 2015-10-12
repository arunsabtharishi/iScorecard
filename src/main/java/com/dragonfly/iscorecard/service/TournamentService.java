package com.dragonfly.iscorecard.service;

import java.util.List;

import com.dragonfly.iscorecard.domain.PlayerStats;
import com.dragonfly.iscorecard.domain.Team;
import com.dragonfly.iscorecard.domain.Tournament;
import com.dragonfly.iscorecard.request.GameTeamRequest;
import com.dragonfly.iscorecard.request.PlayerTeamRequest;

public interface TournamentService {
	public void enterTournamentDetails(Tournament tournament);
	
	public void createTeam(Team team);
	
	public void createGame(GameTeamRequest gameTeamRequest);
	
	public void createPlayer(PlayerTeamRequest playerTeamRequest);
	
	public void enterStats(List<PlayerStats> playerstats);
}
