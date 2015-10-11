package com.dragonfly.iscorecard.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team extends Model {
	
	@Column(name = "TEAM_NAME")
	private String teamName;
  
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Player> player = new LinkedHashSet<Player>();
    
	@OneToMany(mappedBy = "game")
	private Set<GameTeam> gameTeam;
	
	public Set<GameTeam> getGameTeam() {
		return gameTeam;
	}

	public void setGameTeam(Set<GameTeam> gameTeam) {
		this.gameTeam = gameTeam;
	}
	
	public Set<Player> getPlayer() {
		return player;
	}

	public void setPlayer(Set<Player> player) {
		this.player = player;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}