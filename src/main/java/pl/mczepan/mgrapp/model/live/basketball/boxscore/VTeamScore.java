
package pl.mczepan.mgrapp.model.live.basketball.boxscore;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "triCode",
    "score",
    "linescoreVTeam"
})
public class VTeamScore {

    private String logoPath;
    @JsonProperty("triCode")
    private String triCode;
    @JsonProperty("score")
    private String score;
    @JsonProperty("linescore")
    private List<LinescoreVTeam> linescoreVTeam = null;

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
    public List<LinescoreVTeam> getLinescoreVTeam() {
        return linescoreVTeam;
    }

    @JsonProperty("linescore")
    public void setLinescoreVTeam(List<LinescoreVTeam> linescoreVTeam) {
        this.linescoreVTeam = linescoreVTeam;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
}
