
package pl.mczepan.mgrapp.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idSport",
        "strSport",
        "strFormat",
        "strSportThumb",
        "strSportDescription"
})
public class Sport {

    @JsonProperty("idSport")
    private String idSport;
    @JsonProperty("strSport")
    private String strSport;
    @JsonProperty("strFormat")
    private String strFormat;
    @JsonProperty("strSportThumb")
    private String strSportThumb;
    @JsonProperty("strSportDescription")
    private String strSportDescription;


    @JsonProperty("idSport")
    public String getIdSport() {
        return idSport;
    }

    @JsonProperty("idSport")
    public void setIdSport(String idSport) {
        this.idSport = idSport;
    }

    @JsonProperty("strSport")
    public String getStrSport() {
        return strSport;
    }

    @JsonProperty("strSport")
    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    @JsonProperty("strFormat")
    public String getStrFormat() {
        return strFormat;
    }

    @JsonProperty("strFormat")
    public void setStrFormat(String strFormat) {
        this.strFormat = strFormat;
    }

    @JsonProperty("strSportThumb")
    public String getStrSportThumb() {
        return strSportThumb;
    }

    @JsonProperty("strSportThumb")
    public void setStrSportThumb(String strSportThumb) {
        this.strSportThumb = strSportThumb;
    }

    @JsonProperty("strSportDescription")
    public String getStrSportDescription() {
        return strSportDescription;
    }

    @JsonProperty("strSportDescription")
    public void setStrSportDescription(String strSportDescription) {
        this.strSportDescription = strSportDescription;
    }
}
