
package pl.mczepan.mgrapp.model.live.basketball;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "games"
})
public class LiveBasketball {

    @JsonProperty("games")
    private List<Game> games = null;

    @JsonProperty("games")
    public List<Game> getGames() {
        return games;
    }

    @JsonProperty("games")
    public void setGames(List<Game> games) {
        this.games = games;
    }
}
