package AutoSuggestion;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoSug
{
WebDriver driver;
	
	@BeforeMethod
	public void precondition()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Ashray\\JavaLearning\\testngcrossbrowser\\Drivers\\chromedriver_81.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        
        // URL                    		
        driver.get("http://www.google.com/");	
	}
	
	
	@AfterMethod
	public void precondtion()
	{
		driver.quit();
	}
	
	
	@Test
	public  void tc001_AutoAuggestion() throws NoAlertPresentException,InterruptedException 
	{									
				      	
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("java");	
       // WebDriverWait	wait = new WebDriverWait(driver,30);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='sbtc'] [@role='option']"))));
      //  List <WebElement> sug = driver.findElements(By.xpath("//div[@class='sbtc'] [@role='option']"));
        
        
        List<WebElement> sug = driver.findElements(By.cssSelector(".sbtc"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
         wait.until(ExpectedConditions.visibilityOfAllElements(sug));
         
         
         
        System.out.println("ok");
        int size = sug.size();
        System.out.println(size);
        for(int i=0; i<size;i++)
        {
        	System.out.println("ok2");
        	WebElement element = sug.get(i);
        	String text = element.getText();
        	System.out.println("ok3");
        	System.out.println("test"+text);
        	System.out.println("ok4");
        }

	}

}
