package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppBasicFunctions {
	
	public static WebDriver driver;		// Creating static, global and package level accessing variable		
//	A function for Navigate to Required Web Application/Website/Webpage
	public static void openApp(String url) {		// passing String value while calling this function or method
		 driver = new ChromeDriver();				// crating new object for Webdriver Interface
		 driver.manage().deleteAllCookies();		// Deleting all cookies from webpage after opening webpage
		 driver.manage().window().maximize();		// Maximizing the webPage 
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	// Waiting upto 20 seconds while loading the webpage
		 driver.get(url);
		 
	}
//	A function decide whether We are at specific Website/WebPage/WebApp
	
	public static void closeApp() {
		driver.close();
	}
	
	public static void quitApp() {
		driver.quit();
	}
}
