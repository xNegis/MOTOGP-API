package motogpApiV2.apiCore;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import exceptions.raceCodeUnabaliableException;
import exceptions.sessionNotFoundException;
import motogpApiV2.RaceCode;
import motogpApiV2.races.Races;
import motogpApiV2.races.Schedule;
import motogpApiV2.Session;

public class SchedulesFinder {

	private static final String rootUrl = "https://api.sportradar.us/motogp/trial/v2/en/sport_events/";
	
	private static final String urlToObtainSchedules = "/schedule.json?api_key=";
	
	public static Schedule getSeasonSchedule(String seasonIdToRequestItsSchedule ) throws JsonMappingException, JsonProcessingException, IOException {
		String urlToGetRequestApi = rootUrl + seasonIdToRequestItsSchedule + urlToObtainSchedules + APIGetters.getAPIKey();

		Schedule schedules = RequestToEntityFormatter.getEntityFromAnApiCall(Schedule.class, urlToGetRequestApi);

		return schedules;
	}
	
	public static String getScheduleByRaceCodeAndYear(Schedule schedulesToIterate,Integer yearToGetSchedule, RaceCode raceCodeToGetSchedule,
			Session sessionToGetSchedule)
			throws IOException, InterruptedException, sessionNotFoundException, raceCodeUnabaliableException {

		String raceCodeParseado = Checkers.raceCodeToStringFormatter(raceCodeToGetSchedule);
		String parsedSession = Checkers.sessionToStringFormatter(sessionToGetSchedule);
		String idToFind = "";


		Integer numeroDeGrandesPremios = schedulesToIterate.getListOfRacesScheduled().size();
		for (int i = 0; i < numeroDeGrandesPremios; i++) {

			Races stage_i = schedulesToIterate.getListOfRacesScheduled().get(i);

			if (stage_i.getDescription().equals(raceCodeParseado + " " + yearToGetSchedule.toString())) {
				
				Integer numeroDePracticas = stage_i.getNumeroPracticas();
				
				for (int j = 0; j < numeroDePracticas; j++) {
					
					if (stage_i.getListaPracticas().get(j).getDescription().equals(parsedSession)) {
						
						idToFind += stage_i.getListaPracticas().get(j).getId();
					}
				}
				break;
			}
		}

		return idToFind;
	}
	
	
}
