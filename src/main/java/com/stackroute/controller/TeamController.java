package com.stackroute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.dao.TeamDAO;
import com.stackroute.model.Team;

@Controller
public class TeamController {
	@Autowired
	TeamDAO teamDAO;
	
	//@RequestMapping(value = "/teams", method = RequestMethod.GET)
	@GetMapping("/")
	public String getTeamData(ModelMap model) {
		model.addAttribute("teamList", teamDAO.getTeams());
		return "teamsview";
	}
	//@RequestMapping(value = "/addTeam", method = RequestMethod.POST)
	@PostMapping("/addTeam")
	public String addTeam(ModelMap model,
//						 @RequestParam("teamId") String id,
//						 @RequestParam("teamName") String name,
//						 @RequestParam("noOfPlayers") String players
					@ModelAttribute Team team
						) {
//		Team team = new Team();
//		team.setTeamId(Integer.parseInt(id));
//		team.setTeamName(name);
//		team.setNoOfPlayers(Integer.parseInt(players));
		boolean result = teamDAO.addTeam(team);
		if(result) {
			model.addAttribute("msg", "Team Object Added Successfully");
			return "teamsview";
		}
		else {
			model.addAttribute("msg", "Error Ocurred");
			return "teamsview";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
