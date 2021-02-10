package motogpApiV2.apiCore;

import java.io.IOException;
import java.util.List;

import motogpApiV2.results.Competitor;
import motogpApiV2.results.Results;

public class CompetitorResultsFinder {
	

	private static final String rootUrl = "https://api.sportradar.us/motogp/trial/v2/en/sport_events/";
	
	private static final String urlToObtainResults = "/summary.json?api_key=";
	
	public static List<Competitor> getResultsByScheduleId(String scheduleIdToGetResults)
			throws IOException, InterruptedException {
		
		String urlToGetRequestApi = rootUrl + scheduleIdToGetResults + urlToObtainResults + APIGetters.getAPIKey();
		Results results = RequestToEntityFormatter.getEntityFromAnApiCall(Results.class, urlToGetRequestApi);

		return results.getStage().getCompetitors();
	}

}
