package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData 
{
	
	@Test
	public void testResponseCode()
	{
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
		
		int code= resp.getStatusCode();
		
		System.out.println("Status Code is:"+code);
		
		Assert.assertEquals(code,200);
	}
	
	@Test
	public void testBody()
	{
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
		
		String data= resp.asString();
		
		System.out.println("Data is:"+data);
		
		System.out.println("Response Time  is:"+resp.getTime());
	}
	

}
