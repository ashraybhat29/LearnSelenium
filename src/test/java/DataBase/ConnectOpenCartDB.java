package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ConnectOpenCartDB
{
	WebDriver driver;
	@Test
	public void testOpencartDB() throws ClassNotFoundException, SQLException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\Drivers\\chromedriver_81.exe");
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
		driver.get("https://demo.opencart.com/");
		
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("Driver Loaded");
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium", "root", "Oracle@2020");
		
		System.out.println("DB connected to mysql db");
		
		Statement smt = con.createStatement();
		
		ResultSet rs = smt.executeQuery("select * from demoopencart");
		
		while(rs.next())
		{
			String username = rs.getString("username");
			
			System.out.println("DataBAse record is:"+username);
			
			String password = rs.getString("password");
			
			System.out.println("DataBAse record is:"+password);
			
			driver.findElement(By.xpath("(//a[@title='My Account']|//span[text()='My Account'])[1]")).click();
			driver.findElement(By.linkText("Login")).click();
			
			driver.findElement(By.xpath("//input[@placeholder='E-Mail Address']|//input[@name='email']|//input[@id='input-email']")).sendKeys(username);
			driver.findElement(By.id("input-password")).sendKeys(password);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			if(driver.getTitle().equals("My Account"))
			{
				System.out.println("Login successfull");
				
			}
			
			else
			{
				System.out.println("Login not sucessfull");
			}
			
			driver.findElement(By.xpath("(//a[@title='My Account']|//span[text()='My Account'])[1]")).click();
			driver.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
		}
		
		driver.close();
	}


}
