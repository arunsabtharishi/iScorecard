package com.dragonfly.iscorecard.request;

import java.util.HashMap;

public class PlayerTeamRequest {
	
	private HashMap<String, String> playerTeamMap;

	public HashMap<String, String> getPlayeTeamMap() {
		return playerTeamMap;
	}

	public void setPlayeTeamMap(HashMap<String, String> playeTeamMap) {
		this.playerTeamMap = playeTeamMap;
	}
}
