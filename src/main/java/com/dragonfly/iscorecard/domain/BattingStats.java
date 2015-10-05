package com.dragonfly.iscorecard.domain;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BATTING_STATS")
public class BattingStats extends Model {
    @NotNull
    @Column(name = "BATTING_POSITION")
    private int battingPosition;

    @NotNull
    @Column(name = "DID_NOT_BAT")
    private String didNotBat;

    @NotNull
    @Column(name = "BALLS_FACED")
    private int ballsFaced;

    @NotNull
    @Column(name = "RUNS_SCORED")
    private int runsScored;

    @NotNull
    @Column(name = "FOURS")
    private int fours;

    @NotNull
    @Column(name = "SIXES")
    private int sixes;
        
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
        
    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getBattingPosition() {
        return battingPosition;
    }

    public void setBattingPosition(int battingPosition) {
        this.battingPosition = battingPosition;
    }

    public String isDidNotBat() {
        return didNotBat;
    }

    public void setDidNotBat(String didNotBat) {
        this.didNotBat = didNotBat;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }
}