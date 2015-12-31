package com.dragonfly.iscorecard.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BATTING_STATS")
public class BattingStats {
	
	@Id
	String id;

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
   
    
    @OneToOne(targetEntity = Player.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE, orphanRemoval = true)
	@JoinColumn(name = "PLAYER_ID")
	private Player player;
    
    
	@ManyToOne(targetEntity = Game.class, fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
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

	public void setGames(Game game) {
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
    
    public String getId() {
  		return id;
  	}

  	public void setId(String id) {
  		this.id = id;
  	}

  	public String getDidNotBat() {
  		return didNotBat;
  	}

  	public void setGame(Game game) {
  		this.game = game;
  	}
}