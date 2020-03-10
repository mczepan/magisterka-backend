
package pl.mczepan.mgrapp.model.league.table.basketball;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "teamId",
        "win",
        "loss",
        "teamSitesOnly"
})
public class West {

    @JsonProperty("teamId")
    private String teamId;
    @JsonProperty("win")
    private String win;
    @JsonProperty("loss")
    private String loss;
    @JsonProperty("teamSitesOnly")
    private TeamSitesOnlyWest teamSitesOnly;

    private String logoPath;

    @JsonProperty("teamId")
    public String getTeamId() {
        return teamId;
    }

    @JsonProperty("teamId")
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("win")
    public String getWin() {
        return win;
    }

    @JsonProperty("win")
    public void setWin(String win) {
        this.win = win;
    }

    @JsonProperty("loss")
    public String getLoss() {
        return loss;
    }

    @JsonProperty("loss")
    public void setLoss(String loss) {
        this.loss = loss;
    }

    @JsonProperty("teamSitesOnly")
    public TeamSitesOnlyWest getTeamSitesOnly() {
        return teamSitesOnly;
    }

    @JsonProperty("teamSitesOnly")
    public void setTeamSitesOnly(TeamSitesOnlyWest teamSitesOnly) {
        this.teamSitesOnly = teamSitesOnly;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

}
