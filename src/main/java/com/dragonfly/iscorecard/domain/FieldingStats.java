package com.dragonfly.iscorecard.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	@OneToOne(targetEntity = Player.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ID")   
	private Player player;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "GAME_ID")
	private Game game;
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
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