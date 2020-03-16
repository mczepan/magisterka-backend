
package pl.mczepan.mgrapp.model.live.football;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import pl.mczepan.mgrapp.MyJsonDeserializer.MyDes;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "Date",
        "League",
        "Round",
        "HomeTeam",
        "HomeTeam_Id",
        "AwayTeam",
        "AwayTeam_Id",
        "Time",
        "HomeGoals",
        "AwayGoals",
        "HomeGoalDetails",
        "AwayGoalDetails",
        "HomeLineupGoalkeeper",
        "AwayLineupGoalkeeper",
        "HomeLineupDefense",
        "AwayLineupDefense",
        "HomeLineupMidfield",
        "AwayLineupMidfield",
        "HomeLineupForward",
        "AwayLineupForward",
        "HomeLineupSubstitutes",
        "AwayLineupSubstitutes",
        "HomeSubDetails",
        "AwaySubDetails",
        "Location",
        "Stadium",
        "HomeTeamYellowCardDetails",
        "AwayTeamYellowCardDetails",
        "HomeTeamRedCardDetails",
        "AwayTeamRedCardDetails"
})
public class Match {

    @JsonProperty("Date")
    private String date;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("League")
    private String league;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("Round")
    private String round;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeTeam")
    private String homeTeam;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeTeam_Id")
    private String homeTeamId;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwayTeam")
    private String awayTeam;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwayTeam_Id")
    private String awayTeamId;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("Time")
    private String time;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeGoals")
    private String homeGoals;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwayGoals")
    private String awayGoals;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeGoalDetails")
    private String homeGoalDetails;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwayGoalDetails")
    private String awayGoalDetails;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeLineupGoalkeeper")
    private String homeLineupGoalkeeper;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwayLineupGoalkeeper")
    private String awayLineupGoalkeeper;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeLineupDefense")
    private String homeLineupDefense;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwayLineupDefense")
    private String awayLineupDefense;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeLineupMidfield")
    private String homeLineupMidfield;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwayLineupMidfield")
    private String awayLineupMidfield;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeLineupForward")
    private String homeLineupForward;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwayLineupForward")
    private String awayLineupForward;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeLineupSubstitutes")
    private String homeLineupSubstitutes;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwayLineupSubstitutes")
    private String awayLineupSubstitutes;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeSubDetails")
    private String homeSubDetails;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwaySubDetails")
    private String awaySubDetails;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("Location")
    private String location;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("Stadium")
    private String stadium;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeTeamYellowCardDetails")
    private String homeTeamYellowCardDetails;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwayTeamYellowCardDetails")
    private String awayTeamYellowCardDetails;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("HomeTeamRedCardDetails")
    private String homeTeamRedCardDetails;
    @JsonDeserialize(using = MyDes.class)
    @JsonProperty("AwayTeamRedCardDetails")
    private String awayTeamRedCardDetails;


    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("League")
    public String getLeague() {
        return league;
    }

    @JsonProperty("League")
    public void setLeague(String league) {
        this.league = league;
    }

    @JsonProperty("Round")
    public String getRound() {
        return round;
    }

    @JsonProperty("Round")
    public void setRound(String round) {
        this.round = round;
    }

    @JsonProperty("HomeTeam")
    public String getHomeTeam() {
        return homeTeam;
    }

    @JsonProperty("HomeTeam")
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    @JsonProperty("HomeTeam_Id")
    public String getHomeTeamId() {
        return homeTeamId;
    }

