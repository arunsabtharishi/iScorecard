package com.dragonfly.iscorecard.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "GAME")
public class Game extends Model {
    
	@Column(name = "TOURNAMENT_ID")
    private String tournamentId;
	
	@OneToMany(mappedBy = "game")
	private Set<GameTeam> gameTeam;
	
	@OneToMany(mappedBy = "game")
	private Set<BowlingStats> bowlingStats;

	@OneToMany(mappedBy = "game")
	private Set<BattingStats> battingStats;
	
	@OneToMany(mappedBy = "game")
	private Set<FieldingStats> fieldingStats;
	
	public Set<BowlingStats> getBowlingStats() {
		return bowlingStats;
	}

	public void setBowlingStats(Set<BowlingStats> bowlingStats) {
		this.bowlingStats = bowlingStats;
	}

	public Set<BattingStats> getBattingStats() {
		return battingStats;
	}

	public void setBattingStats(Set<BattingStats> battingStats) {
		this.battingStats = battingStats;
	}

	public Set<FieldingStats> getFieldingStats() {
		return fieldingStats;
	}

	public void setFieldingStats(Set<FieldingStats> fieldingStats) {
		this.fieldingStats = fieldingStats;
	}
	
	public Set<GameTeam> getGameTeam() {
		return gameTeam;
	}

	public void setGameTeam(Set<GameTeam> gameTeam) {
		this.gameTeam = gameTeam;
	}

	public String getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}
    
    
}