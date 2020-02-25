
package pl.mczepan.mgrapp.model.live.football.detail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "home_name",
    "away_name",
    "score",
    "time",
    "status"
})
public class Match {

    @JsonProperty("id")
    private String id;
    @JsonProperty("home_name")
    private String homeName;
    @JsonProperty("away_name")
    private String awayName;
    @JsonProperty("score")
    private String score;
    @JsonProperty("time")
    private String time;
    @JsonProperty("status")
    private String status;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("home_name")
    public String getHomeName() {
        return homeName;
    }

    @JsonProperty("home_name")
    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    @JsonProperty("away_name")
    public String getAwayName() {
        return awayName;
    }

    @JsonProperty("away_name")
    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    @JsonProperty("score")
    public String getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(String score) {
        this.score = score;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

}
