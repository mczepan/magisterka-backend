
package pl.mczepan.mgrapp.model.search.player;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "idPlayer",
    "idTeam",
    "strNationality",
    "strPlayer",
    "strTeam",
    "strSport",
    "dateBorn",
    "strNumber",
    "dateSigned",
    "strWage",
    "strBirthLocation",
    "strDescriptionEN",
    "strGender",
    "strSide",
    "strPosition",
    "strFacebook",
    "strTwitter",
    "strInstagram"
})
public class Player {

    @JsonProperty("idPlayer")
    private String idPlayer;
    @JsonProperty("idTeam")
    private String idTeam;
    @JsonProperty("strNationality")
    private String strNationality;
    @JsonProperty("strPlayer")
    private String strPlayer;
    @JsonProperty("strTeam")
    private String strTeam;
    @JsonProperty("strSport")
    private String strSport;
    @JsonProperty("dateBorn")
    private String dateBorn;
    @JsonProperty("strNumber")
    private String strNumber;
    @JsonProperty("dateSigned")
    private String dateSigned;
    @JsonProperty("strWage")
    private String strWage;
    @JsonProperty("strBirthLocation")
    private String strBirthLocation;
    @JsonProperty("strDescriptionEN")
    private String strDescriptionEN;
    @JsonProperty("strGender")
    private String strGender;
    @JsonProperty("strSide")
    private String strSide;
    @JsonProperty("strPosition")
    private String strPosition;
    @JsonProperty("strFacebook")
    private String strFacebook;
    @JsonProperty("strTwitter")
    private String strTwitter;
    @JsonProperty("strInstagram")
    private String strInstagram;
    @JsonProperty("strThumb")
    private String strThumb;


    @JsonProperty("idPlayer")
    public String getIdPlayer() {
        return idPlayer;
    }

    @JsonProperty("idPlayer")
    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }

    @JsonProperty("idTeam")
    public String getIdTeam() {
        return idTeam;
    }

    @JsonProperty("idTeam")
    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    @JsonProperty("strNationality")
    public String getStrNationality() {
        return strNationality;
    }

    @JsonProperty("strNationality")
    public void setStrNationality(String strNationality) {
        this.strNationality = strNationality;
    }

    @JsonProperty("strPlayer")
    public String getStrPlayer() {
        return strPlayer;
    }

    @JsonProperty("strPlayer")
    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }

    @JsonProperty("strTeam")
    public String getStrTeam() {
        return strTeam;
    }

    @JsonProperty("strTeam")
    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    @JsonProperty("strSport")
    public String getStrSport() {
        return strSport;
    }

    @JsonProperty("strSport")
    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    @JsonProperty("dateBorn")
    public String getDateBorn() {
        return dateBorn;
    }

    @JsonProperty("dateBorn")
    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    @JsonProperty("strNumber")
    public String getStrNumber() {
        return strNumber;
    }

    @JsonProperty("strNumber")
    public void setStrNumber(String strNumber) {
        this.strNumber = strNumber;
    }

    @JsonProperty("dateSigned")
    public String getDateSigned() {
        return dateSigned;
    }

    @JsonProperty("dateSigned")
    public void setDateSigned(String dateSigned) {
        this.dateSigned = dateSigned;
    }

    @JsonProperty("strWage")
    public String getStrWage() {
        return strWage;
    }

    @JsonProperty("strWage")
    public void setStrWage(String strWage) {
        this.strWage = strWage;
    }

    @JsonProperty("strBirthLocation")
    public String getStrBirthLocation() {
        return strBirthLocation;
    }

    @JsonProperty("strBirthLocation")
    public void setStrBirthLocation(String strBirthLocation) {
        this.strBirthLocation = strBirthLocation;
    }

    @JsonProperty("strDescriptionEN")
    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    @JsonProperty("strDescriptionEN")
    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    @JsonProperty("strGender")
    public String getStrGender() {
        return strGender;
    }

    @JsonProperty("strGender")
    public void setStrGender(String strGender) {
        this.strGender = strGender;
    }

    @JsonProperty("strSide")
    public String getStrSide() {
        return strSide;
    }

    @JsonProperty("strSide")
    public void setStrSide(String strSide) {
        this.strSide = strSide;
    }

    @JsonProperty("strPosition")
    public String getStrPosition() {
        return strPosition;
    }

    @JsonProperty("strPosition")
    public void setStrPosition(String strPosition) {
        this.strPosition = strPosition;
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

    @JsonProperty("strThumb")
    public String getStrThumb() {
        return strThumb;
    }

    @JsonProperty("strThumb")
    public void setStrThumb(String strThumb) {
        this.strThumb = strThumb;
    }
}
