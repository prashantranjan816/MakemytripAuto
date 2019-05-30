package Assignment.PlateIQ;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import library.Utility;

public class PersonalLogin extends HomePage {
	
	final static By  loginoption        =  By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser ']");
	final static By  user_id      		=  By.xpath("//*[@placeholder='Enter email or mobile number']");
	final static By  user_pswd     		=  By.xpath("//*[@placeholder='minimum 6 characters.']");
	final static By  loginbutton     	=  By.xpath("//button[@class='capText font16']");
	
	

	static String currentdate;
	String NAME;
	
	
	
	
	@Test(priority = 1, invocationCount = 1, enabled = true)
	public void personalLogin() throws IOException, InterruptedException {
	
		try {
			// Bellow we are creating new anonymous inner class will be created during
			// compile time & return us current method name.
			class Local {
			}
			;
			NAME = Local.class.getEnclosingMethod().getName();
			System.out.println("Entered in >>" + NAME);
	// ----------------------------------------------------------------------------------------------------------------
			Thread.sleep(4000);
			Utility.getScreenshot(driver, NAME + "_ScreenShot");

			/*
			 * Start Write code/TC here..
			 * 
			 */
			// driver.manage().window().maximize();
	
	
		driver.findElement(loginoption).click();
		Thread.sleep(4000);
		driver.findElement(user_id).sendKeys("test@plateiq.com");
		driver.findElement(user_pswd).sendKeys("test@123");
		
		driver.findElement(loginbutton).click();
		
		
			
		////=============------------------=======================
			Thread.sleep(4000);
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

		
		
		
		
		
		
		
		
	
	
	}
	

}
