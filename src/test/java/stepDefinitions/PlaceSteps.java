package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class PlaceSteps {

    @Given("Add Place Payload")
    public void addPlacePayload() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
    }

    @When("User calls {string} with Post http request")
    public void userCallsWithPostHttpRequest(String arg0) {
        System.out.println("P...............");
    }

    @Then("The API call is success with status code {int}")
    public void theAPICallIsSuccessWithStatusCode(int arg0) {
        System.out.println("P...............");
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String arg0, String arg1) {
        System.out.println("P...............");
    }
}
