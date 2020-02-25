
package pl.mczepan.mgrapp.model.live.football;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "match"
})
public class Data {

    @JsonProperty("match")
    private List<Match> match = null;

    @JsonProperty("match")
    public List<Match> getMatch() {
        return match;
    }

    @JsonProperty("match")
    public void setMatch(List<Match> match) {
        this.match = match;
    }

}
