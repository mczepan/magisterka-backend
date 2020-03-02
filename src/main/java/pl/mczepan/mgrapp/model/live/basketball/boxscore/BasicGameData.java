
package pl.mczepan.mgrapp.model.live.basketball.boxscore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "arena",
    "isGameActivated",
    "startTimeUTC",
    "vTeamScore",
    "hTeamScore"
})
public class BasicGameData {

    @JsonProperty("arena")
    private Arena arena;
    @JsonProperty("isGameActivated")
    private Boolean isGameActivated;
    @JsonProperty("startTimeUTC")
    private String startTimeUTC;
    @JsonProperty("vTeam")
    private VTeamScore vTeamScore;
    @JsonProperty("hTeam")
    private HTeamScore hTeamScore;

    @JsonProperty("arena")
    public Arena getArena() {
        return arena;
    }

    @JsonProperty("arena")
    public void setArena(Arena arena) {
        this.arena = arena;
    }

    @JsonProperty("isGameActivated")
    public Boolean getIsGameActivated() {
        return isGameActivated;
    }

    @JsonProperty("isGameActivated")
    public void setIsGameActivated(Boolean isGameActivated) {
        this.isGameActivated = isGameActivated;
    }

    @JsonProperty("startTimeUTC")
    public String getStartTimeUTC() {
        return startTimeUTC;
    }

    @JsonProperty("startTimeUTC")
    public void setStartTimeUTC(String startTimeUTC) {
        this.startTimeUTC = startTimeUTC;
    }

    @JsonProperty("vTeam")
    public VTeamScore getVTeamScore() {
        return vTeamScore;
    }

    @JsonProperty("vTeam")
    public void setVTeamScore(VTeamScore vTeamScore) {
        this.vTeamScore = vTeamScore;
    }

    @JsonProperty("hTeam")
    public HTeamScore getHTeamScore() {
        return hTeamScore;
    }

    @JsonProperty("hTeam")
    public void setHTeamScore(HTeamScore hTeamScore) {
        this.hTeamScore = hTeamScore;
    }

}
