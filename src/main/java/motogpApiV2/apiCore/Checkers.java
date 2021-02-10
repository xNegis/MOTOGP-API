package motogpApiV2.apiCore;

import java.time.LocalDate;
import java.util.List;

import exceptions.emptyResponseException;
import exceptions.raceCodeUnabaliableException;
import exceptions.sessionNotFoundException;
import exceptions.yearNotValidException;
import motogpApiV2.RaceCode;
import motogpApiV2.Session;
import motogpApiV2.GranPremioDetails.GranPremioDetails;
import motogpApiV2.GranPremioDetails.Venue;
import motogpApiV2.results.Competitor;

public class Checkers {

	
	public static void checkIfCompetitorsHaveBeenFound(List<Competitor> competitorsFound) throws emptyResponseException {
		if(competitorsFound==null || competitorsFound.size()==0) {
			throw new emptyResponseException("API returned an empty json of competitors, so there are no results for params requested. Please retry with different params");
		}
	}
	
	public static void checkIfGranPremiosHaveBeenFound(List<Venue> granPremiosFound) throws emptyResponseException {
		if(granPremiosFound==null || granPremiosFound.size()==0) {
			throw new emptyResponseException("API returned an empty json of gran premios, so there are no results for params requested. Please retry with different params");
		}
	}
	
	public static <T> List<T> checkIfThereIsNullableContentAndDeleteNullables(List<T> objectList) throws emptyResponseException {
	
		Integer objectsListSize = objectList.size();
		for(int i=0;i<objectsListSize;i++) {
			if(objectList.get(i)==null) {
				objectList.remove(i);
				objectsListSize=objectsListSize-1;
			}
		}
		return objectList;
	}

		
	
	
	
	
	public static void checkIfYearIsInApi(Integer yearToCheck) throws yearNotValidException {
		if(yearToCheck>LocalDate.now().getYear() || yearToCheck<2012) {
			throw new yearNotValidException("Year '"+yearToCheck+"' is not able to be requested, please retry with a year contained between 2012 and " + LocalDate.now().getYear());
		}
	}
	
	public static String raceCodeToStringFormatter(RaceCode raceCode) throws raceCodeUnabaliableException {
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
			throw new raceCodeUnabaliableException("RaceCode '"+raceCode+"' is not avaliable for the year requested");
		}
	}
		
	public static String sessionToStringFormatter(Session s) throws sessionNotFoundException {
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

