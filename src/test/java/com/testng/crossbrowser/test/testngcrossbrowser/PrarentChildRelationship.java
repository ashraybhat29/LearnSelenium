package com.testng.crossbrowser.test.testngcrossbrowser;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class PrarentChildRelationship {
	

	public static void main(String[] args) throws InterruptedException {

	// TODO Auto-generated method stub

	System.setProperty("webdriver.chrome.driver", "F:\\Ashray\\Selenium\\Drivers\\chromedriver_83.exe");

	WebDriver driver =new ChromeDriver();

	driver.get("http://spicejet.com"); //URL in the browser
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();

	Thread.sleep(5000);
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")).click();

	driver.findElement(By.xpath("//a[@value='BLR']")).click();

	Thread.sleep(2000);

	//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

	driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

	driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

	}



	}
