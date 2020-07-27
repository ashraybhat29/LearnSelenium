package com.testng.crossbrowser.test.testngcrossbrowser;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossBrowser {
	WebDriver driver;
		
	@Test
	@Parameters ( {"URL", "BrowserType"} )
	public void verifyTAU (String url, String browserType) throws InterruptedException
	{
		if (browserType.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Ashray\\JavaLearning\\testngcrossbrowser\\Drivers\\chromedriver_81.exe");
			driver = new ChromeDriver ();
		} 
		else if (browserType.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Ashray\\JavaLearning\\testngcrossbrowser\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver ();
		}
		else if (browserType.equalsIgnoreCase("Internet Explorer")) 
		{
			System.out.println("ie1");
			System.setProperty("webdriver.ie.driver", "F:\\Ashray\\JavaLearning\\testngcrossbrowser\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver ();
			System.out.println("ie2");
		}
				
		driver.manage().window().maximize();
		driver.get(url);
			Thread.sleep(10000);	
		System.out.println("\n" + "Open " + browserType);
		System.out.println("   " +  driver.getTitle());
		System.out.println("Close " + browserType + "\n");
			
		driver.quit();
	}
}



