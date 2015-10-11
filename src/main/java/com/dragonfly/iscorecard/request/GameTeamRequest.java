package com.dragonfly.iscorecard.request;

import java.util.HashMap;

import com.dragonfly.iscorecard.domain.Game;

public class GameTeamRequest {

	private Game game;
	
	private HashMap<String, Integer> teamsInnigsPostionMap;
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public HashMap<String, Integer> getTeamsInnigsPostionMap() {
		return teamsInnigsPostionMap;
	}

	public void setTeamsInnigsPostionMap(HashMap<String, Integer> teams) {
		this.teamsInnigsPostionMap = teams;
	}

}	
