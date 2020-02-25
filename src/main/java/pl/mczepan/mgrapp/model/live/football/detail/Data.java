
package pl.mczepan.mgrapp.model.live.football.detail;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("event")
    @Expose
    private List<Event> event = null;
    @SerializedName("match")
    @Expose
    private List<Match> match;

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    public List<Match> getMatch() {
        return match;
    }

    public void setMatch(List<Match> match) {
        this.match = match;
    }

}
