package com.dragonfly.iscorecard.request;

import com.dragonfly.iscorecard.domain.BattingStats;
import com.dragonfly.iscorecard.domain.BowlingStats;
import com.dragonfly.iscorecard.domain.FieldingStats;

public class PlayerStatsRequest {
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
