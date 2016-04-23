package com.dragonfly.iscorecard.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER_TEAM")
public class PlayerTeam extends Model {

	@ManyToOne(cascade = {CascadeType.MERGE })
    @JoinColumn(name = "TEAM_ID")
	private Team team;
		
	@ManyToOne(cascade = {CascadeType.MERGE })
    @JoinColumn(name = "PLAYER_ID")
	private Player player;
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
		
}
