package com.dragonfly.iscorecard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TOURNAMENT")
public class Tournament extends Model {
	
	@NotNull
	@Column(name = "TOURNAMENT_NAME")
	private String name;
	
	@NotNull
	@Column(name = "SEASON_NAME")
	private String seasonName;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}


}
