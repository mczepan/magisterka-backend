
package pl.mczepan.mgrapp.model.user.FavouriteTeamPastEvent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "strLeague",
    "strHomeTeam",
    "strAwayTeam",
    "intHomeScore",
    "intAwayScore",
    "dateEvent",
    "strTimeLocal"
})
public class LastResult {

    @JsonProperty("strLeague")
    private String strLeague;
    @JsonProperty("strHomeTeam")
    private String strHomeTeam;
    @JsonProperty("strAwayTeam")
    private String strAwayTeam;
    @JsonProperty("intHomeScore")
    private Object intHomeScore;
    @JsonProperty("intAwayScore")
    private Object intAwayScore;
    @JsonProperty("dateEvent")
    private String dateEvent;
    @JsonProperty("strTime")
    private String strTime;

    @JsonProperty("strLeague")
    public String getStrLeague() {
        return strLeague;
    }

    @JsonProperty("strLeague")
    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    @JsonProperty("strHomeTeam")
    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    @JsonProperty("strHomeTeam")
    public void setStrHomeTeam(String strHomeTeam) {
        this.strHomeTeam = strHomeTeam;
    }

    @JsonProperty("strAwayTeam")
    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    @JsonProperty("strAwayTeam")
    public void setStrAwayTeam(String strAwayTeam) {
        this.strAwayTeam = strAwayTeam;
    }

    @JsonProperty("intHomeScore")
    public Object getIntHomeScore() {
        return intHomeScore;
    }

    @JsonProperty("intHomeScore")
    public void setIntHomeScore(Object intHomeScore) {
        this.intHomeScore = intHomeScore;
    }

    @JsonProperty("intAwayScore")
    public Object getIntAwayScore() {
        return intAwayScore;
    }

    @JsonProperty("intAwayScore")
    public void setIntAwayScore(Object intAwayScore) {
        this.intAwayScore = intAwayScore;
    }

    @JsonProperty("dateEvent")
    public String getDateEvent() {
        return dateEvent;
    }

    @JsonProperty("dateEvent")
    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    @JsonProperty("strTime")
    public String getStrTime() {
        return strTime;
    }

    @JsonProperty("strTime")
    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }
}
