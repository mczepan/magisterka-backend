
package pl.mczepan.mgrapp.model.live.football.detail;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "event",
    "match"
})
public class Data {

    @JsonProperty("event")
    private List<Event> event = null;
    @JsonProperty("match")
    private Match match = null;

    @JsonProperty("event")
    public List<Event> getEvent() {
        return event;
    }

    @JsonProperty("event")
    public void setEvent(List<Event> event) {
        this.event = event;
    }


    @JsonProperty("match")
    public Match getMatch() {
        return match;
    }

    @JsonProperty("match")
    public void setMatch(Match match) {
        this.match = match;
    }
}
