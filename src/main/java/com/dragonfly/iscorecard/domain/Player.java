package com.dragonfly.iscorecard.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player extends Model {    

	@Column(name = "FIRST_NAME")
	private String firstName;

	@OneToMany(mappedBy = "team")
	private Set<GameTeam> playerTeam;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Set<GameTeam> getPlayerTeam() {
		return playerTeam;
	}

	public void setPlayerTeam(Set<GameTeam> playerTeam) {
		this.playerTeam = playerTeam;
	}

}
