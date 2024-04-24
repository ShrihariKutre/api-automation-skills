package stepDefinitions;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;
import utils.CommonFunctions;
import utils.Pojo;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

public class HttpRequestsStepDef {

    private final Logger log = Logger.getLogger(HttpRequestsStepDef.class.getName());
    public JsonObject data, obj;
    public JsonArray jsonArray;
    public Pojo pojo;
    public Response response;
    public RequestSpecification requestSpecification;
    public String method;


    public HttpRequestsStepDef() throws FileNotFoundException {
        CommonFunctions common = new CommonFunctions();
        this.data = common.LoadTestData().get("test_data").getAsJsonObject();
    }

    @Given("The API is up and running to hit the {string} request for test data {int}")
    public void the_api_is_up_and_running_to_hit_the_request_for(String method, int data_id) {
        this.method = method;
        jsonArray = data.get(method).getAsJsonArray();
        obj = jsonArray.get(data_id - 1).getAsJsonObject();

        pojo = new Gson().fromJson(obj, Pojo.class);
        RestAssured.baseURI = pojo.getBaseUri();
        requestSpecification = RestAssured.given().contentType(ContentType.JSON);
    }
    @When("User sends the request to the endpoint")
    public void user_sends_the_request_to_the_endpoint() {
        if (method.equalsIgnoreCase("Get")) {
            response = RestAssured.get(pojo.getEndpoint());
        } else if (method.equalsIgnoreCase("Post")) {
            response = requestSpecification.body(pojo.getRequestBody()).post(pojo.getEndpoint());
        } else if (method.equalsIgnoreCase("Put")) {
            response = requestSpecification.body(pojo.getRequestBody()).put(pojo.getEndpoint());
        } else if (method.equalsIgnoreCase("Delete")) {
            response = requestSpecification.body(pojo.getRequestBody()).delete(pojo.getEndpoint());
        }
    }
    @Then("User can verify the response status code")
    public void user_can_verify_the_response_status_code() {
        Assert.assertEquals(pojo.getExpectedStatusCode(), response.getStatusCode());
    }
    @Then("User can verify the response body")
    public void user_can_verify_the_response_body() {
        String responseBody = response.getBody().asString();
        Assert.assertTrue("Response body doesn't contain the expected value", responseBody.contains(pojo.getExpectedContent()));

    }
}
