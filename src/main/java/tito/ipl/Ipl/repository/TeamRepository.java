package tito.ipl.Ipl.repository;

import org.springframework.data.repository.CrudRepository;
import tito.ipl.Ipl.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);


}
