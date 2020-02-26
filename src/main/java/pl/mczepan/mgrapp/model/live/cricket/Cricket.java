
package pl.mczepan.mgrapp.model.live.cricket;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "matches"
})
public class Cricket {

    @JsonProperty("matches")
    private List<CricketMatch> cricketMatches = null;

    @JsonProperty("matches")
    public List<CricketMatch> getCricketMatches() {
        return cricketMatches;
    }

    @JsonProperty("matches")
    public void setCricketMatches(List<CricketMatch> cricketMatches) {
        this.cricketMatches = cricketMatches;
    }

}
