package Steps;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

public class Steps {
	
	Response response;
	
	@Given("I hit the api")
	public void i_hit_the_api() {
		
		 RestAssured.baseURI="https://www.boredapi.com";
		 RestAssured.basePath="/api/activity";	
	}

	@When("I Pass the URL")
	public void i_pass_the_url() {
		
		RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON);
		
		response = httpRequest.get().then().extract().response();
	}

	@Then("verify Reponse Code is {string}")
	public void verify_reponse_code_is(String string) {
	 
		int statusCode = response.getStatusCode();
		String Code=String.valueOf(statusCode);
		Assert.assertEquals(string, Code);
	}
}
