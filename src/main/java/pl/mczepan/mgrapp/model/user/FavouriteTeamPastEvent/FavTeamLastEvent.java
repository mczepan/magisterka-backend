
package pl.mczepan.mgrapp.model.user.FavouriteTeamPastEvent;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "results"
})
public class FavTeamLastEvent {

    @JsonProperty("results")
    private List<LastResult> results = null;

    @JsonProperty("results")
    public List<LastResult> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<LastResult> results) {
        this.results = results;
    }

}
