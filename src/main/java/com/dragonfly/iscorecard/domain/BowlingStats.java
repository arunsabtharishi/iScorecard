package com.dragonfly.iscorecard.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOWLING_STATS")
public class BowlingStats extends Model {

	@NotNull
	@Column(name = "DID_NOT_BOWL")
	private String didNotBowl;

	@NotNull
	@Column(name = "BOWLING_POSITION")
	private int bowlingPosition;

	@NotNull
	@Column(name = "OVERS_BOWLED")
	private int oversBowled;

	@NotNull
	@Column(name = "BALLS_BOWLED_BEFORE_COMPLETING_OVER")
	private int ballsBowledBeforeCompletingOver;

	@NotNull
	@Column(name = "RUNS_CONCEDED")
	private int runsConceded;

	@NotNull
	@Column(name = "WICKETS_TAKEN")
	private int wicketsTaken;

	@NotNull
	@Column(name = "MAIDENS")
	private int maidens;

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

	public int getBallsBowledBeforeCompletingOver() {
		return ballsBowledBeforeCompletingOver;
	}

	public void setBallsBowledBeforeCompletingOver(int ballsBowledBeforeCompletingOver) {
		this.ballsBowledBeforeCompletingOver = ballsBowledBeforeCompletingOver;
	}

	public int getOversBowled() {
		return oversBowled;
	}

	public void setOversBowled(int oversBowled) {
		this.oversBowled = oversBowled;
	}

	public int getBowlingPosition() {
		return bowlingPosition;
	}

	public void setBowlingPosition(int bowlingPosition) {
		this.bowlingPosition = bowlingPosition;
	}

	public String isDidNotBowl() {
		return didNotBowl;
	}

	public void setDidNotBowl(String didNotBowl) {
		this.didNotBowl = didNotBowl;
	}

	public int getRunsConceded() {
		return runsConceded;
	}

	public void setRunsConceded(int runsConceded) {
		this.runsConceded = runsConceded;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public int getMaidens() {
		return maidens;
	}

	public void setMaidens(int maidens) {
		this.maidens = maidens;
	}

}