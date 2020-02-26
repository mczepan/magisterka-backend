
package pl.mczepan.mgrapp.model.league.country;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idLeague",
    "strSport",
    "strLeague",
    "strCountry"
})
public class CountryLeague {

    @JsonProperty("idLeague")
    private String idLeague;
    @JsonProperty("strSport")
    private String strSport;
    @JsonProperty("strLeague")
    private String strLeague;
    @JsonProperty("strCountry")
    private String strCountry;

    @JsonProperty("idLeague")
    public String getIdLeague() {
        return idLeague;
    }

    @JsonProperty("idLeague")
    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    @JsonProperty("strSport")
    public String getStrSport() {
        return strSport;
    }

    @JsonProperty("strSport")
    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    @JsonProperty("strLeague")
    public String getStrLeague() {
        return strLeague;
    }

    @JsonProperty("strLeague")
    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    @JsonProperty("strCountry")
    public String getStrCountry() {
        return strCountry;
    }

    @JsonProperty("strCountry")
    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }

}
