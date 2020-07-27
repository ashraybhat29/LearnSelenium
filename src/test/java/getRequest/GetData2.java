package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetData2 
{
	
	@Test
	public void testResponseCode()
	{
		
		int code= get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02").getStatusCode();
		
		System.out.println("Status Code is:"+code);
		
		Assert.assertEquals(code,200);
	}
	
	@Test
	public void testBody()
	{
				
		String data= get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02").asString();
		long time = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02").getTime();
		
		System.out.println("Data is:"+data);
		
		System.out.println("Response Time  is:"+time);
	}
	

}
