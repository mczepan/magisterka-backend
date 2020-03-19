
package pl.mczepan.mgrapp.model.league.table.football;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idLeague",
    "strLeague",
    "strCurrentSeason",
    "strWebsite",
    "strFacebook",
    "strTwitter",
    "strBadge",
    "strLogo"
})
public class Country {

    @JsonProperty("idLeague")
    private String idLeague;
    @JsonProperty("strLeague")
    private String strLeague;
    @JsonProperty("strCurrentSeason")
    private String strCurrentSeason;
    @JsonProperty("strWebsite")
    private String strWebsite;
    @JsonProperty("strFacebook")
    private String strFacebook;
    @JsonProperty("strTwitter")
    private String strTwitter;
    @JsonProperty("strBadge")
    private String strBadge;
    @JsonProperty("strLogo")
    private Object strLogo;

    @JsonProperty("idLeague")
    public String getIdLeague() {
        return idLeague;
    }

    @JsonProperty("idLeague")
    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    @JsonProperty("strLeague")
    public String getStrLeague() {
        return strLeague;
    }

    @JsonProperty("strLeague")
    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    @JsonProperty("strCurrentSeason")
    public String getStrCurrentSeason() {
        return strCurrentSeason;
    }

    @JsonProperty("strCurrentSeason")
    public void setStrCurrentSeason(String strCurrentSeason) {
        this.strCurrentSeason = strCurrentSeason;
    }

    @JsonProperty("strWebsite")
    public String getStrWebsite() {
        return strWebsite;
    }

    @JsonProperty("strWebsite")
    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    @JsonProperty("strFacebook")
    public String getStrFacebook() {
        return strFacebook;
    }

    @JsonProperty("strFacebook")
    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }

    @JsonProperty("strTwitter")
    public String getStrTwitter() {
        return strTwitter;
    }

    @JsonProperty("strTwitter")
    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    @JsonProperty("strBadge")
    public String getStrBadge() {
        return strBadge;
    }

    @JsonProperty("strBadge")
    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    @JsonProperty("strLogo")
    public Object getStrLogo() {
        return strLogo;
    }

    @JsonProperty("strLogo")
    public void setStrLogo(Object strLogo) {
        this.strLogo = strLogo;
    }

}
