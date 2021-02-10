package motogpApiV2.apiCore;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import motogpApiV2.GranPremioDetails.GranPremioDetails;
import motogpApiV2.GranPremioDetails.Venue;

public class GranPremioFinder {


	private static final String rootUrl = "https://api.sportradar.us/motogp/trial/v2/en/sport_events/";
	
	private static final String urlToObtainResults = "/summary.json?api_key=";
	
	public static Venue obtainDetailsFromGp(String idOfGPsToGetDetails) throws JsonMappingException, JsonProcessingException, IOException, InterruptedException {
		TimeUnit.SECONDS.sleep(1);

			String uri =rootUrl+idOfGPsToGetDetails+urlToObtainResults+APIGetters.getAPIKey();
			GranPremioDetails detailsOfGP_i =RequestToEntityFormatter.getEntityFromAnApiCall(GranPremioDetails.class, uri);
			
			return detailsOfGP_i.getStage().getVenue();
		
	}	
}
