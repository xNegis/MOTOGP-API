
package motogpApiV2.results;

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
    "points",
    "fastest_lap_time",
    "laps",
    "position",
    "grid",
    "status",
    "gap"
})
public class Result {

    @JsonProperty("points")
    private Integer points;
    @JsonProperty("fastest_lap_time")
    private String fastestLapTime;
    @JsonProperty("laps")
    private Integer laps;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("grid")
    private Integer grid;
    @JsonProperty("status")
    private String status;
    @JsonProperty("gap")
    private String gap;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("points")
    public Integer getPoints() {
        return points;
    }

    @JsonProperty("points")
    public void setPoints(Integer points) {
        this.points = points;
    }

    @JsonProperty("fastest_lap_time")
    public String getFastestLapTime() {
        return fastestLapTime;
    }

    @JsonProperty("fastest_lap_time")
    public void setFastestLapTime(String fastestLapTime) {
        this.fastestLapTime = fastestLapTime;
    }

    @JsonProperty("laps")
    public Integer getLaps() {
        return laps;
    }

    @JsonProperty("laps")
    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    @JsonProperty("position")
    public Integer getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Integer position) {
        this.position = position;
    }

    @JsonProperty("grid")
    public Integer getGrid() {
        return grid;
    }

    @JsonProperty("grid")
    public void setGrid(Integer grid) {
        this.grid = grid;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("gap")
    public String getGap() {
        return gap;
    }

    @JsonProperty("gap")
    public void setGap(String gap) {
        this.gap = gap;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
