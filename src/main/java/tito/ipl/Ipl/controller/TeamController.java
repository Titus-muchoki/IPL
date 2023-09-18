package tito.ipl.Ipl.controller;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import tito.ipl.Ipl.model.Match;
import tito.ipl.Ipl.model.Team;
import tito.ipl.Ipl.repository.MatchRepository;
import tito.ipl.Ipl.repository.TeamRepository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
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

      team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 4));

      return team;
    }
    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year){
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);

      return this.matchRepository.getByTeam1AndDateBetweenOrTeam2OrAndDateBetweenOrderByDateDesc(
                teamName,
                startDate,
                endDate,
                teamName,
                startDate,
                endDate
        ) ;
    }

}
