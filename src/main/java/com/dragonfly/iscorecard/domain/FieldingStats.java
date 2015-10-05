package com.dragonfly.iscorecard.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by asabtharishi on 6/16/2015.
 */

@Entity
@Table(name = "FIELDING_STATS")
public class FieldingStats extends Model {

	@Column(name = "CATCHES")
	private int catches;

	@Column(name = "RUNOUTS")
	private int runOuts;

	@OneToMany(targetEntity = Player.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "PLAYER_ID")   
	private List<Player> player = new ArrayList<Player>();

	@OneToMany(targetEntity = Player.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@Column(name = "GAME_ID")
	private List<Game> game = new ArrayList<Game>();

	public List<Player> getTeam() {
		return player;
	}

	public void setTeam(List<Player> player) {
		this.player = player;
	}

	public List<Game> getGames() {
		return game;
	}

	public void setGames(List<Game> game) {
		this.game = game;
	}	

	public int getCatches() {
		return catches;
	}

	public void setCatches(int catches) {
		this.catches = catches;
	}

	public int getRunOuts() {
		return runOuts;
	}

	public void setRunOuts(int runOuts) {
		this.runOuts = runOuts;
	}

}