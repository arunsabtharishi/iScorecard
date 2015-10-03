package com.dragonfly.iscorecard.domain;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
public class Team extends Model {
	
	@Column(name = "TEAM_NAME")
	private String teamName;	

	@OneToOne
    @JoinColumn(name = "id")
    private Game game;
	
    public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

    public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}