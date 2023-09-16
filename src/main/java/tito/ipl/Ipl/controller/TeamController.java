package tito.ipl.Ipl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tito.ipl.Ipl.model.Team;
import tito.ipl.Ipl.repository.MatchRepository;
import tito.ipl.Ipl.repository.TeamRepository;

@RestController
public class TeamController {
    private TeamRepository teamRepository;
    private MatchRepository matchRepository;
    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }
    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
      Team team = this.teamRepository.findByTeamName(teamName);
      team.setMatches(matchRepository.getByTeam1OrTeam2(teamName, teamName));

      return team;
    }


}
