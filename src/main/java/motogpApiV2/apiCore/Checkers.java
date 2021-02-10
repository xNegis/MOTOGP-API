package motogpApiV2.apiCore;

import java.time.LocalDate;

import exceptions.yearNotValidException;

public class Checkers {

	
	
	
	public static void checkIfYearIsInApi(Integer yearToCheck) throws yearNotValidException {
		if(yearToCheck>LocalDate.now().getYear() || yearToCheck<2010) {
			throw new yearNotValidException("Year '"+yearToCheck+"' is not able to be requested, please retry with a year contained between 2010 and " + LocalDate.now().getYear());
		}
	}
}

