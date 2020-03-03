
package pl.mczepan.mgrapp.model.search.team;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idTeam",
    "strTeam",
    "strLeague",
    "idLeague",
    "strStadium",
    "strKeywords",
    "intStadiumCapacity",
    "strWebsite",
    "strFacebook",
    "strTwitter",
    "strInstagram",
    "strDescriptionEN"
})
public class Team {

    @JsonProperty("idTeam")
    private String idTeam;
    @JsonProperty("strTeam")
    private String strTeam;
    @JsonProperty("intFormedYear")
    private String intFormedYear;
    @JsonProperty("strSport")
    private String strSport;
    @JsonProperty("strLeague")
    private String strLeague;
    @JsonProperty("idLeague")
    private String idLeague;
    @JsonProperty("strStadium")
    private String strStadium;
    @JsonProperty("strKeywords")
    private String strKeywords;
    @JsonProperty("intStadiumCapacity")
    private String intStadiumCapacity;
    @JsonProperty("strWebsite")
    private String strWebsite;
    @JsonProperty("strFacebook")
    private String strFacebook;
    @JsonProperty("strTwitter")
    private String strTwitter;
    @JsonProperty("strInstagram")
    private String strInstagram;
    @JsonProperty("strDescriptionEN")
    private String strDescriptionEN;
    @JsonProperty("strTeamBadge")
    private String strTeamBadge;

    @JsonProperty("idTeam")
    public String getIdTeam() {
        return idTeam;
    }

    @JsonProperty("idTeam")
    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    @JsonProperty("strTeam")
    public String getStrTeam() {
        return strTeam;
    }

    @JsonProperty("strTeam")
    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    @JsonProperty("intFormedYear")
    public String getIntFormedYear() {
        return intFormedYear;
    }

    @JsonProperty("intFormedYear")
    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
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

    @JsonProperty("idLeague")
    public String getIdLeague() {
        return idLeague;
    }

    @JsonProperty("idLeague")
    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    @JsonProperty("strStadium")
    public String getStrStadium() {
        return strStadium;
    }

    @JsonProperty("strStadium")
    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    @JsonProperty("strKeywords")
    public String getStrKeywords() {
        return strKeywords;
    }

    @JsonProperty("strKeywords")
    public void setStrKeywords(String strKeywords) {
        this.strKeywords = strKeywords;
    }

    @JsonProperty("intStadiumCapacity")
    public String getIntStadiumCapacity() {
        return intStadiumCapacity;
    }

    @JsonProperty("intStadiumCapacity")
    public void setIntStadiumCapacity(String intStadiumCapacity) {
        this.intStadiumCapacity = intStadiumCapacity;
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

    @JsonProperty("strInstagram")
    public String getStrInstagram() {
        return strInstagram;
    }

    @JsonProperty("strInstagram")
    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
    }

    @JsonProperty("strDescriptionEN")
    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    @JsonProperty("strDescriptionEN")
    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    @JsonProperty("strTeamBadge")
    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    @JsonProperty("strTeamBadge")
    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }
}
