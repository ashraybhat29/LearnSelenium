package com.testng.crossbrowser.test.testngcrossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReport 
{
	WebDriver driver;
	@Test
	public void TC001() throws InterruptedException
	{
	        // declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver", "F:\\Ashray\\JavaLearning\\testngcrossbrowser\\Drivers\\chromedriver_81.exe");
		driver = new ChromeDriver ();
	    	
	 	        // launch Chrome and direct it to the Base URL
	        driver.get("https://demo.opencart.com/");

	        /*
	         * compare the actual title of the page with the expected one 
	         */
	        String actualTitle = driver.getTitle();
			String expectedTitle = "Your Store";
			Assert.assertEquals(actualTitle, expectedTitle);
	       
	        //close Chrome
	        driver.close();
	       
	    }
}


