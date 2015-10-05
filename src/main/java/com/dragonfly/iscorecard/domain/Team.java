package com.dragonfly.iscorecard.domain;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team extends Model {
	
	@Column(name = "TEAM_NAME")
	private String teamName;
  
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Player> player = new LinkedHashSet<>();
    
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="teams") 
    private Set<Game> games; 
	
	public Set<Player> getPlayer() {
		return player;
	}

	public void setPlayer(Set<Player> player) {
		this.player = player;
	}

	public Set<Game> getGames()  
    {  
        return games;  
    }  
	
	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}