    @JsonProperty("HomeTeam_Id")
    public void setHomeTeamId(String homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    @JsonProperty("AwayTeam")
    public String getAwayTeam() {
        return awayTeam;
    }

    @JsonProperty("AwayTeam")
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    @JsonProperty("AwayTeam_Id")
    public String getAwayTeamId() {
        return awayTeamId;
    }

    @JsonProperty("AwayTeam_Id")
    public void setAwayTeamId(String awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    @JsonProperty("Time")
    public String getTime() {
        return time;
    }

    @JsonProperty("Time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("HomeGoals")
    public String getHomeGoals() {
        return homeGoals;
    }

    @JsonProperty("HomeGoals")
    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    @JsonProperty("AwayGoals")
    public String getAwayGoals() {
        return awayGoals;
    }

    @JsonProperty("AwayGoals")
    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    @JsonProperty("HomeGoalDetails")
    public String getHomeGoalDetails() {
        return homeGoalDetails;
    }

    @JsonProperty("HomeGoalDetails")
    public void setHomeGoalDetails(String homeGoalDetails) {
        this.homeGoalDetails = homeGoalDetails;
    }

    @JsonProperty("AwayGoalDetails")
    public String getAwayGoalDetails() {
        return awayGoalDetails;
    }

    @JsonProperty("AwayGoalDetails")
    public void setAwayGoalDetails(String awayGoalDetails) {
        this.awayGoalDetails = awayGoalDetails;
    }

    @JsonProperty("HomeLineupGoalkeeper")
    public String getHomeLineupGoalkeeper() {
        return homeLineupGoalkeeper;
    }

    @JsonProperty("HomeLineupGoalkeeper")
    public void setHomeLineupGoalkeeper(String homeLineupGoalkeeper) {
        this.homeLineupGoalkeeper = homeLineupGoalkeeper;
    }

    @JsonProperty("AwayLineupGoalkeeper")
    public String getAwayLineupGoalkeeper() {
        return awayLineupGoalkeeper;
    }

    @JsonProperty("AwayLineupGoalkeeper")
    public void setAwayLineupGoalkeeper(String awayLineupGoalkeeper) {
        this.awayLineupGoalkeeper = awayLineupGoalkeeper;
    }

    @JsonProperty("HomeLineupDefense")
    public String getHomeLineupDefense() {
        return homeLineupDefense;
    }

    @JsonProperty("HomeLineupDefense")
    public void setHomeLineupDefense(String homeLineupDefense) {
        this.homeLineupDefense = homeLineupDefense;
    }

    @JsonProperty("AwayLineupDefense")
    public String getAwayLineupDefense() {
        return awayLineupDefense;
    }

    @JsonProperty("AwayLineupDefense")
    public void setAwayLineupDefense(String awayLineupDefense) {
        this.awayLineupDefense = awayLineupDefense;
    }

    @JsonProperty("HomeLineupMidfield")
    public String getHomeLineupMidfield() {
        return homeLineupMidfield;
    }

    @JsonProperty("HomeLineupMidfield")
    public void setHomeLineupMidfield(String homeLineupMidfield) {
        this.homeLineupMidfield = homeLineupMidfield;
    }

    @JsonProperty("AwayLineupMidfield")
    public String getAwayLineupMidfield() {
        return awayLineupMidfield;
    }

    @JsonProperty("AwayLineupMidfield")
    public void setAwayLineupMidfield(String awayLineupMidfield) {
        this.awayLineupMidfield = awayLineupMidfield;
    }

    @JsonProperty("HomeLineupForward")
    public String getHomeLineupForward() {
        return homeLineupForward;
    }

    @JsonProperty("HomeLineupForward")
    public void setHomeLineupForward(String homeLineupForward) {
        this.homeLineupForward = homeLineupForward;
    }

    @JsonProperty("AwayLineupForward")
    public String getAwayLineupForward() {
        return awayLineupForward;
    }

    @JsonProperty("AwayLineupForward")
    public void setAwayLineupForward(String awayLineupForward) {
        this.awayLineupForward = awayLineupForward;
    }

    @JsonProperty("HomeLineupSubstitutes")
    public String getHomeLineupSubstitutes() {
        return homeLineupSubstitutes;
    }

    @JsonProperty("HomeLineupSubstitutes")
    public void setHomeLineupSubstitutes(String homeLineupSubstitutes) {
        this.homeLineupSubstitutes = homeLineupSubstitutes;
    }

    @JsonProperty("AwayLineupSubstitutes")
    public String getAwayLineupSubstitutes() {
        return awayLineupSubstitutes;
    }

    @JsonProperty("AwayLineupSubstitutes")
    public void setAwayLineupSubstitutes(String awayLineupSubstitutes) {
        this.awayLineupSubstitutes = awayLineupSubstitutes;
    }

    @JsonProperty("HomeSubDetails")
    public String getHomeSubDetails() {
        return homeSubDetails;
    }

    @JsonProperty("HomeSubDetails")
    public void setHomeSubDetails(String homeSubDetails) {
        this.homeSubDetails = homeSubDetails;
    }

    @JsonProperty("AwaySubDetails")
    public String getAwaySubDetails() {
        return awaySubDetails;
    }

    @JsonProperty("AwaySubDetails")
    public void setAwaySubDetails(String awaySubDetails) {
        this.awaySubDetails = awaySubDetails;
    }

    @JsonProperty("Location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("Location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("Stadium")
    public String getStadium() {
        return stadium;
    }

    @JsonProperty("Stadium")
    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    @JsonProperty("HomeTeamYellowCardDetails")
    public String getHomeTeamYellowCardDetails() {
        return homeTeamYellowCardDetails;
    }

    @JsonProperty("HomeTeamYellowCardDetails")
    public void setHomeTeamYellowCardDetails(String homeTeamYellowCardDetails) {
        this.homeTeamYellowCardDetails = homeTeamYellowCardDetails;
    }

    @JsonProperty("AwayTeamYellowCardDetails")
    public String getAwayTeamYellowCardDetails() {
        return awayTeamYellowCardDetails;
    }

    @JsonProperty("AwayTeamYellowCardDetails")
    public void setAwayTeamYellowCardDetails(String awayTeamYellowCardDetails) {
        this.awayTeamYellowCardDetails = awayTeamYellowCardDetails;
    }

    @JsonProperty("HomeTeamRedCardDetails")
    public String getHomeTeamRedCardDetails() {
        return homeTeamRedCardDetails;
    }

    @JsonProperty("HomeTeamRedCardDetails")
    public void setHomeTeamRedCardDetails(String homeTeamRedCardDetails) {
        this.homeTeamRedCardDetails = homeTeamRedCardDetails;
    }

    @JsonProperty("AwayTeamRedCardDetails")
    public String getAwayTeamRedCardDetails() {
        return awayTeamRedCardDetails;
    }

    @JsonProperty("AwayTeamRedCardDetails")
    public void setAwayTeamRedCardDetails(String awayTeamRedCardDetails) {
        this.awayTeamRedCardDetails = awayTeamRedCardDetails;
    }
}
