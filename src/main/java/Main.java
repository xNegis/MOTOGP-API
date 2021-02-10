import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import exceptions.emptyResponseException;
import exceptions.raceCodeUnabaliableException;
import exceptions.sessionNotFoundException;
import exceptions.yearNotValidException;
import motogpApiV2.RaceCode;
import motogpApiV2.Session;
import motogpApiV2.GranPremioDetails.Venue;
import motogpApiV2.apiCore.APIGetters;
import motogpApiV2.apiCore.Category;
import motogpApiV2.results.Competitor;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException, sessionNotFoundException, yearNotValidException, raceCodeUnabaliableException, emptyResponseException {
//
//		List<Competitor> competitors =APIGetters.getCompetitorAndItsResultsByCategoryRaceCodeYearAndSession(2019, RaceCode.QAT, Category.MotoGP, Session.Qualifying);
//		
//		for(Competitor c:competitors) {
//			System.out.println(c.getName()+ " - " + c.getResult().getPosition() + "º");
//		}
//		
//		TimeUnit.SECONDS.sleep(1);

		List<Venue> detailedGps = APIGetters.getDetailsOfASeasonGPs(2013, Category.MotoGP);
		
		for(Venue v:detailedGps) {
			System.out.println(v.getName());
		}
	}
}
