package pack01statusCode;

import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Verify {
	
	String url = "http://api.openweathermap.org/data/2.5/find?q=bengaluru&units=metric&appid=2470d8a942478fc83d733ba5f98716c2";
	
	@Test
	public void verifyStatusCode()
	{
		given().
		when().
			get(url).
		then().
			statusCode(200);
	}
	
	@Test
	public void printCityName()
	{
		System.out.println(given().
		when().
			get(url).
		then().
			extract().jsonPath().getString("list.name"));
	}
}
