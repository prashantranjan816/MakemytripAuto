package base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import java.util.function.Function;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.Utility;


public class BasePage {
	
	protected static String dateFinal;
	protected static WebDriver driver;  // use protected so that call from all child class
	;


    public void selectItemByValue(WebElement element, String itemToSelect) {
        getSelect(element).selectByValue(itemToSelect);
    }

    public void selectItemByText(WebElement element, String text) {
        getSelect(element).selectByVisibleText(text);
    }

    public void selectItemByIndex(WebElement element, int index) {
        getSelect(element).selectByIndex(index);
    }

    public void clickButton(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getRandomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String getRandomNumeric() {
        return RandomStringUtils.randomNumeric(3);
    }

    public JavascriptExecutor getJavaScriptExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public void clickElementWithJavascript(WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", element);
        }
    }

    public void handledSleep(int sleepInSeconds) {
        Calendar cal = Calendar.getInstance();
        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.SECOND, sleepInSeconds);
        while (cal1.after(cal)) {
            cal = Calendar.getInstance();
        }
    }

    public void waitTillMultipleTabOpens() {
        Set<String> allWindows = driver.getWindowHandles();
        while (allWindows.size() == 1) {
            allWindows = driver.getWindowHandles();
        }
    }

 

    public void switchToFirstTab() {
        Set<String> handles = driver.getWindowHandles();
        for (int i = handles.size(); i > 1; i--) {
            driver.switchTo().window(
                    handles.toArray(new String[handles.size()])[i - 1]);
            driver.close();
        }
        driver.switchTo().window(
                handles.toArray(new String[handles.size()])[0]);
    }


    public void selectRadioButtonByValue(By radioGroup, String ValueToSelect) {
        // Find the radio group element
        List<WebElement> radioLabels = driver.findElements(
                radioGroup);
        for (int i = 0; i < radioLabels.size(); i++) {
            if (radioLabels.get(i).getText().trim()
                    .equalsIgnoreCase(ValueToSelect.trim())) {
                radioLabels.get(i).click();
                break;
            }
        }
    }

    public Select getSelect(WebElement element) {
        Select select = new Select(element);
        return select;
    }

    public void sendValuesToWebElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    public boolean isDisabled(WebElement element) {
        return element.getAttribute("disabled").equalsIgnoreCase("disabled");
    }

    public boolean isEnabled(WebElement element) {
        return element.getAttribute("enabled").equalsIgnoreCase("enabled");
    }
    
    public static  void implictwait(int i){
   	 driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
		 
   }
    
   
   public void actionenter(){
   	Actions a=new Actions(driver);
   	a.sendKeys(Keys.ENTER).build().perform();
   }
   public void actiondown() {
	   Actions b=new Actions(driver);
       b.sendKeys(Keys.DOWN).build().perform();
   }
   
   public void scrollup(){
   	JavascriptExecutor js = ((JavascriptExecutor) driver);
   	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
   }
  
   public void alertaccept(){
   	driver.switchTo().alert().accept();
   	
   }
   
    
   public static void calender(int i) {
	// --- ---- --- use Java calendar concept---------------------------
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, i);// insted of 0 we can use +-1 to increase or decrease current date.
			dateFinal = df.format(cal.getTime());
			System.out.println("Your used date is >>>"+dateFinal);
	// ------------------------------------------------------------
   }
   
   public static void browsweScreen() {
	   driver.manage().window().maximize();
   }
     
   
   public static void sleepTime(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
   public static void closeBrowser() {
	   sleepTime(2000);
	   driver.quit();
	   System.out.println("Browser quit!!!");
   }
   
   
   public void navigatePage_back() {
	   driver.navigate().back();
	   System.out.println("Navigate to back page");
   }
   
   public void navigatePage_next() {
	   driver.navigate().forward();
	   System.out.println("Navigate to next page");
   }
   
   public void navigatePage_refresh() {
	   driver.navigate().refresh();
	   System.out.println("Refresh the current page");
   }
   
   public void pagescrolldown(int a, int b) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(a,b)"); // 0,1000
	}

   
   
   
}
