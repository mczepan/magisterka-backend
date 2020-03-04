
package pl.mczepan.mgrapp.model.search.player;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "player"
})
public class SearchPlayersList {

    @JsonProperty("player")
    private List<Player> player = null;

    @JsonProperty("player")
    public List<Player> getPlayer() {
        return player;
    }

    @JsonProperty("player")
    public void setPlayer(List<Player> player) {
        this.player = player;
    }

}
