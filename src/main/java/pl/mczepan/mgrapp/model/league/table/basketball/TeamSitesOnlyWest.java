
package pl.mczepan.mgrapp.model.league.table.basketball;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "teamName",
    "teamNickname"
})
public class TeamSitesOnlyWest {

    @JsonProperty("teamName")
    private String teamName;
    @JsonProperty("teamNickname")
    private String teamNickname;
    @JsonProperty("teamTricode")
    private String teamTricode;


    @JsonProperty("teamName")
    public String getTeamName() {
        return teamName;
    }

    @JsonProperty("teamName")
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @JsonProperty("teamNickname")
    public String getTeamNickname() {
        return teamNickname;
    }

    @JsonProperty("teamNickname")
    public void setTeamNickname(String teamNickname) {
        this.teamNickname = teamNickname;
    }

    @JsonProperty("teamTricode")
    public String getTeamTricode() {
        return teamTricode;
    }

    @JsonProperty("teamTricode")
    public void setTeamTricode(String teamTricode) {
        this.teamTricode = teamTricode;
    }

}
