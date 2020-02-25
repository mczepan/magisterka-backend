
package pl.mczepan.mgrapp.model.live.football.detail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "player",
    "time",
    "event",
    "home_away"
})
public class Event {

    @JsonProperty("player")
    private String player;
    @JsonProperty("time")
    private String time;
    @JsonProperty("event")
    private String event;
    @JsonProperty("home_away")
    private String homeAway;

    @JsonProperty("player")
    public String getPlayer() {
        return player;
    }

    @JsonProperty("player")
    public void setPlayer(String player) {
        this.player = player;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("event")
    public String getEvent() {
        return event;
    }

    @JsonProperty("event")
    public void setEvent(String event) {
        this.event = event;
    }

    @JsonProperty("home_away")
    public String getHomeAway() {
        return homeAway;
    }

    @JsonProperty("home_away")
    public void setHomeAway(String homeAway) {
        this.homeAway = homeAway;
    }

}
