package com.dragonfly.iscorecard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dragonfly.iscorecard.domain.Game;
import com.dragonfly.iscorecard.domain.Player;
import com.dragonfly.iscorecard.domain.PlayerStats;
import com.dragonfly.iscorecard.domain.Team;
import com.dragonfly.iscorecard.domain.Tournament;
import com.dragonfly.iscorecard.service.TournamentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ScorecardController {
	
	@Autowired
	private TournamentService tournamentService;
	
	@RequestMapping(value = "/tournament", method = RequestMethod.POST)
	@ResponseBody
	public void enterTournamentDetails(@RequestBody Tournament tournament) {
		tournamentService.enterTournamentDetails(tournament);
	}
	
	@RequestMapping(value = "/team", method = RequestMethod.POST)
	@ResponseBody
	public void createTeam(@RequestBody Team team) {
		tournamentService.createTeam(team);
	}
	
	@RequestMapping(value = "/game", method = RequestMethod.POST)
	@ResponseBody
	public void createGame(@RequestBody Game game) {
		tournamentService.createGame(game);
	}
	
	@RequestMapping(value = "/player", method = RequestMethod.POST)
	@ResponseBody
	public void createPlayer(@RequestBody Player player) {
		tournamentService.createPlayer(player);
	}
	
	@RequestMapping(value = "/stats", method = RequestMethod.POST)
	@ResponseBody
	public void enterGameDetails(@RequestBody List<PlayerStats> playerstats) {
		tournamentService.enterStats(playerstats);
	}
	
	
}
