
package pl.mczepan.mgrapp.model.user.FavouriteTeamNextEvent;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "events"
})
public class FavTeamNextEvent {

    @JsonProperty("events")
    private List<NextEvent> events = null;

    @JsonProperty("events")
    public List<NextEvent> getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(List<NextEvent> events) {
        this.events = events;
    }

}
