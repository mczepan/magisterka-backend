
package pl.mczepan.mgrapp.model.user.FavouriteTeamNextEvent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idEvent",
        "strLeague",
        "strHomeTeam",
        "strAwayTeam",
        "dateEvent",
        "strTime",
        "strHomeTeamBadge",
        "strAwayTeamBadge"
})
public class NextEvent {

    @JsonProperty("strLeague")
    private String strLeague;
    @JsonProperty("strHomeTeam")
    private String strHomeTeam;
    @JsonProperty("strAwayTeam")
    private String strAwayTeam;
    @JsonProperty("dateEvent")
    private String dateEvent;
    @JsonProperty("strTime")
    private String strTime;
    @JsonProperty("idEvent")
    private String idEvent;
    @JsonProperty("strHomeTeamBadge")
    private String strHomeTeamBadge;
    @JsonProperty("strAwayTeamBadge")
    private String strAwayTeamBadge;

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

    @JsonProperty("idEvent")
    public String getIdEvent() {
        return idEvent;
    }

    @JsonProperty("idEvent")
    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getStrHomeTeamBadge() {
        return strHomeTeamBadge;
    }

    public void setStrHomeTeamBadge(String strHomeTeamBadge) {
        this.strHomeTeamBadge = strHomeTeamBadge;
    }

    public String getStrAwayTeamBadge() {
        return strAwayTeamBadge;
    }

    public void setStrAwayTeamBadge(String strAwayTeamBadge) {
        this.strAwayTeamBadge = strAwayTeamBadge;
    }

}
