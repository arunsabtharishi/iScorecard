package com.dragonfly.iscorecard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player extends Model {

    @Column(name = "PLAYER_FIRST_NAME")
    private String playerFirstName;
    
    @Column(name = "PLAYER_LAST_NAME")
    private String playerLastName;
    

	@ManyToOne
    @JoinColumn(name = "id")
    private Team team;
    
	public String getPlayerFirstName() {
		return playerFirstName;
	}

	public void setPlayerFirstName(String playerFirstName) {
		this.playerFirstName = playerFirstName;
	}

	public String getPlayerLastName() {
		return playerLastName;
	}

	public void setPlayerLastName(String playerLastName) {
		this.playerLastName = playerLastName;
	}
   
    public Team getTeam() {
		return team;
	}
    
	public void setTeam(Team team) {
		this.team = team;
	}

}
