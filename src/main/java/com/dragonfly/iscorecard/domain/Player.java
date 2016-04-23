package com.dragonfly.iscorecard.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player extends Model {    

	@Column(name = "FIRST_NAME")
	private String firstName;

	@OneToMany(mappedBy = "team")
	private Set<GameTeam> playerTeam;
	
	@Column(name = "TEAM_NAME")
	private String teamName;	

	@OneToOne(mappedBy = "player")
	private BowlingStats bowlingStats;

	@OneToOne(targetEntity = BattingStats.class,mappedBy = "player")
	private BattingStats battingStats;
	
	@OneToOne(mappedBy = "player")
	private BowlingStats fieldingStats;
	
	public BowlingStats getBowlingStats() {
		return bowlingStats;
	}

	public void setBowlingStats(BowlingStats bowlingStats) {
		this.bowlingStats = bowlingStats;
	}

	public BattingStats getBattingStats() {
		return battingStats;
	}

	public void setBattingStats(BattingStats battingStats) {
		this.battingStats = battingStats;
	}

	public BowlingStats getFieldingStats() {
		return fieldingStats;
	}

	public void setFieldingStats(BowlingStats fieldingStats) {
		this.fieldingStats = fieldingStats;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Set<GameTeam> getPlayerTeam() {
		return playerTeam;
	}

	public void setPlayerTeam(Set<GameTeam> playerTeam) {
		this.playerTeam = playerTeam;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
