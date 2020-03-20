package pack02bddFramework;

import static io.restassured.RestAssured.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Veify {
	
	RequestSpecification req;
	Response res;
	
	@Given("The baseURI is set as {string}")
	public void the_baseURI_is_set_as(String string) {
	    baseURI = string;
	}

	@Given("the parameters q is {string} and units is {string} and appid is {string}")
	public void the_parameters_q_is_and_units_is_and_appid_is(String string, String string2, String string3) {
		req = given().
				param("q", string).
				param("units", string2).
				param("appid", string3);
	}

	@When("a GET request is made")
	public void a_GET_request_is_made() {
	    res = req.when().get();
	}

	@Then("verify that status code is {int}")
	public void verify_that_status_code_is(Integer int1) {
	    res.then().statusCode(int1);
	}
	
	@Then("print the name of the city")
	public void print_the_name_of_the_city() {
	    System.out.println(res.then().extract().jsonPath().getString("list.name"));
	}
}
