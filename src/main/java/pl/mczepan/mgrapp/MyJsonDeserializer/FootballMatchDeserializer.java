package pl.mczepan.mgrapp.MyJsonDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import pl.mczepan.mgrapp.model.live.football.Match;
import pl.mczepan.mgrapp.model.live.football.Teams;
import pl.mczepan.mgrapp.model.search.team.Team;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FootballMatchDeserializer extends JsonDeserializer<Teams> {

    List<String> valueNode = Arrays.asList("Date", "League", "HomeTeam", "HomeTeam_Id",
            "AwayTeam", "AwayTeam_Id", "Time", "HomeGoals", "AwayGoals", "AwayGoals",
            "HomeGoalDetails", "AwayGoalDetails", "HomeLineupGoalkeeper", "AwayLineupGoalkeeper",
            "HomeLineupDefense", "AwayLineupDefense", "HomeLineupMidfield", "AwayLineupMidfield",
            "HomeLineupForward", "AwayLineupForward", "HomeLineupSubstitutes", "AwayLineupSubstitutes",
            "HomeSubDetails", "AwaySubDetails", "Location", "Stadium", "HomeTeamYellowCardDetails",
            "AwayTeamYellowCardDetails", "HomeTeamRedCardDetails", "AwayTeamRedCardDetails");

    @Override
    public Teams deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        if (node.findPath("Match").isArray()) {
            ArrayList<Match> matches = new ArrayList<>();
            for (JsonNode tempNode : node.get("Match")) {
                matches.add(parseMatch(tempNode));
            }
            Teams teams = new Teams();
            teams.setMatch(matches);
            return teams;

        } else if (!node.findPath("teams").isArray()) {
            JsonNode locatedNode = node.path("Match");
            ArrayList<Match> matches = new ArrayList<>();
            try {
                locatedNode.get("Date").textValue();
            } catch (Exception e) {
                return null;
            }
            matches.add(parseMatch(locatedNode));
            Teams teams = new Teams();
            teams.setMatch(matches);
            return teams;
        } else {
            return null;
        }
    }

    private Match parseMatch(JsonNode locatedNode) {
        Match m = new Match();
        m.setDate(locatedNode.get("Date").textValue());
        m.setLeague(locatedNode.get("League").textValue());
        m.setHomeTeam(locatedNode.get("HomeTeam").textValue());
        m.setHomeTeamId(locatedNode.get("HomeTeam_Id").textValue());
        m.setAwayTeam(locatedNode.get("AwayTeam").textValue());
        m.setAwayTeamId(locatedNode.get("AwayTeam_Id").textValue());
        if (!(locatedNode.get("Time") == null)) {
            m.setTime(locatedNode.get("Time").textValue());
        } else {
            m.setTime("Postponed");
        }
        if (!(locatedNode.get("HomeGoals") == null)) {
            m.setHomeGoals(locatedNode.get("HomeGoals").textValue());
        }
        if (!(locatedNode.get("AwayGoals") == null)) {
            m.setAwayGoals(locatedNode.get("AwayGoals").textValue());
        }
        if (!(locatedNode.get("HomeGoalDetails") == null)) {
            m.setHomeGoalDetails(locatedNode.get("HomeGoalDetails").textValue());
        }
        if (!(locatedNode.get("AwayGoalDetails") == null)) {
            m.setAwayGoalDetails(locatedNode.get("AwayGoalDetails").textValue());
        }
        if (!(locatedNode.get("HomeLineupGoalkeeper") == null)) {
            m.setHomeLineupGoalkeeper(locatedNode.get("HomeLineupGoalkeeper").textValue());
        }
        if (!(locatedNode.get("AwayLineupGoalkeeper") == null)) {
            m.setAwayLineupGoalkeeper(locatedNode.get("AwayLineupGoalkeeper").textValue());
        }
        if (!(locatedNode.get("HomeLineupDefense") == null)) {
            m.setHomeLineupDefense(locatedNode.get("HomeLineupDefense").textValue());
        }
        if (!(locatedNode.get("AwayLineupDefense") == null)) {
            m.setAwayLineupDefense(locatedNode.get("AwayLineupDefense").textValue());
        }
        if (!(locatedNode.get("HomeLineupMidfield") == null)) {
            m.setHomeLineupMidfield(locatedNode.get("HomeLineupMidfield").textValue());
        }
        if (!(locatedNode.get("AwayLineupMidfield") == null)) {
            m.setAwayLineupMidfield(locatedNode.get("AwayLineupMidfield").textValue());
        }
        if (!(locatedNode.get("HomeLineupForward") == null)) {
            m.setHomeLineupForward(locatedNode.get("HomeLineupForward").textValue());
        }
        if (!(locatedNode.get("AwayLineupForward") == null)) {
            m.setAwayLineupForward(locatedNode.get("AwayLineupForward").textValue());
        }
        if (!(locatedNode.get("HomeLineupSubstitutes") == null)) {
            m.setHomeLineupSubstitutes(locatedNode.get("HomeLineupSubstitutes").textValue());
        }
        if (!(locatedNode.get("AwayLineupSubstitutes") == null)) {
            m.setAwayLineupSubstitutes(locatedNode.get("AwayLineupSubstitutes").textValue());
        }
        if (!(locatedNode.get("HomeSubDetails") == null)) {
            m.setHomeSubDetails(locatedNode.get("HomeSubDetails").textValue());
        }
        if (!(locatedNode.get("AwaySubDetails") == null)) {
            m.setAwaySubDetails(locatedNode.get("AwaySubDetails").textValue());
        }
        if (!(locatedNode.get("Location") == null)) {
            m.setLocation(locatedNode.get("Location").textValue());
        }
        if (!(locatedNode.get("Stadium") == null)) {
            m.setStadium(locatedNode.get("Stadium").textValue());
        }
        if (!(locatedNode.get("HomeTeamYellowCardDetails") == null)) {
            m.setHomeTeamYellowCardDetails(locatedNode.get("HomeTeamYellowCardDetails").textValue());
        }
        if (!(locatedNode.get("AwayTeamYellowCardDetails") == null)) {
            m.setAwayTeamYellowCardDetails(locatedNode.get("AwayTeamYellowCardDetails").textValue());
        }
        if (!(locatedNode.get("HomeTeamRedCardDetails") == null)) {
            m.setHomeTeamRedCardDetails(locatedNode.get("HomeTeamRedCardDetails").textValue());
        }
        if (!(locatedNode.get("AwayTeamRedCardDetails") == null)) {
            m.setAwayTeamRedCardDetails(locatedNode.get("AwayTeamRedCardDetails").textValue());
        }
        return m;
    }
}