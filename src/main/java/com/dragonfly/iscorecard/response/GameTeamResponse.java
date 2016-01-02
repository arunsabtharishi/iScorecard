package com.dragonfly.iscorecard.response;

import java.util.List;

public class GameTeamResponse {
	String teams;
	
	List<BattingStatsResponse> battingStatsResponse;

	public String getTeams() {
		return teams;
	}

	public void setTeams(String teams) {
		this.teams = teams;
	}
	
	public List<BattingStatsResponse> getBattingStatsResponse() {
		return battingStatsResponse;
	}

	public void setBattingStatsResponse(List<BattingStatsResponse> battingStatsResponse) {
		this.battingStatsResponse = battingStatsResponse;
	}
}
