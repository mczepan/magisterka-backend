
package pl.mczepan.mgrapp.model.league.country;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "countrys"
})
public class CountryLeagueList {

    @JsonProperty("countrys")
    private List<CountryLeague> countryLeagues = null;

    @JsonProperty("countrys")
    public List<CountryLeague> getCountryLeagues() {
        return countryLeagues;
    }

    @JsonProperty("countrys")
    public void setCountryLeagues(List<CountryLeague> countryLeagues) {
        this.countryLeagues = countryLeagues;
    }

}
