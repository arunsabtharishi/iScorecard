package com.dragonfly.iscorecard.response;

public class BattingStatsResponse {
	String playerName;	
	int ballsFaced;
	int runsScored;
	int fours;
	int sixes;
	int battingPosition;
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getBallsFaced() {
		return ballsFaced;
	}
	public void setBallsFaced(int ballsFaced) {
		this.ballsFaced = ballsFaced;
	}
	public int getRunsScored() {
		return runsScored;
	}
	public void setRunsScored(int runsScored) {
		this.runsScored = runsScored;
	}
	public int getFours() {
		return fours;
	}
	public void setFours(int fours) {
		this.fours = fours;
	}
	public int getSixes() {
		return sixes;
	}
	public void setSixes(int sixes) {
		this.sixes = sixes;
	}
	public int getBattingPosition() {
		return battingPosition;
	}
	public void setBattingPosition(int battingPosition) {
		this.battingPosition = battingPosition;
	}
}
