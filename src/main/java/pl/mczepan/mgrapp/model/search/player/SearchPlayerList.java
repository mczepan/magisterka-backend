
package pl.mczepan.mgrapp.model.search.player;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "player"
})
public class SearchPlayerList {

    @JsonProperty("players")
    private List<Player> player = null;

    @JsonProperty("players")
    public List<Player> getPlayer() {
        return player;
    }

    @JsonProperty("players")
    public void setPlayer(List<Player> player) {
        this.player = player;
    }

}
