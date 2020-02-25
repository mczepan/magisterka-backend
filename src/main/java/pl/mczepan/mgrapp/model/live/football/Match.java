
package pl.mczepan.mgrapp.model.live.football;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "home_name",
    "id",
    "score",
    "competition_name",
    "away_name",
    "time"
})
public class Match {

    @JsonProperty("status")
    private String status;
    @JsonProperty("home_name")
    private String homeName;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("score")
    private String score;
    @JsonProperty("competition_name")
    private String competitionName;
    @JsonProperty("away_name")
    private String awayName;
    @JsonProperty("time")
    private String time;

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("home_name")
    public String getHomeName() {
        return homeName;
    }

    @JsonProperty("home_name")
    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("score")
    public String getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(String score) {
        this.score = score;
    }

    @JsonProperty("competition_name")
    public String getCompetitionName() {
        return competitionName;
    }

    @JsonProperty("competition_name")
    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    @JsonProperty("away_name")
    public String getAwayName() {
        return awayName;
    }

    @JsonProperty("away_name")
    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

}
