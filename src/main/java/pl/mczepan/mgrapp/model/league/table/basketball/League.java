
package pl.mczepan.mgrapp.model.league.table.basketball;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "standard"
})
public class League {

    @JsonProperty("standard")
    private Standard standard;

    @JsonProperty("standard")
    public Standard getStandard() {
        return standard;
    }

    @JsonProperty("standard")
    public void setStandard(Standard standard) {
        this.standard = standard;
    }

}
