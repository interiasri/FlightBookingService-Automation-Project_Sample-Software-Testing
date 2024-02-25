package FlightBookingService.TestCases;

import FlightBookingService.Libraries.FlightbookingAppFunctions;
import Utility.AppBasicFunctions;

public class CheckLogin_with_valid_data {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AppBasicFunctions.openApp("http://flights.qedgetech.com");
		FlightbookingAppFunctions log = new FlightbookingAppFunctions();
		log.login("sridhar_interia@outlook.com", "Sridhar@1234567");
		Thread.sleep(2000);
		log.IsDashboardDisplayed();
		log.logout();
		AppBasicFunctions.quitApp();
	}

}
