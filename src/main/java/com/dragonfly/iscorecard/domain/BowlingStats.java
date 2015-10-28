package com.dragonfly.iscorecard.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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