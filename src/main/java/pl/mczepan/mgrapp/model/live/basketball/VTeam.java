
package pl.mczepan.mgrapp.model.live.basketball;

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
        "triCode",
        "score"
})
public class VTeam {

    @JsonProperty("triCode")
    private String triCode;
    @JsonProperty("score")
    private String score;
    @JsonProperty("logo")
    private String logo;

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

    @JsonProperty("logo")
    public String getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(String logo) {
        this.logo = logo;
    }
}
