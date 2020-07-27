package AlertPOPUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertDemo 
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
        driver.get("http://www.javascriptkit.com/javatutors/alert2.shtml");	
	}
	
	
	@AfterMethod
	public void precondtion()
	{
		driver.quit();
	}
	
	@Test
	public  void tc001_AlertAccept() throws NoAlertPresentException,InterruptedException 
	{									
				      	
        driver.findElement(By.name("B2")).click();				
   
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= alert.getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);
        		
        // Accepting alert		
        alert.accept();		
        driver.quit();
        
    }	
	
	@Test
	public  void tc002_AlertDismiss() throws NoAlertPresentException,InterruptedException 
	{									
				      	
        driver.findElement(By.name("B3")).click();				
   
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= alert.getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);
        		
        // Accepting alert		
        alert.dismiss();		
        driver.quit();
        
    }
	
	@Test
	public  void tc003_AlertSendkeys() throws NoAlertPresentException,InterruptedException 
	{									
				      	
        driver.findElement(By.name("B4")).click();				
   
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= alert.getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);
        //Enter the text
        alert.sendKeys("ABCD");
        // Accepting alert		
        alert.accept();		
        driver.quit();
        
    }

}