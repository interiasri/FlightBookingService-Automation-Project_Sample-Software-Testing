package FlightBookingService.Libraries;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.AppBasicFunctions;

public class FlightbookingAppFunctions extends AppBasicFunctions {
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	public void login(String uid, String pwd) {
		driver.findElement(By.name("email")).sendKeys(uid);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	public void logout() {
		driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[3]/ul/li[2]/div/a/i")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	public void register(String name, String mobile, String email, String pwd, String gender, String dob) {
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("contact")).sendKeys(mobile);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(pwd);
		Select gndr = new Select(driver.findElement(By.name("gender")));
		gndr.selectByVisibleText(gender);
		driver.findElement(By.id("popupDatepicker")).sendKeys(dob);
		driver.findElement(By.id("flexCheckChecked")).click();
		driver.findElement(By.name("submit")).click();
		
	}
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	public boolean IsAlertMsgDisplayed() {
		try {
			driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]")).getText();
			System.out.println("Test Pass");
			return true;
			
		} catch (Exception e) {
			System.out.println("Test Fail");
			return false;
		}
	}
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	public void forgotPasswordFirst(String email, String contactNumber, String dob) {
		driver.findElement(By.linkText("I forgot my password")).click();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("contact_number")).sendKeys(contactNumber);
		driver.findElement(By.id("popupDatepicker")).sendKeys(dob);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	public void forgotPasswordSecond(String pwd) {
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	public void searchFlights(String date, String from, String to) {
		driver.findElement(By.id("search-date")).sendKeys(date);
		Select frm = new Select(driver.findElement(By.xpath("//select[contains(@class,'sf2')]")));
		frm.selectByVisibleText(from);
		Select fto = new Select(driver.findElement(By.xpath("//select[contains(@class,'sf3')]")));
		fto.selectByVisibleText(to);
		driver.findElement(By.xpath("//*[@id=\"contact-info\"]/div/div[2]/div/div[2]/div[1]/div/div/div[4]/button")).click();
	}
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	public boolean IsDashboardDisplayed() {
		try {
			String dash=driver.findElement(By.xpath("//*[@id=\"contact-info\"]/div/div[1]/h2")).getText();
			System.out.println(dash);
			if(dash.equalsIgnoreCase("User Dashboard")) {
				System.out.println("Login Successfull:  Test Pass");	
			}
			return true;
		} catch (Exception e) {
			System.out.println("Login Unsuccessfull: Test Fail");
			return false;
			
		}
	}
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	public void getListOfAirlinesDiplayed() {
		ArrayList<String> aname = new ArrayList<String>();
		List<WebElement> ftrows=driver.findElement(By.className("flights_table")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		for(int i=1; i<ftrows.size(); i++) {
			List<WebElement> ftcols=ftrows.get(i).findElements(By.tagName("td"));
			String arname = ftcols.get(0).getText();
			aname.add(arname);
		}
		System.out.println(aname);
	}
	
	public boolean IsAirlinesTableDisplayed(String aname) {
		try {
			List<WebElement> ftrows=driver.findElement(By.className("flights_table")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
			for(int j=1; j<ftrows.size(); j++) {
				List<WebElement> ftcols=ftrows.get(j).findElements(By.tagName("td"));
				String airlinename=ftcols.get(0).getText();
				WebElement selet=ftcols.get(8).findElement(By.tagName("button"));
				if(airlinename.equals(aname) && selet.isDisplayed()) {
					System.out.println("Airline Name Found in the list");
					break;
				}
				else {
					System.out.println("Airline Name Not Present in the list");
					break;
				}
			}
			return true;
		} catch (Exception e) {
			String noflight=driver.findElement(By.xpath("//*[@id=\"flights-results\"]/div/div/div[2]/p")).getText();
			System.out.println(noflight);
			return false;
		}
	}
	
	public static void selectFlight(String airline) {
		List<WebElement> ftrows=driver.findElement(By.className("flights_table")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		for(int k=1; k<ftrows.size(); k++) {
			List<WebElement> ftcols=ftrows.get(k).findElements(By.tagName("td"));
			String airlinename=ftcols.get(0).getText();
			WebElement selet=ftcols.get(8).findElement(By.tagName("button"));
			if(airlinename.equals(airline) && selet.isDisplayed()) {
				selet.click();
			}
			
		}	
	}
	
	
	
	
	
//	---------------------------------------------------------------Outdated------------------------------------------------------------------------------------	
//	public boolean IsAirlineNameDisplayed(String AirlineName) {
//		try {
//			List<WebElement> rows=driver.findElement(By.className("flights_table")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
//			for(int j=1; j<rows.size(); j++) {
//				List<WebElement> cols = rows.get(j).findElements(By.tagName("td"));
//				String found=cols.get(0).getText();
//				String slt=cols.get(8).getText();
//				if(found.equals(AirlineName) && slt.equalsIgnoreCase("Select")) {
//					System.out.println("Airline Name Found:"+found);
//					System.out.println("Test Pass");
//				}
//				
//			}
//			return true;
//			
//			
//		} catch (Exception e) {
//			String noflight=driver.findElement(By.xpath("//*[@id=\"flights-results\"]/div/div/div[2]/p")).getText();
//			System.out.println(noflight);
//			System.out.println("Airline Name Not Found");
//			return false;
//		}
//	}
	
	
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	public void selectAirline(String AirlineName) {
		List<WebElement> rows=driver.findElement(By.className("flights_table")).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		for(int j=1; j<rows.size(); j++) {
			List<WebElement> cols = rows.get(j).findElements(By.tagName("td"));
			String found=cols.get(0).getText();
			String slt=cols.get(8).getText();
			if(found.equals(AirlineName) && slt.equalsIgnoreCase("Select")) {
				System.out.println("Searching For "+found);
				cols.get(8).click();
				System.out.println("Test Pass");
				break;
			}
		}
		
	}
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	//Values of EnterCLass are (First Class) or (Business) or (Economy)
	public void fillPersonalInfo(String YourName, String numberofTickets, String SelectClass) throws InterruptedException{
		
		if(SelectClass.equalsIgnoreCase("First Class")) {
			driver.findElement(By.xpath("//input[@type='radio' and @value='First Class']")).click();
		}
		else if(SelectClass.equalsIgnoreCase("Business")) {
			driver.findElement(By.xpath("//input[@type='radio' and @value='Business']")).click();
		}
		else if(SelectClass.equalsIgnoreCase("Economy")) {
			driver.findElement(By.xpath("//input[@type='radio' and @value='Economy']")).click();
		}
		else {
			System.out.println("By Default Flight Travel Class is Economy Class if ignored by you");
			System.out.println("or");
			System.out.println("Test Failed if you are trying to select Other than Economy Class");
		}
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys(YourName);
		Thread.sleep(2000);
		driver.findElement(By.id("tickets")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("tickets")).sendKeys(numberofTickets);
	}
	
//---------------------------------------------------------------------------------------------------------------------------------------------------	
	
}




