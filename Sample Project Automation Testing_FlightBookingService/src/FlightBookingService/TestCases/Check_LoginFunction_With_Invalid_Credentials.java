package FlightBookingService.TestCases;

import FlightBookingService.Libraries.FlightbookingAppFunctions;
import Utility.AppBasicFunctions;

public class Check_LoginFunction_With_Invalid_Credentials {

	public static void main(String[] args) {
		AppBasicFunctions.openApp("http://flights.qedgetech.com");
		FlightbookingAppFunctions fun = new FlightbookingAppFunctions();
		fun.login("Sri@gmail.com", "Srid123432");
		fun.IsAlertMsgDisplayed();
		AppBasicFunctions.closeApp();
	}

}
