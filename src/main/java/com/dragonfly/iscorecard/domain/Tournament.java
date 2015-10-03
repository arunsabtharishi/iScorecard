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
	private String tournamentName;
	
	@NotNull
	@Column(name = "SEASON_NAME")
	private String SeasonName;
	
	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public String getSeasonName() {
		return SeasonName;
	}

	public void setSeasonName(String seasonName) {
		SeasonName = seasonName;
	}


}
