
package pl.mczepan.mgrapp.model.league.table.basketball;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "east",
    "west"
})
public class Conference {

    @JsonProperty("east")
    private List<East> east = null;
    @JsonProperty("west")
    private List<West> west = null;

    @JsonProperty("east")
    public List<East> getEast() {
        return east;
    }

    @JsonProperty("east")
    public void setEast(List<East> east) {
        this.east = east;
    }

    @JsonProperty("west")
    public List<West> getWest() {
        return west;
    }

    @JsonProperty("west")
    public void setWest(List<West> west) {
        this.west = west;
    }

}
