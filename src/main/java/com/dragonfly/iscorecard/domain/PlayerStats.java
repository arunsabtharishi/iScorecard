package com.dragonfly.iscorecard.domain;

public abstract class PlayerStats {
	private BattingStats battingStats;
	private BowlingStats bowlingStats;
	private FieldingStats fieldingStats;
	
	public BattingStats getBattingStats() {
		return battingStats;
	}
	public void setBattingStats(BattingStats battingStats) {
		this.battingStats = battingStats;
	}
	public BowlingStats getBowlingStats() {
		return bowlingStats;
	}
	public void setBowlingStats(BowlingStats bowlingStats) {
		this.bowlingStats = bowlingStats;
	}
	public FieldingStats getFieldingStats() {
		return fieldingStats;
	}
	public void setFieldingStats(FieldingStats fieldingStats) {
		this.fieldingStats = fieldingStats;
	}

}
