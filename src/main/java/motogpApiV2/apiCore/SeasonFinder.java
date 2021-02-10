package motogpApiV2.apiCore;

import java.io.IOException;

import motogpApiV2.stage.Season;
import motogpApiV2.stage.Stage;

public class SeasonFinder {

	private static String API_KEY="zzea8d8qessqzttp987a6h5c";

	
	private static final String urlToObtainSeasons = "https://api.sportradar.us/motogp/trial/v2/en/seasons.json?api_key=";
	
	public static String getSeasonByCategoryAndYear(Integer yearToRequest, Category categoryToRequest)
			throws IOException {
		String idToFind = "";

		String urlToGetRequestApi = urlToObtainSeasons + API_KEY;
		
		Stage allSeasons = RequestToEntityFormatter.getEntityFromAnApiCall(Stage.class, urlToGetRequestApi);

	
		for (int i = 0; i < allSeasons.getNumOfSeasons(); i++) {

			Season season_i = allSeasons.getStages().get(i);

			if (season_i.getDescription().split(" ")[0].equals(categoryToRequest.toString())
					&& season_i.getDescription().split(" ")[1].equals(yearToRequest.toString())) {
				idToFind += season_i.getId();
				break;
			}
		}

		return idToFind;
	}

}
