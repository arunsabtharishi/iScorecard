package com.dragonfly.iscorecard.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GAME_TEAM")
public class GameTeam extends Model {

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GAME_ID")
	private Game game;
	
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getInningsPosition() {
		return inningsPosition;
	}

	public void setInningsPosition(int inningsPosition) {
		this.inningsPosition = inningsPosition;
	}

	@ManyToOne(cascade = {CascadeType.MERGE })
    @JoinColumn(name = "TEAM_ID")
	private Team team;
	
	@Column(name = "INNINGS_POSITION")
	private int inningsPosition;
	
}
