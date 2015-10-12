package com.dragonfly.iscorecard.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team extends Model {
	
	@Column(name = "TEAM_NAME")
	private String teamName;
 
    
	@OneToMany(mappedBy = "game")
	private Set<GameTeam> gameTeam;
	
	@OneToMany(mappedBy = "player")
	private Set<PlayerTeam> playerTeam;
	
	public Set<GameTeam> getGameTeam() {
		return gameTeam;
	}

	public void setGameTeam(Set<GameTeam> gameTeam) {
		this.gameTeam = gameTeam;
	}
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}