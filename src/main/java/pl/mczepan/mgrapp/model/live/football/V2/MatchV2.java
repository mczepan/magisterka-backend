package pl.mczepan.mgrapp.model.live.football.V2;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idLiveScore",
        "idEvent",
        "strSport",
        "idLeague",
        "strLeague",
        "idHomeTeam",
        "idAwayTeam",
        "strHomeTeam",
        "strAwayTeam",
        "strHomeTeamBadge",
        "strAwayTeamBadge",
        "intHomeScore",
        "intAwayScore",
        "strPlayer",
        "idPlayer",
        "intEventScore",
        "intEventScoreTotal",
        "strProgress",
        "strEventTime",
        "dateEvent",
        "updated"
})
public class MatchV2 {

    @JsonProperty("idLiveScore")
    private String idLiveScore;
    @JsonProperty("idEvent")
    private String idEvent;
    @JsonProperty("strSport")
    private String strSport;
    @JsonProperty("idLeague")
    private String idLeague;
    @JsonProperty("strLeague")
    private String strLeague;
    @JsonProperty("idHomeTeam")
    private String idHomeTeam;
    @JsonProperty("idAwayTeam")
    private String idAwayTeam;
    @JsonProperty("strHomeTeam")
    private String strHomeTeam;
    @JsonProperty("strAwayTeam")
    private String strAwayTeam;
    @JsonProperty("strHomeTeamBadge")
    private String strHomeTeamBadge;
    @JsonProperty("strAwayTeamBadge")
    private String strAwayTeamBadge;
    @JsonProperty("intHomeScore")
    private String intHomeScore;
    @JsonProperty("intAwayScore")
    private String intAwayScore;
    @JsonProperty("strPlayer")
    private Object strPlayer;
    @JsonProperty("idPlayer")
    private Object idPlayer;
    @JsonProperty("intEventScore")
    private Object intEventScore;
    @JsonProperty("intEventScoreTotal")
    private Object intEventScoreTotal;
    @JsonProperty("strProgress")
    private String strProgress;
    @JsonProperty("strEventTime")
    private String strEventTime;
    @JsonProperty("dateEvent")
    private String dateEvent;
    @JsonProperty("updated")
    private String updated;

    @JsonProperty("idLiveScore")
    public String getIdLiveScore() {
        return idLiveScore;
    }

    @JsonProperty("idLiveScore")
    public void setIdLiveScore(String idLiveScore) {
        this.idLiveScore = idLiveScore;
    }

    @JsonProperty("idEvent")
    public String getIdEvent() {
        return idEvent;
    }

    @JsonProperty("idEvent")
    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    @JsonProperty("strSport")
    public String getStrSport() {
        return strSport;
    }

    @JsonProperty("strSport")
    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    @JsonProperty("idLeague")
    public String getIdLeague() {
        return idLeague;
    }

    @JsonProperty("idLeague")
    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    @JsonProperty("strLeague")
    public String getStrLeague() {
        return strLeague;
    }

    @JsonProperty("strLeague")
    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    @JsonProperty("idHomeTeam")
    public String getIdHomeTeam() {
        return idHomeTeam;
    }

    @JsonProperty("idHomeTeam")
    public void setIdHomeTeam(String idHomeTeam) {
        this.idHomeTeam = idHomeTeam;
    }

    @JsonProperty("idAwayTeam")
    public String getIdAwayTeam() {
        return idAwayTeam;
    }

    @JsonProperty("idAwayTeam")
    public void setIdAwayTeam(String idAwayTeam) {
        this.idAwayTeam = idAwayTeam;
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

    @JsonProperty("strHomeTeamBadge")
    public String getStrHomeTeamBadge() {
        return strHomeTeamBadge;
    }

    @JsonProperty("strHomeTeamBadge")
    public void setStrHomeTeamBadge(String strHomeTeamBadge) {
        this.strHomeTeamBadge = strHomeTeamBadge;
    }

    @JsonProperty("strAwayTeamBadge")
    public String getStrAwayTeamBadge() {
        return strAwayTeamBadge;
    }

    @JsonProperty("strAwayTeamBadge")
    public void setStrAwayTeamBadge(String strAwayTeamBadge) {
        this.strAwayTeamBadge = strAwayTeamBadge;
    }

    @JsonProperty("intHomeScore")
    public String getIntHomeScore() {
        return intHomeScore;
    }

    @JsonProperty("intHomeScore")
    public void setIntHomeScore(String intHomeScore) {
        this.intHomeScore = intHomeScore;
    }

    @JsonProperty("intAwayScore")
    public String getIntAwayScore() {
        return intAwayScore;
    }

    @JsonProperty("intAwayScore")
    public void setIntAwayScore(String intAwayScore) {
        this.intAwayScore = intAwayScore;
    }

    @JsonProperty("strPlayer")
    public Object getStrPlayer() {
        return strPlayer;
    }

    @JsonProperty("strPlayer")
    public void setStrPlayer(Object strPlayer) {
        this.strPlayer = strPlayer;
    }

    @JsonProperty("idPlayer")
    public Object getIdPlayer() {
        return idPlayer;
    }

    @JsonProperty("idPlayer")
    public void setIdPlayer(Object idPlayer) {
        this.idPlayer = idPlayer;
    }

    @JsonProperty("intEventScore")
    public Object getIntEventScore() {
        return intEventScore;
    }

    @JsonProperty("intEventScore")
    public void setIntEventScore(Object intEventScore) {
        this.intEventScore = intEventScore;
    }

    @JsonProperty("intEventScoreTotal")
    public Object getIntEventScoreTotal() {
        return intEventScoreTotal;
    }

    @JsonProperty("intEventScoreTotal")
    public void setIntEventScoreTotal(Object intEventScoreTotal) {
        this.intEventScoreTotal = intEventScoreTotal;
    }

    @JsonProperty("strProgress")
    public String getStrProgress() {
        return strProgress;
    }

    @JsonProperty("strProgress")
    public void setStrProgress(String strProgress) {
        this.strProgress = strProgress;
    }

    @JsonProperty("strEventTime")
    public String getStrEventTime() {
        return strEventTime;
    }

    @JsonProperty("strEventTime")
    public void setStrEventTime(String strEventTime) {
        this.strEventTime = strEventTime;
    }

    @JsonProperty("dateEvent")
    public String getDateEvent() {
        return dateEvent;
    }

    @JsonProperty("dateEvent")
    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

}