package com.dragonfly.iscorecard.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team extends Model {
	
	@Column(name = "TEAM_NAME")
	private String teamName;
	
	@ManyToMany(mappedBy="teams")
	private List<Game> games = new ArrayList<Game>();
	
	@OneToMany(targetEntity = Player.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "ID")
	private List<Player> player = new ArrayList<Player>();
	
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}