package FlightBookingService.TestCases;

import org.openqa.selenium.By;
import FlightBookingService.Libraries.FlightbookingAppFunctions;
import Utility.AppBasicFunctions;

public class CheckBookingFlightTickets {

	public static void main(String[] args) throws InterruptedException{
		AppBasicFunctions.openApp("http://flights.qedgetech.com");
		FlightbookingAppFunctions tkt = new FlightbookingAppFunctions();
		tkt.login("sridhar_interia@outlook.com", "Sridhar@1234567");
//		tkt.searchFlights("25/12/2025", "Hyderabad", "Kolkatha"); // Input Wrong Airline Name (Airline Name not present in the ist but instead you have other Airlines Available for that Route)
		tkt.searchFlights("25/12/2025", "Chennai", "Kolkatha");   // Input correct Airline Name ( Airline Name is present in the list for that Route)
//		tkt.searchFlights("20/02/2024", "Chennai", "Hyderabad");  // No Airlines Available for that route
		Thread.sleep(2000);
		try {
			tkt.selectAirline("Prasad Airlines");
			Thread.sleep(2000);
			tkt.fillPersonalInfo("Sridhar", "2", "Business");
			AppBasicFunctions.driver.findElement(By.xpath("//button[contains(@class,'btn-order')]")).click();
			
		} catch (Exception e) {
			tkt.IsAirlinesTableDisplayed("Prasad Airlines");
		}
		
//		if(tkt.IsAirlinesTableDisplayed("Prasad Airlines")) {
//			tkt.selectAirline("Prasad Airlines");
//			Thread.sleep(2000);
//			tkt.fillPersonalInfo("Sridhar", "2","First Class");
//			AppBasicFunctions.driver.findElement(By.xpath("//button[contains(@class,'btn-order')]")).click();
//		}
//		else {
//			tkt.IsAirlinesTableDisplayed("Prasad Airlines");
//		}
		tkt.logout();
		AppBasicFunctions.closeApp();
	}
}
