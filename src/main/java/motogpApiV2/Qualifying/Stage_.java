
package motogpApiV2.Qualifying;

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
    "id",
    "description",
    "scheduled",
    "scheduled_end",
    "type",
    "single_event"
})
public class Stage_ {

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
    @JsonProperty("single_event")
    private Boolean singleEvent;
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

    @JsonProperty("single_event")
    public Boolean getSingleEvent() {
        return singleEvent;
    }

    @JsonProperty("single_event")
    public void setSingleEvent(Boolean singleEvent) {
        this.singleEvent = singleEvent;
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
