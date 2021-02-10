
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
//
//    public Venue() {
//		super();
//		this.id =  "N/A";
//		this.name = "N/A";
//		this.city =  "N/A";
//		this.country =  "N/A";
//		this.countryCode =  "N/A";
//		this.urlOfficial =  "N/A";
//		this.curvesLeft = 0;
//		this.curvesRight = 0;
//		this.debut = 0;
//		this.length = 0;
//		this.additionalProperties = null;
//	}

    
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
    	if(this.name==null) {
    		this.name="N/A";
    		return name;
    	}else {
            return name;
    	}
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("city")
    public String getCity() {
    	if(this.city==null) {
    		this.city="N/A";
    		return city;
    	}else {
            return city;
    	}    
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("country")
    public String getCountry() {
    	if(this.country==null) {
    		this.country="N/A";
    		return country;
    	}else {
            return country;
    	}
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
    	if(this.countryCode==null) {
    		this.countryCode="N/A";
    		return countryCode;
    	}else {
            return countryCode;
    	}
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("url_official")
    public String getUrlOfficial() {
    	if(this.urlOfficial==null) {
    		this.urlOfficial="N/A";
    		return urlOfficial;
    	}else {
            return urlOfficial;
    	}
    }

    @JsonProperty("url_official")
    public void setUrlOfficial(String urlOfficial) {
        this.urlOfficial = urlOfficial;
    }

    @JsonProperty("curves_left")
    public Integer getCurvesLeft() {
    	if(this.curvesLeft==null) {
    		this.curvesLeft=0;
    		return curvesLeft;
    	}else {
            return curvesLeft;
    	}
    }

    @JsonProperty("curves_left")
    public void setCurvesLeft(Integer curvesLeft) {
        this.curvesLeft = curvesLeft;
    }

    @JsonProperty("curves_right")
    public Integer getCurvesRight() {
    	if(this.curvesRight==null) {
    		this.curvesRight=0;
    		return curvesRight;
    	}else {
            return curvesRight;
    	}
    }

    @JsonProperty("curves_right")
    public void setCurvesRight(Integer curvesRight) {
        this.curvesRight = curvesRight;
    }

    @JsonProperty("debut")
    public Integer getDebut() {
    	if(this.debut==null) {
    		this.debut=0;
    		return debut;
    	}else {
            return debut;
    	}
    }

    @JsonProperty("debut")
    public void setDebut(Integer debut) {
        this.debut = debut;
    }

    @JsonProperty("length")
    public Integer getLength() {
    	if(this.length==null) {
    		this.length=0;
    		return length;
    	}else {
            return length;
    	}
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
