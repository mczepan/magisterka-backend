
package pl.mczepan.mgrapp.model.live.basketball;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "games"
})
public class LiveBasketball {

    @JsonProperty("games")
    private List<BasketballGame> basketballGames = null;

    @JsonProperty("games")
    public List<BasketballGame> getBasketballGames() {
        return basketballGames;
    }

    @JsonProperty("games")
    public void setBasketballGames(List<BasketballGame> basketballGames) {
        this.basketballGames = basketballGames;
    }
}
