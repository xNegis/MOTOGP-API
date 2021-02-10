
package motogpApiV2.stage;

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
    "generated_at",
    "schema",
    "stages"
})
public class Stage {

    @JsonProperty("generated_at")
    private String generatedAt;
    @JsonProperty("schema")
    private String schema;
    @JsonProperty("stages")
    private List<Season> stages = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("generated_at")
    public String getGeneratedAt() {
        return generatedAt;
    }

    @JsonProperty("generated_at")
    public void setGeneratedAt(String generatedAt) {
        this.generatedAt = generatedAt;
    }

    @JsonProperty("schema")
    public String getSchema() {
        return schema;
    }

    @JsonProperty("schema")
    public void setSchema(String schema) {
        this.schema = schema;
    }

    @JsonProperty("stages")
    public List<Season> getStages() {
        return stages;
    }

    @JsonProperty("stages")
    public void setStages(List<Season> stages) {
        this.stages = stages;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    
    public Integer getNumOfSeasons() {
    	return this.stages.size();
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
