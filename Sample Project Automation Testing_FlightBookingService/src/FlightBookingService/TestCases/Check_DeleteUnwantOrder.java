package FlightBookingService.TestCases;

import org.openqa.selenium.By;
import FlightBookingService.Libraries.FlightbookingAppFunctions;
import Utility.AppBasicFunctions;

public class Check_DeleteUnwantOrder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		AppBasicFunctions.openApp("http://flights.qedgetech.com");
		FlightbookingAppFunctions view = new FlightbookingAppFunctions();
		view.login("sridhar_interia@outlook.com", "Sridhar@1234567");
		Thread.sleep(5000);
		AppBasicFunctions.driver.findElement(By.linkText("Flight Bookings")).click();	
		view.logout();
		AppBasicFunctions.closeApp();
	} 	

}
