package motogpApiV2.apiCore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import exceptions.emptyResponseException;
import exceptions.raceCodeUnabaliableException;
import exceptions.sessionNotFoundException;
import exceptions.yearNotValidException;
import motogpApiV2.RaceCode;
import motogpApiV2.Session;
import motogpApiV2.GranPremioDetails.Venue;
import motogpApiV2.races.Races;
import motogpApiV2.races.Schedule;
import motogpApiV2.results.Competitor;

public class APIGetters {
	private static String API_KEY="zzea8d8qessqzttp987a6h5c";//Your APIKEY HERE

	public static List<Competitor> getCompetitorAndItsResultsByCategoryRaceCodeYearAndSession(Integer yearToRequest,
			RaceCode raceCodeToRequest, Category categoryToRequest,Session session)
			throws  IOException, InterruptedException, sessionNotFoundException, yearNotValidException, raceCodeUnabaliableException, emptyResponseException {

		
		String idOfScheduleWanted = SeasonFinder.getSeasonByCategoryAndYear(yearToRequest,categoryToRequest);
		
		TimeUnit.SECONDS.sleep(1);
		
		Schedule schedules = SchedulesFinder.getSeasonSchedule(idOfScheduleWanted);
		
		TimeUnit.SECONDS.sleep(1);
		
		String idOfResultsWanted = SchedulesFinder.getScheduleByRaceCodeAndYear(schedules, yearToRequest, raceCodeToRequest, session);
		
		List<Competitor> competitorsFound = CompetitorResultsFinder.getResultsByScheduleId(idOfResultsWanted);
		
		Checkers.checkIfCompetitorsHaveBeenFound(competitorsFound);
		competitorsFound = Checkers.checkIfThereIsNullableContentAndDeleteNullables(competitorsFound);
		return competitorsFound;
	}


	public static List<Venue> getDetailsOfASeasonGPs(Integer yearOfSeason, Category categoryOfTheSeason) throws IOException, InterruptedException, yearNotValidException, emptyResponseException {
	
		String idOfScheduleWanted = SeasonFinder.getSeasonByCategoryAndYear(yearOfSeason,categoryOfTheSeason);
		TimeUnit.SECONDS.sleep(1);

		Schedule schedule = SchedulesFinder.getSeasonSchedule(idOfScheduleWanted);
		
		Integer numOfGranPremiosScheduled = schedule.getRacesNum();
		
		List<Venue> detailsOfAllGPsScheduled = new ArrayList<Venue>();
		for(int i=0;i<numOfGranPremiosScheduled;i++) {
			
			Races race_i = schedule.getListOfRacesScheduled().get(i);
			
			Venue venue = GranPremioFinder.obtainDetailsFromGp(race_i.getId());
			detailsOfAllGPsScheduled.add(venue);
		}
		
		Checkers.checkIfGranPremiosHaveBeenFound(detailsOfAllGPsScheduled);
		
		detailsOfAllGPsScheduled = Checkers.checkIfThereIsNullableContentAndDeleteNullables(detailsOfAllGPsScheduled);
		
		return detailsOfAllGPsScheduled;
	}

	public static String getAPIKey() {
		return API_KEY;
	}
	
}
