package motogpApiV2.apiCore;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import exceptions.sessionNotFoundException;
import motogpApiV2.RaceCode;
import motogpApiV2.races.Races;
import motogpApiV2.races.Schedule;
import motogpApiV2.Session;

public class SchedulesFinder {
	private static String API_KEY="zzea8d8qessqzttp987a6h5c";

	private static final String rootUrl = "https://api.sportradar.us/motogp/trial/v2/en/sport_events/";
	
	private static final String urlToObtainSchedules = "/schedule.json?api_key=";
	public static Schedule getSchedules(String seasonIdToRequestItsSchedule ) throws JsonMappingException, JsonProcessingException, IOException, InterruptedException {
		String urlToGetRequestApi = rootUrl + seasonIdToRequestItsSchedule + urlToObtainSchedules + API_KEY;
		TimeUnit.SECONDS.sleep(1);

		Schedule schedules = RequestToEntityFormatter.getEntityFromAnApiCall(Schedule.class, urlToGetRequestApi);

		return schedules;
	}
	
	public static String getScheduleByRaceCodeAndYear(Schedule schedulesToIterate,Integer yearToGetSchedule, RaceCode raceCodeToGetSchedule,
			Session sessionToGetSchedule)
			throws IOException, InterruptedException, sessionNotFoundException {
		TimeUnit.SECONDS.sleep(1);

		String raceCodeParseado = raceCodeToStringParser(raceCodeToGetSchedule);
		String parsedSession = sessionToStringParser(sessionToGetSchedule);
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
	
	public static String raceCodeToStringParser(RaceCode raceCode) {
		switch (raceCode) {
		case QAT:
			return "Grand Prix of Qatar";
		case ARG:
			return "Gran Premio de la Republica Argentina";
		case AME:
			return "Grand Prix of The Americas";
		case ESP:
			return "Gran Premio de Espana";
		case FRA:
			return "Grand Prix de France";
		case ITA:
			return "Gran Premio d'Italia";
		case CAT:
			return "Circuit de Barcelona-Catalunya";
		case NLD:
			return "TT Assen";
		case DEU:
			return "Motorrad Grand Prix Deutschland";
		case CZE:
			return "Grand Prix Ceske Republiky";
		case AUT:
			return "Motorrad Grand Prix von Österreich";
		case ENG:
			return "British Grand Prix";
		case SMR:
			return "Gran Premio di San Marino e della Riviera di Rimini";
		case ARA:
			return "Gran Premio de Aragon";
		case USA:
			return "Grand Prix of The Americas";
		case THA:
			return "Thailand Grand Prix";
		case JPN:
			return "Grand Prix of Japan";		
		case AUS:
			return "Australian Grand Prix";
		default:
			return "";
		}
	}
	
	
	public static String sessionToStringParser(Session s) throws sessionNotFoundException {
		switch (s) {
		case Practice_1:
			return "Practice 1";
		case Practice_2:
			return "Practice 2";
		case Practice_3:
			return "Practice 3";
		case Practice_4:
			return "Practice 4";
		case Qualifying:
			return "Qualifying";
		case Race:
			return "Race";
		default:
			throw new sessionNotFoundException("Session '" + s +"' was impossible to find in schedules, please retry with another session");
		}
	}
}
