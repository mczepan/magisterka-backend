
package pl.mczepan.mgrapp.model.live.football;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Match"
})
public class Teams {


    @JsonProperty("Match")
    private List<Match> match = null;

    @JsonProperty("Match")
    public List<Match> getMatch() {
        return match;
    }

    @JsonProperty("Match")
    public void setMatch(List<Match> match) {
        this.match = match;
    }
     /*
    @JsonProperty("Match")
    private Match match = null;

    @JsonProperty("Match")
    public Match getMatch() {
        return match;
    }

    @JsonProperty("Match")
    public void setMatch(Match match) {
        this.match = match;
    }*/

}
