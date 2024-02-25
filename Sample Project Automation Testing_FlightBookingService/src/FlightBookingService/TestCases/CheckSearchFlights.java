package FlightBookingService.TestCases;

import FlightBookingService.Libraries.FlightbookingAppFunctions;
import Utility.AppBasicFunctions;

public class CheckSearchFlights {

	public static void main(String[] args) throws InterruptedException {
		AppBasicFunctions.openApp("http://flights.qedgetech.com");
		FlightbookingAppFunctions log = new FlightbookingAppFunctions();
		log.login("sridhar_interia@outlook.com", "Sridhar@1234567");
		log.searchFlights("02/25/2024", "Hyderabad", "Kolkatha");
//		log.searchFlights("02/25/2024", "Hyderabad", "Chennai");
		Thread.sleep(2000);
		try {
			log.selectAirline("King Fisher Airlines");
		} catch (Exception e) {
			log.IsAirlinesTableDisplayed("King Fisher Airlines");
		}
	}
}
