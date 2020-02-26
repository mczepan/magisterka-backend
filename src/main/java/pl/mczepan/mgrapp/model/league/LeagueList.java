
package pl.mczepan.mgrapp.model.league;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "leagues"
})
public class LeagueList {

    @JsonProperty("leagues")
    private List<League> leagues = null;

    @JsonProperty("leagues")
    public List<League> getLeagues() {
        return leagues;
    }

    @JsonProperty("leagues")
    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

}
