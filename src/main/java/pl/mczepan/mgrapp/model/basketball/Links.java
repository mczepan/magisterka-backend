
package pl.mczepan.mgrapp.model.basketball;

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
        "currentScoreboard",
})
public class Links {

    @JsonProperty("currentScoreboard")
    private String currentScoreboard;

    @JsonProperty("currentScoreboard")
    public String getCurrentScoreboard() {
        return currentScoreboard;
    }

    @JsonProperty("currentScoreboard")
    public void setCurrentScoreboard(String currentScoreboard) {
        this.currentScoreboard = currentScoreboard;
    }

}
