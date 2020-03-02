
package pl.mczepan.mgrapp.model.live.basketball.boxscore;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "triCode",
    "score",
    "linescoreHTeam"
})
public class HTeamScore {

    private String logoPath;
    @JsonProperty("triCode")
    private String triCode;
    @JsonProperty("score")
    private String score;
    @JsonProperty("linescore")
    private List<LinescoreHTeam> linescoreHTeam = null;

    @JsonProperty("triCode")
    public String getTriCode() {
        return triCode;
    }

    @JsonProperty("triCode")
    public void setTriCode(String triCode) {
        this.triCode = triCode;
    }

    @JsonProperty("score")
    public String getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(String score) {
        this.score = score;
    }

    @JsonProperty("linescore")
    public List<LinescoreHTeam> getLinescoreHTeam() {
        return linescoreHTeam;
    }

    @JsonProperty("linescore")
    public void setLinescoreHTeam(List<LinescoreHTeam> linescoreHTeam) {
        this.linescoreHTeam = linescoreHTeam;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
}
