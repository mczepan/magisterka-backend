
package pl.mczepan.mgrapp.model.league.table.football;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "countrys"
})
public class FootballCountryLeagues {

    @JsonProperty("countrys")
    private List<Country> countries = null;

    @JsonProperty("countrys")
    public List<Country> getCountries() {
        return countries;
    }

    @JsonProperty("countrys")
    public void setCountrys(List<Country> countries) {
        this.countries = countries;
    }

}
