
package pl.mczepan.mgrapp.model.user.FavouriteTeam;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "strNationality",
    "strPlayer",
    "strNumber",
    "strPosition",
    "strThumb"
})
public class Player {

    @JsonProperty("strNationality")
    private String strNationality;
    @JsonProperty("strPlayer")
    private String strPlayer;
    @JsonProperty("strNumber")
    private String strNumber;
    @JsonProperty("strPosition")
    private String strPosition;
    @JsonProperty("strThumb")
    private String strThumb;

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

    @JsonProperty("strNumber")
    public String getStrNumber() {
        return strNumber;
    }

    @JsonProperty("strNumber")
    public void setStrNumber(String strNumber) {
        this.strNumber = strNumber;
    }

    @JsonProperty("strPosition")
    public String getStrPosition() {
        return strPosition;
    }

    @JsonProperty("strPosition")
    public void setStrPosition(String strPosition) {
        this.strPosition = strPosition;
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
