
package pl.mczepan.mgrapp.model.league.table;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "table"
})
public class TableLeagueList {

    @JsonProperty("table")
    private List<Table> table = null;

    @JsonProperty("table")
    public List<Table> getTable() {
        return table;
    }

    @JsonProperty("table")
    public void setTable(List<Table> table) {
        this.table = table;
    }

}
