package pl.mczepan.mgrapp.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mczepan.mgrapp.model.search.team.SearchTeamList;
import pl.mczepan.mgrapp.model.search.team.Team;
import pl.mczepan.mgrapp.model.user.FavouriteTeamNextEvent.NextEvent;
import pl.mczepan.mgrapp.model.user.FavouriteTeamNextEvent.FavTeamNextEvent;
import pl.mczepan.mgrapp.model.user.FavouriteTeamPastEvent.FavTeamLastEvent;
import pl.mczepan.mgrapp.model.user.FavouriteTeamPastEvent.LastResult;
import pl.mczepan.mgrapp.model.user.dao.DAOTeam;
import pl.mczepan.mgrapp.model.user.dao.DAOUser;
import pl.mczepan.mgrapp.model.user.dto.TeamDTO;
import pl.mczepan.mgrapp.model.user.FavouriteTeam.FavTeam;
import pl.mczepan.mgrapp.model.user.FavouriteTeam.Player;
import pl.mczepan.mgrapp.repository.TeamRepo;
import pl.mczepan.mgrapp.repository.UserRepo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        for (DAOTeam tmpTeam : user.getTeams()) {
            TeamDTO t = new TeamDTO();
            t.setTeamID(tmpTeam.getTeamId());

            teams.add(t);
        }

        return getTeamsById(teams);
    }

    private List<Team> getTeamsById(List<TeamDTO> teamsDTO) {
        List<Team> teams = new ArrayList<>();

        for (TeamDTO tmpTeamID : teamsDTO) {
            teams.add(restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/" +
                    apiFootballKey + "/lookupteam.php?" +
                    "id=" + tmpTeamID.getTeamID(), SearchTeamList.class).getTeams().get(0));
        }
        return teams;
    }


    public List<Team> deleteFavTeam(String teamId, Principal principal) {
        teamRepo.deleteByTeamId(teamId, userRepo.findByUsername(principal.getName()));
        return getFavTeams(principal);
    }

    public void addTeam(String teamId, Principal principal) {
        DAOUser user = userRepo.findByUsername(principal.getName());
        List<DAOTeam> userTeams = user.getTeams();

        boolean found = userTeams.stream()
                .anyMatch(tmpTeam -> teamId.equals(tmpTeam.getTeamId()));
        if (found) {
            throw new IllegalArgumentException("Team exists as favourite");
        }

        DAOTeam team = new DAOTeam();
        team.setTeamId(teamId);
        team.setUser(user);
        teamRepo.save(team);
    }

    public FavTeam getTeam(String teamId) {
        List<Player> teamPlayers = restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/" +
                apiFootballKey + "/lookup_all_players.php?" +
                "id=" + teamId, FavTeam.class).getPlayer();

        List<NextEvent> teamNextEvents = restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/"+
                apiFootballKey +"/eventsnext.php?+" +
                "id=" + teamId, FavTeamNextEvent.class).getEvents();

        List<LastResult> teamLastResults = restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/"+
                apiFootballKey +"/eventslast.php?+" +
                "id=" + teamId, FavTeamLastEvent.class).getResults();

        Team favTeamDtl = restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/" +
                apiFootballKey + "/lookupteam.php?" +
                "id=" + teamId, SearchTeamList.class).getTeams().get(0);

        teamNextEvents = setTeamsNextEventLogo(teamNextEvents);
        teamLastResults = setTeamsLastResultLogo(teamLastResults);

        teamPlayers.stream()
                .sorted((player1, player2) -> player1.getStrPlayer().compareTo(player2.getStrPlayer()))
                .collect(Collectors.toList());

        FavTeam favTeam = new FavTeam();
        favTeam.setPlayer(teamPlayers);
        favTeam.setNextEvents(teamNextEvents);
        favTeam.setLastResults(teamLastResults);
        favTeam.setTeamInfo(favTeamDtl);
        return favTeam;
    }

    public List<NextEvent> setTeamsNextEventLogo(List<NextEvent> teamNextEvents) {
        for(NextEvent tmpEvent: teamNextEvents) {
            try {
                URL url = new URL("https://www.thesportsdb.com/api/v1/json/" +
                        apiFootballKey + "/lookupevent.php?" +
                        "id=" + tmpEvent.getIdEvent()) ;
                InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
                JsonObject jsonObject = new JsonParser().parse(inputStreamReader).getAsJsonObject();

                JsonArray jsonArray = jsonObject.getAsJsonArray("events");
                JsonObject nestedJsonObject = jsonArray.get(0).getAsJsonObject();

                String homeTeamID = nestedJsonObject.get("idHomeTeam").getAsString();
                String awayTeamID = nestedJsonObject.get("idAwayTeam").getAsString();

                tmpEvent.setStrHomeTeamBadge(restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/" +
                        apiFootballKey + "/lookupteam.php?" +
                        "id=" + homeTeamID, SearchTeamList.class).getTeams().get(0).getStrTeamBadge());
                tmpEvent.setStrAwayTeamBadge(restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/" +
                        apiFootballKey + "/lookupteam.php?" +
                        "id=" + awayTeamID, SearchTeamList.class).getTeams().get(0).getStrTeamBadge());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return teamNextEvents;
    }

    public List<LastResult> setTeamsLastResultLogo(List<LastResult> teamNextEvents) {
        for(LastResult tmpEvent: teamNextEvents) {
            try {
                URL url = new URL("https://www.thesportsdb.com/api/v1/json/" +
                        apiFootballKey + "/lookupevent.php?" +
                        "id=" + tmpEvent.getIdEvent()) ;
                InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
                JsonObject jsonObject = new JsonParser().parse(inputStreamReader).getAsJsonObject();

                JsonArray jsonArray = jsonObject.getAsJsonArray("events");
                JsonObject nestedJsonObject = jsonArray.get(0).getAsJsonObject();

                String homeTeamID = nestedJsonObject.get("idHomeTeam").getAsString();
                String awayTeamID = nestedJsonObject.get("idAwayTeam").getAsString();

                tmpEvent.setStrHomeTeamBadge(restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/" +
                        apiFootballKey + "/lookupteam.php?" +
                        "id=" + homeTeamID, SearchTeamList.class).getTeams().get(0).getStrTeamBadge());
                tmpEvent.setStrAwayTeamBadge(restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/" +
                        apiFootballKey + "/lookupteam.php?" +
                        "id=" + awayTeamID, SearchTeamList.class).getTeams().get(0).getStrTeamBadge());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return teamNextEvents;
    }
}
