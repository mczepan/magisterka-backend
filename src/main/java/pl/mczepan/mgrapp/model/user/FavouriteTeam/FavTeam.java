
package pl.mczepan.mgrapp.model.user.FavouriteTeam;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import pl.mczepan.mgrapp.model.search.team.Team;
import pl.mczepan.mgrapp.model.user.FavouriteTeamNextEvent.NextEvent;
import pl.mczepan.mgrapp.model.user.FavouriteTeamPastEvent.LastResult;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "player"
})
public class FavTeam {

    @JsonProperty("player")
    private List<Player> player = null;

    @JsonProperty("nextEvents")
    private List<NextEvent> nextEvents = null;

    @JsonProperty("lastResults")
    private List<LastResult> lastResults = null;

    @JsonProperty("teamInfo")
    private Team teamInfo;

    @JsonProperty("player")
    public List<Player> getPlayer() {
        return player;
    }

    @JsonProperty("player")
    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    @JsonProperty("nextEvents")
    public List<NextEvent> getNextEvents() {
        return nextEvents;
    }

    @JsonProperty("nextEvents")
    public void setNextEvents(List<NextEvent> nextEvents) {
        this.nextEvents = nextEvents;
    }

    @JsonProperty("lastResults")
    public List<LastResult> getLastResults() {
        return lastResults;
    }

    @JsonProperty("lastResults")
    public void setLastResults(List<LastResult> lastResults) {
        this.lastResults = lastResults;
    }

    @JsonProperty("teamInfo")
    public Team getTeamInfo() {
        return teamInfo;
    }

    @JsonProperty("teamInfo")
    public void setTeamInfo(Team teamInfo) {
        this.teamInfo = teamInfo;
    }
}
