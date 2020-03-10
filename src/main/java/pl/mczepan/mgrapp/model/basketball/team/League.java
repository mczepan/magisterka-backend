
package pl.mczepan.mgrapp.model.basketball.team;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "standard"
})
public class League {

    @JsonProperty("standard")
    private List<Standard> standard = null;

    @JsonProperty("standard")
    public List<Standard> getStandard() {
        return standard;
    }

    @JsonProperty("standard")
    public void setStandard(List<Standard> standard) {
        this.standard = standard;
    }

}
