package FlightBookingService.TestCases;

import FlightBookingService.Libraries.FlightbookingAppFunctions;
import Utility.AppBasicFunctions;

public class CheckUser_can_able_to_Register {

	public static void main(String[] args) {
		AppBasicFunctions.openApp("http://flights.qedgetech.com");
		FlightbookingAppFunctions appFunction = new FlightbookingAppFunctions();
		appFunction.register("Sridhar Parutabad", "8217067299", "sridharparutabad@gmail.com", "Dsop@123", "Male", "10-12-1988");
		
	}

}
