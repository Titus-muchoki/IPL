package tito.ipl.Ipl.repository;

import org.springframework.data.repository.CrudRepository;
import tito.ipl.Ipl.model.Match;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getByTeam1OrTeam2(String teamName1, String teamName2);
}
