package com.dragonfly.iscorecard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player extends Model {    

	@Column(name = "FIRST_NAME")
	private String firstName;
	
    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = true, updatable = true)
    private Team team;

}
