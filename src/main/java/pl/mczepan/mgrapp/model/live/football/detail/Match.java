
package pl.mczepan.mgrapp.model.live.football.detail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("home_name")
    @Expose
    private String homeName;
    @SerializedName("away_name")
    @Expose
    private String awayName;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("ht_score")
    @Expose
    private String htScore;
    @SerializedName("ft_score")
    @Expose
    private String ftScore;
    @SerializedName("et_score")
    @Expose
    private String etScore;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("league_id")
    @Expose
    private String leagueId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("added")
    @Expose
    private String added;
    @SerializedName("last_changed")
    @Expose
    private String lastChanged;
    @SerializedName("home_id")
    @Expose
    private String homeId;
    @SerializedName("away_id")
    @Expose
    private String awayId;
    @SerializedName("competition_id")
    @Expose
    private String competitionId;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("fixture_id")
    @Expose
    private String fixtureId;
    @SerializedName("scheduled")
    @Expose
    private String scheduled;
    @SerializedName("home")
    @Expose
    private Home home;
    @SerializedName("away")
    @Expose
    private Away away;
    @SerializedName("competition")
    @Expose
    private Competition competition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHtScore() {
        return htScore;
    }

    public void setHtScore(String htScore) {
        this.htScore = htScore;
    }

    public String getFtScore() {
        return ftScore;
    }

    public void setFtScore(String ftScore) {
        this.ftScore = ftScore;
    }

    public String getEtScore() {
        return etScore;
    }

    public void setEtScore(String etScore) {
        this.etScore = etScore;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(String lastChanged) {
        this.lastChanged = lastChanged;
    }

    public String getHomeId() {
        return homeId;
    }

    public void setHomeId(String homeId) {
        this.homeId = homeId;
    }

    public String getAwayId() {
        return awayId;
    }

    public void setAwayId(String awayId) {
        this.awayId = awayId;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(String fixtureId) {
        this.fixtureId = fixtureId;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public Away getAway() {
        return away;
    }

    public void setAway(Away away) {
        this.away = away;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

}
