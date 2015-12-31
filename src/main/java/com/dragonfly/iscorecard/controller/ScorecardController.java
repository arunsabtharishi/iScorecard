package com.dragonfly.iscorecard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dragonfly.iscorecard.domain.Team;
import com.dragonfly.iscorecard.domain.Tournament;
import com.dragonfly.iscorecard.request.GameTeamRequest;
import com.dragonfly.iscorecard.request.PlayerStatsRequest;
import com.dragonfly.iscorecard.request.PlayerTeamRequest;
import com.dragonfly.iscorecard.response.GameTeamResponse;
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
	public void createGame(@RequestBody GameTeamRequest gameTeamRequest) {
		tournamentService.createGame(gameTeamRequest);
	}
	
	@RequestMapping(value = "/player", method = RequestMethod.POST)
	@ResponseBody
	public void createPlayer(@RequestBody PlayerTeamRequest playerTeamRequest) {
		tournamentService.createPlayer(playerTeamRequest);
	}
	
	@RequestMapping(value = "/stats", method = RequestMethod.POST)
	@ResponseBody
	public void enterGameDetails(@RequestBody PlayerStatsRequest playerStatsRequests) {
		tournamentService.enterStats(playerStatsRequests);
	}
	
	@RequestMapping(value = "{gameId}/game", method = RequestMethod.GET)
	@ResponseBody
	public GameTeamResponse getGameDetails(@PathVariable String gameId) {
		return tournamentService.fetchGameDetails(gameId);
	}
	
	
}
