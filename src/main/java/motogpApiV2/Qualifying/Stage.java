
package motogpApiV2.Qualifying;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "description",
    "scheduled",
    "scheduled_end",
    "type",
    "status",
    "single_event",
    "parents",
    "stages",
    "competitors",
    "teams",
    "constructors"
})
public class Stage {

    @JsonProperty("id")
    private String id;
    @JsonProperty("description")
    private String description;
    @JsonProperty("scheduled")
    private String scheduled;
    @JsonProperty("scheduled_end")
    private String scheduledEnd;
    @JsonProperty("type")
    private String type;
    @JsonProperty("status")
    private String status;
    @JsonProperty("single_event")
    private Boolean singleEvent;
    @JsonProperty("parents")
    private List<Object> parents = null;
    @JsonProperty("stages")
    private List<Stage_> stages = null;
    @JsonProperty("competitors")
    private List<Competitor> competitors = null;
    @JsonProperty("teams")
    private List<Team> teams = null;
    @JsonProperty("constructors")
    private List<Constructor> constructors = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("scheduled")
    public String getScheduled() {
        return scheduled;
    }

    @JsonProperty("scheduled")
    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    @JsonProperty("scheduled_end")
    public String getScheduledEnd() {
        return scheduledEnd;
    }

    @JsonProperty("scheduled_end")
    public void setScheduledEnd(String scheduledEnd) {
        this.scheduledEnd = scheduledEnd;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("single_event")
    public Boolean getSingleEvent() {
        return singleEvent;
    }

    @JsonProperty("single_event")
    public void setSingleEvent(Boolean singleEvent) {
        this.singleEvent = singleEvent;
    }

    @JsonProperty("parents")
    public List<Object> getParents() {
        return parents;
    }

    @JsonProperty("parents")
    public void setParents(List<Object> parents) {
        this.parents = parents;
    }

    @JsonProperty("stages")
    public List<Stage_> getStages() {
        return stages;
    }

    @JsonProperty("stages")
    public void setStages(List<Stage_> stages) {
        this.stages = stages;
    }

    @JsonProperty("competitors")
    public List<Competitor> getCompetitors() {
        return competitors;
    }

    @JsonProperty("competitors")
    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }

    @JsonProperty("teams")
    public List<Team> getTeams() {
        return teams;
    }

    @JsonProperty("teams")
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    @JsonProperty("constructors")
    public List<Constructor> getConstructors() {
        return constructors;
    }

    @JsonProperty("constructors")
    public void setConstructors(List<Constructor> constructors) {
        this.constructors = constructors;
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
