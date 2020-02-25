
package pl.mczepan.mgrapp.model;

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
        "sports"
})
public class SportType {

    @JsonProperty("sports")
    private List<Sport> sports = null;


    @JsonProperty("sports")
    public List<Sport> getSports() {
        return sports;
    }

    @JsonProperty("sports")
    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }
}
