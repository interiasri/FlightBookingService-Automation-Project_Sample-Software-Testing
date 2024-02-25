package FlightBookingService.TestCases;

import org.openqa.selenium.By;

import FlightBookingService.Libraries.FlightbookingAppFunctions;
import Utility.AppBasicFunctions;

public class CheckForgotPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppBasicFunctions.openApp("http://flights.qedgetech.com");
		FlightbookingAppFunctions setPassword = new FlightbookingAppFunctions();
		setPassword.forgotPasswordFirst("sridhar_interia@outlook.com", "8217067298", "10-12-1988");
		setPassword.forgotPasswordSecond("Sridhar@1234567");
		String resetPwdSuccess=AppBasicFunctions.driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/h4")).getText();
		System.out.println("Login Successful message displayed Below");
		System.out.println(resetPwdSuccess);
		AppBasicFunctions.closeApp();
	}
}
