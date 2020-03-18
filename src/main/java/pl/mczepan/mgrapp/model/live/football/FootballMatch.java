
package pl.mczepan.mgrapp.model.live.football;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.mczepan.mgrapp.MyJsonDeserializer.FootballMatchDeserializer;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "teams"
})
public class FootballMatch {

    @JsonProperty("teams")
    @JsonDeserialize(using = FootballMatchDeserializer.class)
    private Teams teams;

    @JsonProperty("teams")
    public Teams getTeams() {
        return teams;
    }

    @JsonProperty("teams")
    public void setTeams(Teams teams) {
        this.teams = teams;
    }

}
