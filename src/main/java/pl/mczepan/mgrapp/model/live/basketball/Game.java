
package pl.mczepan.mgrapp.model.live.basketball;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isGameActivated",
        "clock",
        "vTeam",
        "hTeam"
})
public class Game {

    @JsonProperty("date")
    private String date;
    @JsonProperty("isGameActivated")
    private Boolean isGameActivated;
    @JsonProperty("clock")
    private String clock;
    @JsonProperty("vTeam")
    private VTeam vTeam;
    @JsonProperty("hTeam")
    private HTeam hTeam;

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("isGameActivated")
    public Boolean getIsGameActivated() {
        return isGameActivated;
    }

    @JsonProperty("isGameActivated")
    public void setIsGameActivated(Boolean isGameActivated) {
        this.isGameActivated = isGameActivated;
    }

    @JsonProperty("clock")
    public String getClock() {
        return clock;
    }

    @JsonProperty("clock")
    public void setClock(String clock) {
        this.clock = clock;
    }

    @JsonProperty("vTeam")
    public VTeam getVTeam() {
        return vTeam;
    }

    @JsonProperty("vTeam")
    public void setVTeam(VTeam vTeam) {
        this.vTeam = vTeam;
    }

    @JsonProperty("hTeam")
    public HTeam getHTeam() {
        return hTeam;
    }

    @JsonProperty("hTeam")
    public void setHTeam(HTeam hTeam) {
        this.hTeam = hTeam;
    }


}
