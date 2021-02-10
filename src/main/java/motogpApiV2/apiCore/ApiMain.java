package motogpApiV2.apiCore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import exceptions.sessionNotFoundException;
import motogpApiV2.RaceCode;
import motogpApiV2.GranPremioDetails.Venue;
import motogpApiV2.races.Races;
import motogpApiV2.races.Schedule;
import motogpApiV2.results.Competitor;

public class ApiMain {

	public static void main(String[] args) throws IOException, InterruptedException, sessionNotFoundException {

		List<Competitor> competitors =getCompetitorAndItsResultsByCategoryRaceCodeYearAndSession(2019, RaceCode.QAT, Category.Moto2, Session.Race);
		
		for(Competitor c:competitors) {
			System.out.println(c.getName()+ " - " + c.getResult().getPosition() + "º");
		}
		TimeUnit.SECONDS.sleep(1);

		System.out.println("---");
		
		List<Venue> listaDetalles = getDetailsOfASeasonGPs(2019, Category.MotoGP);
		for(Venue v: listaDetalles) {
			System.out.println(v.getName());
		}
	}



	public static List<Competitor> getCompetitorAndItsResultsByCategoryRaceCodeYearAndSession(Integer yearToRequest,
			RaceCode raceCodeToRequest, Category categoryToRequest,Session session)
			throws  IOException, InterruptedException, sessionNotFoundException {

		
		String idOfScheduleWanted = SeasonFinder.getSeasonByCategoryAndYear(yearToRequest,categoryToRequest);

		Schedule schedules = SchedulesFinder.getSchedules(idOfScheduleWanted);
		
		String idOfResultsWanted = SchedulesFinder.getScheduleByRaceCodeAndYear(schedules, yearToRequest, raceCodeToRequest, session);
		
		List<Competitor> competitorsFound = CompetitorResultsFinder.getResultsByScheduleId(idOfResultsWanted);
		
		if(competitorsFound.size()==0 || competitorsFound==null) {
			throw new FileNotFoundException();
		}
		return competitorsFound;
	}


	public static List<Venue> getDetailsOfASeasonGPs(Integer yearOfSeason, Category categoryOfTheSeason) throws IOException, InterruptedException {
	
		String idOfScheduleWanted = SeasonFinder.getSeasonByCategoryAndYear(yearOfSeason,categoryOfTheSeason);
		Schedule schedule = SchedulesFinder.getSchedules(idOfScheduleWanted);
		
		Integer numOfGranPremiosScheduled = schedule.getRacesNum();
		
		List<Venue> detailsOfAllGPsScheduled = new ArrayList<Venue>();
		for(int i=0;i<numOfGranPremiosScheduled;i++) {
			
			Races race_i = schedule.getListOfRacesScheduled().get(i);
			
			Venue venue = GranPremioFinder.obtainDetailsFromGp(race_i.getId());
			detailsOfAllGPsScheduled.add(venue);
		}
		
		return detailsOfAllGPsScheduled;
	}

	
	
}
