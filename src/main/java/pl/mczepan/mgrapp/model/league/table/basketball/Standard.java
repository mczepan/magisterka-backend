
package pl.mczepan.mgrapp.model.league.table.basketball;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "seasonYear",
    "seasonStageId",
    "conference"
})
public class Standard {

    @JsonProperty("seasonYear")
    private Integer seasonYear;
    @JsonProperty("seasonStageId")
    private Integer seasonStageId;
    @JsonProperty("conference")
    private Conference conference;

    @JsonProperty("seasonYear")
    public Integer getSeasonYear() {
        return seasonYear;
    }

    @JsonProperty("seasonYear")
    public void setSeasonYear(Integer seasonYear) {
        this.seasonYear = seasonYear;
    }

    @JsonProperty("seasonStageId")
    public Integer getSeasonStageId() {
        return seasonStageId;
    }

    @JsonProperty("seasonStageId")
    public void setSeasonStageId(Integer seasonStageId) {
        this.seasonStageId = seasonStageId;
    }

    @JsonProperty("conference")
    public Conference getConference() {
        return conference;
    }

    @JsonProperty("conference")
    public void setConference(Conference conference) {
        this.conference = conference;
    }

}
