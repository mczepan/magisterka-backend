package pl.mczepan.mgrapp.model.live.football.V2;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "events"
})
public class EventsList {

    @JsonProperty("events")
    private List<MatchV2> match = null;

    @JsonProperty("events")
    public List<MatchV2> getPlayer() {
        return match;
    }

    @JsonProperty("events")
    public void setPlayer(List<MatchV2> match) {
        this.match = match;
    }
}
