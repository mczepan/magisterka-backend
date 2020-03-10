
package pl.mczepan.mgrapp.model.basketball.team;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "isNBAFranchise",
    "fullName",
    "tricode"
})
public class Standard {

    @JsonProperty("isNBAFranchise")
    private Boolean isNBAFranchise;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("tricode")
    private String tricode;
    private String logoPath;

    @JsonProperty("isNBAFranchise")
    public Boolean getIsNBAFranchise() {
        return isNBAFranchise;
    }

    @JsonProperty("isNBAFranchise")
    public void setIsNBAFranchise(Boolean isNBAFranchise) {
        this.isNBAFranchise = isNBAFranchise;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonProperty("tricode")
    public String getTricode() {
        return tricode;
    }

    @JsonProperty("tricode")
    public void setTricode(String tricode) {
        this.tricode = tricode;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }
}
