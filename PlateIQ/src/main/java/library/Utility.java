package library;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class Utility extends BasePage {
	
 static String dateFinal;
	/*
	 * By calling of This class we can take screenshot of browser page at any time. 
	 * We cab call this class like as: < Utility.getScreenshot(driver);>
	 * create a folder with name "screenshot" all screenshot will store there.
	*/
	public static void getScreenshot(WebDriver driver,String screenshotName) { 
		calender(0); 
		            
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    //casting TakesScreenshot interface.       
		
		// now copy the  screenshot to desired location using copyFile method
		 
		try {
			FileUtils.copyFile(src, new File("./screenshot/"+dateFinal+"_"+screenshotName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Screenshot Taken >> please check screenshot in project folder name >> ./screenshot >> in .png formet ");
		 
		 

	}

	public static void calender(int i) {
		// --- ---- --- use Java calendar concept---------------------------
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				Date date = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				cal.add(Calendar.DATE, i);// insted of 0 we can use +-1 to increase or decrease current date.
				dateFinal = df.format(cal.getTime());
//				System.out.println("Your used date is >>>"+dateFinal);
		// ------------------------------------------------------------
	   }




}

