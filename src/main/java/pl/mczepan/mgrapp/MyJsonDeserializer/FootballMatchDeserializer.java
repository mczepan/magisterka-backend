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

public class FootballMatchDeserializer extends JsonDeserializer<Teams> {

    @Override
    public Teams deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        if(node.findPath("Match").isArray()) {
            ArrayList<Match> matches = new ArrayList<>();
            for(JsonNode tempNode: node.get("Match")) {
                matches.add(parseMatch(tempNode));
            }
            Teams teams  = new Teams();
            teams.setMatch(matches);
            return teams;

        } else if(!node.findPath("teams").isArray()) {
            JsonNode locatedNode = node.path("Match");
            ArrayList<Match> matches = new ArrayList<>();
            try {
                locatedNode.get("Date").textValue();
            } catch (Exception e) {
             return null;
            }
            matches.add(parseMatch(locatedNode));
            Teams teams  = new Teams();
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
        m.setTime(locatedNode.get("Time").textValue());
        m.setHomeGoals(locatedNode.get("HomeGoals").textValue());
        m.setAwayGoals(locatedNode.get("AwayGoals").textValue());
        m.setHomeGoalDetails(locatedNode.get("HomeGoalDetails").textValue());
        m.setAwayGoalDetails(locatedNode.get("AwayGoalDetails").textValue());
        m.setHomeLineupGoalkeeper(locatedNode.get("HomeLineupGoalkeeper").textValue());
        m.setAwayLineupGoalkeeper(locatedNode.get("AwayLineupGoalkeeper").textValue());
        m.setHomeLineupDefense(locatedNode.get("HomeLineupDefense").textValue());
        m.setAwayLineupDefense(locatedNode.get("AwayLineupDefense").textValue());
        m.setHomeLineupMidfield(locatedNode.get("HomeLineupMidfield").textValue());
        m.setAwayLineupMidfield(locatedNode.get("AwayLineupMidfield").textValue());
        m.setHomeLineupForward(locatedNode.get("HomeLineupForward").textValue());
        m.setAwayLineupForward(locatedNode.get("AwayLineupForward").textValue());
        m.setHomeLineupSubstitutes(locatedNode.get("HomeLineupSubstitutes").textValue());
        m.setAwayLineupSubstitutes(locatedNode.get("AwayLineupSubstitutes").textValue());
        m.setHomeSubDetails(locatedNode.get("HomeSubDetails").textValue());
        m.setAwaySubDetails(locatedNode.get("AwaySubDetails").textValue());
        m.setLocation(locatedNode.get("Location").textValue());
        m.setStadium(locatedNode.get("Stadium").textValue());
        m.setHomeTeamYellowCardDetails(locatedNode.get("HomeTeamYellowCardDetails").textValue());
        m.setAwayTeamYellowCardDetails(locatedNode.get("AwayTeamYellowCardDetails").textValue());
        m.setHomeTeamRedCardDetails(locatedNode.get("HomeTeamRedCardDetails").textValue());
        m.setAwayTeamRedCardDetails(locatedNode.get("AwayTeamRedCardDetails").textValue());

        return m;
    }
}