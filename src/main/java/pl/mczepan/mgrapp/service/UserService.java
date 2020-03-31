package pl.mczepan.mgrapp.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;
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
import pl.mczepan.mgrapp.model.user.dto.TeamOntDTO;
import pl.mczepan.mgrapp.repository.TeamRepo;
import pl.mczepan.mgrapp.repository.UserRepo;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.*;
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

        List<NextEvent> teamNextEvents = restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/" +
                apiFootballKey + "/eventsnext.php?+" +
                "id=" + teamId, FavTeamNextEvent.class).getEvents();

        List<LastResult> teamLastResults = restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/" +
                apiFootballKey + "/eventslast.php?+" +
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
        for (NextEvent tmpEvent : teamNextEvents) {
            try {
                URL url = new URL("https://www.thesportsdb.com/api/v1/json/" +
                        apiFootballKey + "/lookupevent.php?" +
                        "id=" + tmpEvent.getIdEvent());
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
        for (LastResult tmpEvent : teamNextEvents) {
            try {
                URL url = new URL("https://www.thesportsdb.com/api/v1/json/" +
                        apiFootballKey + "/lookupevent.php?" +
                        "id=" + tmpEvent.getIdEvent());
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

    public SearchTeamList addTeamOntology(TeamOntDTO teamOntDTO, Principal principal) {

        Map<String, String> ontologyProperty = getOntologyProperty(teamOntDTO);
        List<String> favTeam = getFromQuery(ontologyProperty);

        SearchTeamList ontologyTeamList = new SearchTeamList();
        ontologyTeamList.setTeams(new ArrayList<>());
        for (String tmpTeam : favTeam) {
            tmpTeam = tmpTeam.replaceAll("\\d+", "").replaceAll("(.)([A-Z])", "$1 $2");

            ontologyTeamList.getTeams().add(restTemplate.getForObject("https://www.thesportsdb.com/api/v1/json/1/searchteams.php?" +
                    "t=" + tmpTeam, SearchTeamList.class).getTeams().get(0));
        }
        return ontologyTeamList;
    }

    private Map<String, String> getOntologyProperty(TeamOntDTO teamOntDTO) {
        Map<String, String> ontologyProperty = new HashMap<>();

        for (Method m : teamOntDTO.getClass().getMethods()) {
            if (m.getName().startsWith("get") && !m.getName().equals("getClass")) {
                try {
                    if (m.invoke(teamOntDTO) != null) {
                        ontologyProperty.put((m.getName().substring(3).substring(0, 1).toLowerCase() + m.getName().substring(3).substring(1)),
                                m.invoke(teamOntDTO).toString());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return ontologyProperty;
    }

    private List<String> getFromQuery(Map<String, String> ontologyProperty) {
        List<String> myTeams = new ArrayList<>();
        int iterator = 1;
        for (Map.Entry<String, String> entry : ontologyProperty.entrySet()) {
            List<String> tmpTeams;
            if (iterator == 1) {
                myTeams = executeQuery(entry.getKey(), entry.getValue());
            } else {
                tmpTeams = executeQuery(entry.getKey(), entry.getValue());
                List<String> commonList = new ArrayList<>(tmpTeams);
                commonList.retainAll(myTeams);
                myTeams = commonList;
            }
            iterator++;
        }
        return myTeams;
    }

    private List<String> executeQuery(String key, String value) {
        List<String> queryResults = new ArrayList<>();

        Model model = FileManager.get().loadModel("E:\\Maciek\\Studia\\II stopień - Informatyka\\II semestr\\Projektowanie systemów wieloagentowych\\Maciej Czepan ontologia.owl");

        String propertyValue;
        if (key.equals("hasCountry")) {
            propertyValue = "hasValue";
        } else {
            propertyValue = "someValuesFrom";
        }

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                "PREFIX club: <http://www.semanticweb.org/maciek/ontologies/2020/0/untitled-ontology-11#>\n" +
                "select ?club where {?club a owl:Class ; " +
                "rdfs:subClassOf ?restriction. " +
                "?restriction owl:onProperty club:" + key + " ;" +
                "owl:" + propertyValue + " club:" + value +
                "}";

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                Resource resource = soln.getResource("club");
                queryResults.add(resource.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return queryResults;
    }
}
