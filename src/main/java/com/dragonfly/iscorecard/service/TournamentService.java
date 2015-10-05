package com.dragonfly.iscorecard.service;

import java.util.List;

import com.dragonfly.iscorecard.domain.Game;
import com.dragonfly.iscorecard.domain.Player;
import com.dragonfly.iscorecard.domain.PlayerStats;
import com.dragonfly.iscorecard.domain.Team;
import com.dragonfly.iscorecard.domain.Tournament;

public interface TournamentService {
	public void enterTournamentDetails(Tournament tournament);
	
	public void createTeam(Team team);
	
	public void createGame(Game game);
	
	public void createPlayer(Player player);
	
	public void enterStats(List<PlayerStats> playerstats);
}
