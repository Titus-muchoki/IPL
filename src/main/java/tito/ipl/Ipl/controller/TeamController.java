package tito.ipl.Ipl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tito.ipl.Ipl.model.Team;
import tito.ipl.Ipl.repository.TeamRepository;

@RestController
public class TeamController {
    private TeamRepository teamRepository;
    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
      return  this.teamRepository.findByTeamName(teamName);
    }


}
