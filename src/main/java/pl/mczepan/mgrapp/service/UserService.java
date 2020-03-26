package pl.mczepan.mgrapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mczepan.mgrapp.model.search.team.SearchTeamList;
import pl.mczepan.mgrapp.model.search.team.Team;
import pl.mczepan.mgrapp.model.user.dao.DAOTeam;
import pl.mczepan.mgrapp.model.user.dao.DAOUser;
import pl.mczepan.mgrapp.model.user.dto.TeamDTO;
import pl.mczepan.mgrapp.repository.TeamRepo;
import pl.mczepan.mgrapp.repository.UserRepo;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    TeamRepo teamRepo;

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.football.key}")
    private String apiFootballKey;

    public List<Team> getFavTeams(Principal principal) {

        DAOUser user = userRepo.findByUsername(principal.getName());

        List<TeamDTO> teams = new ArrayList<>();
        for(DAOTeam tmpTeam: user.getTeams()) {
            TeamDTO t = new TeamDTO();
            t.setTeamID(tmpTeam.getTeamId());

            teams.add(t);
        }

        return getTeamsById(teams);
    }

    private List<Team> getTeamsById(List<TeamDTO> teamsDTO) {
        List<Team> teams = new ArrayList<>();

        for(TeamDTO tmpTeamID: teamsDTO) {
            teams.add(restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/" +
                    apiFootballKey + "/lookupteam.php?" +
                    "id=" + tmpTeamID.getTeamID(), SearchTeamList.class).getTeams().get(0));
        }
        return teams;
    }


    public List<Team> deleteFavTeam(String teamId, Principal principal) {
        teamRepo.deleteByTeamId(teamId,userRepo.findByUsername(principal.getName()));
        return getFavTeams(principal);
    }

    public void addTeam(String teamId, Principal principal) {
        DAOUser user = userRepo.findByUsername(principal.getName());
        List<DAOTeam> userTeams = user.getTeams();

        boolean found = userTeams.stream()
                .anyMatch(tmpTeam -> teamId.equals(tmpTeam.getTeamId()));
        if(found) {
            throw new IllegalArgumentException("Team exists as favourite");
        }

        DAOTeam team = new DAOTeam();
        team.setTeamId(teamId);
        team.setUser(user);
        teamRepo.save(team);
    }
}
