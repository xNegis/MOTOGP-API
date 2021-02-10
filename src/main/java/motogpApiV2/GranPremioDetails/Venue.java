
package motogpApiV2.GranPremioDetails;

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
    "name",
    "city",
    "country",
    "country_code",
    "url_official",
    "curves_left",
    "curves_right",
    "debut",
    "length"
})
public class Venue {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("city")
    private String city;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("url_official")
    private String urlOfficial;
    @JsonProperty("curves_left")
    private Integer curvesLeft;
    @JsonProperty("curves_right")
    private Integer curvesRight;
    @JsonProperty("debut")
    private Integer debut;
    @JsonProperty("length")
    private Integer length;
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("url_official")
    public String getUrlOfficial() {
        return urlOfficial;
    }

    @JsonProperty("url_official")
    public void setUrlOfficial(String urlOfficial) {
        this.urlOfficial = urlOfficial;
    }

    @JsonProperty("curves_left")
    public Integer getCurvesLeft() {
        return curvesLeft;
    }

    @JsonProperty("curves_left")
    public void setCurvesLeft(Integer curvesLeft) {
        this.curvesLeft = curvesLeft;
    }

    @JsonProperty("curves_right")
    public Integer getCurvesRight() {
        return curvesRight;
    }

    @JsonProperty("curves_right")
    public void setCurvesRight(Integer curvesRight) {
        this.curvesRight = curvesRight;
    }

    @JsonProperty("debut")
    public Integer getDebut() {
        return debut;
    }

    @JsonProperty("debut")
    public void setDebut(Integer debut) {
        this.debut = debut;
    }

    @JsonProperty("length")
    public Integer getLength() {
        return length;
    }

    @JsonProperty("length")
    public void setLength(Integer length) {
        this.length = length;
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
