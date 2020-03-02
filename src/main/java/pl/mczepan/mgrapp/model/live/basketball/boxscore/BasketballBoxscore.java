
package pl.mczepan.mgrapp.model.live.basketball.boxscore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "basicGameData"
})
public class BasketballBoxscore {

    @JsonProperty("basicGameData")
    private BasicGameData basicGameData;

    @JsonProperty("basicGameData")
    public BasicGameData getBasicGameData() {
        return basicGameData;
    }

    @JsonProperty("basicGameData")
    public void setBasicGameData(BasicGameData basicGameData) {
        this.basicGameData = basicGameData;
    }

}
