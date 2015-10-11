package com.dragonfly.iscorecard.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "GAME")
public class Game extends Model {
    
	@Column(name = "TOURNAMENT_ID")
    private String tournamentId;
	
	@OneToMany(mappedBy = "game")
	private Set<GameTeam> gameTeam;
	
	public Set<GameTeam> getGameTeam() {
		return gameTeam;
	}

	public void setGameTeam(Set<GameTeam> gameTeam) {
		this.gameTeam = gameTeam;
	}

	public String getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}
    
    
}