package com.dragonfly.iscorecard.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "GAME")
public class Game extends Model {
    
	@Column(name = "TOURNAMENT_ID")
    private String tournamentId;
	
	 @ManyToMany(cascade = {CascadeType.ALL})
	    @JoinTable(name="GAME_TEAM", 
	                joinColumns={@JoinColumn(name="GAME_ID")}, 
	                inverseJoinColumns={@JoinColumn(name="TEAM_ID")})
    private List<Team> teams = new ArrayList<Team>();

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public String getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}
    
    
}