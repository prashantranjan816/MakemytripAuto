package Assignment.PlateIQ;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import library.Utility;

public class SearchRequest extends HomePage {
	final static By fromcity 				= By.xpath("//input[@id='fromCity']");
	final static By tocity 					= By.xpath("(//*[@class='fsw_inputField font30 latoBlack'])[1]");
	final static By departure 				= By.xpath("//div[@class='fsw_inputBox dates inactiveWidget ']");
	final static By returnback 				= By.xpath("//div[@class='fsw_inputBox dates reDates inactiveWidget  shiftModal']");
	final static By returnback1 			= By.xpath("//div[@class='fsw_inputBox dates reDates inactiveWidget ']");
	final static By travellers 				= By.xpath("//div[@class='fsw_inputBox flightTravllers inactiveWidget ']");
	final static By travellers_children 	= By.xpath("(//ul[@class='guestCounter font12 darkText']/li[@class=''])[9]");
	final static By travellers_class 		= By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/li");
	final static By apply 					= By.xpath("//button[@class='primaryBtn btnApply pushRight ']");
	final static By search 					= By.xpath("//a[@class='primaryBtn font24 latoBlack widgetSearchBtn ']");
	final static By departure_flight 		= By.xpath("//span[@class='splitVw-outer append_right9']");
	final static By return_flight 			= By.xpath("(//span[@class='splitVw-outer append_right9'])[20]");
	final static By bookNow 				= By.xpath("//button[@class='btn fli_primary_btn text-uppercase']");
	
	
	static String currentdate;
	String NAME;
	
	@Test(priority = 1, invocationCount = 1, enabled = true)
	public void searchtrip() throws IOException, InterruptedException {

try {
		// compile time & return us current method name.
		class Local {
		}
		;
		NAME = Local.class.getEnclosingMethod().getName();
		System.out.println("Entered in >>" + NAME);
// ----------------------------------------------------------------------------------------------------------------
		Thread.sleep(2000);
		Utility.getScreenshot(driver, NAME + "_ScreenShot");

		/*
		 * Start Write code/TC here..
		 * 
		 */
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.findElement(fromcity).sendKeys("goa,india");
		Thread.sleep(2000);

		driver.findElement(
				By.xpath("(//li[@id='react-autowhatever-1-section-0-item-0'])/div/div/p[contains(Goa, India)]"))
				.click();
  
// =============================================================================		
		Thread.sleep(2000);
		driver.findElement(tocity).sendKeys("Mumbai,india");

		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']/div/div/p[contains(Mumbai, India)]"))
				.click();

//  =============================================================================

		driver.findElement(departure).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.findElement(By.xpath("(//*[@class='dateInnerCell'])[40]")).click();

		gettodaydate();
			  
//=============---------------Perfect for date-----------=======================				  
		
		/*
		 * List<WebElement> allDates =
		 * driver.findElements(By.xpath("(//*[@class='dateInnerCell'])"));
		 * 
		 * for (WebElement ele : allDates) {
		 * 
		 * String date = ele.getText(); System.out.println(date);
		 * 
		 * // if(date.equalsIgnoreCase("31"))
		 * 
		 * // convert string date in int and add and again convert in to string
		 * 
		 * int i = Integer.parseInt(currentdate); int departure = i + 2; String d =
		 * String.valueOf(departure); System.out.println("your departure date is " +
		 * departure); Thread.sleep(1000);
		 * 
		 * if (date.startsWith(d)) { System.out.println("matched");
		 * 
		 * ele.click(); System.out.println("clicked"); break; }
		 * 
		 * }
		 */
				  
//================================---return date---===============================	  

		Thread.sleep(2000);
		try {
			driver.findElement(returnback1).click();  //for shiftModal
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			System.out.println("This is in inactive");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			driver.findElement(returnback).click(); //for shiftModal
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			System.out.println("This is in shiftModal");
			
			e.printStackTrace();
		}

		driver.findElement(By.xpath("(//*[@class='dateInnerCell'])[45]")).click();

		Thread.sleep(4000);

//=============---------------Perfect for date-----------=======================				  

		/*
		 * List<WebElement> allDates1 =
		 * driver.findElements(By.xpath("(//*[@class='dateInnerCell'])"));
		 * 
		 * for (WebElement ele : allDates1) {
		 * 
		 * String date = ele.getText(); System.out.println(date);
		 * 
		 * // if(date.equalsIgnoreCase("31"))
		 * 
		 * // convert string date in int and add and again convert in to string
		 * 
		 * int i = Integer.parseInt(currentdate); int returndate = i + 3;
		 * 
		 * String d2 = String.valueOf(returndate);
		 * System.out.println("Your returndate date is " + returndate);
		 * Thread.sleep(4000);
		 * 
		 * if (date.startsWith(d2)) { System.out.println("matched");
		 * 
		 * ele.click(); System.out.println("clicked"); break; }
		 * 
		 * }
		 * 
		 */		
		
		
		driver.findElement(travellers).click();
		driver.findElement(travellers_children).click();
		driver.findElement(apply).click();
		
		Thread.sleep(2000);
		
		driver.findElement(search).click();
		Thread.sleep(2000);
		driver.findElement(departure_flight).click();
		driver.findElement(return_flight).click();
		driver.findElement(bookNow).click();
		
//=============--------------------------------------------=======================					
		  
				  
////=============------------------=======================
		Thread.sleep(2000);
		Utility.getScreenshot(driver, NAME + "_ScreenShot");
	}catch(

	Exception e)
	{
		// TODO Auto-generated catch block
		Utility.getScreenshot(driver, NAME + "_Fail_ScreenShot");
		System.out.println("##ERROR msg:>>please re-check method >>" + NAME);
		e.printStackTrace();
	}

	finally
	{
		closeBrowser();
	}

//============================------------------------======================================================
				
	}

	public static void gettodaydate() {
		// --- ---- --- use Java calendar concept---------------------------
		DateFormat df = new SimpleDateFormat("dd");
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 0);// insted of 0 we can use +-1 to increase or decrease current date.
		currentdate = df.format(cal.getTime());
		System.out.println(currentdate);
		// ------------------------------------------------------------
	}

}
