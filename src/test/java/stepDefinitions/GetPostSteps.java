package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class GetPostSteps {

    private Response response;

//    @Given("I perform GET operation for {string}")
//    public void iPerformGETOperationFor(String url) {
//
//        System.out.println("Hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
//        given().contentType(ContentType.JSON);
//                .with().pathParam("post", 1) required /{post}
//                .with().queryParam("id", 1);
   // }

//    @And("I perform GET for the post number {string}")
//    public void iPerformGETForThePostNumber(String postNumber) {
//        System.out.println("Hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
//        when().get(String.format("http://localhost:3000/posts/%s",postNumber)).
//                then().body("author", containsString( "Karthik KK"));
//    }
//
//    @Then("I should see the author name as {string}")
//    public void iShouldSeeTheAuthorNameAs(String arg0) {
//        System.out.println("Hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
//    }

    @Given("the API is up and running")
    public void theAPIIsUpAndRunning() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    @When("I send a GET request to the endpoint")
    public void iSendAGETRequestToTheEndpoint() {
        response = given().get("/posts");
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @And("the response body should contain {string}")
    public void theResponseBodyShouldContain(String expectedContent) {
        String responseBody = response.getBody().asString();
//        JSONAssert.assertEquals(expectedContent, responseBody, false);
        System.out.println(responseBody);
        System.out.println(expectedContent);
    }

    @When("I send a DELETE request to {string} with views {int}")
    public void iSendADELETERequestToWithViewsViews(String endpoint, int views) {
        String requestBody = "{\"views\": " + views + "}";

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .delete(endpoint);
    }

    @Given("I load test data")
    public void iLoadTestData() throws FileNotFoundException {
        String filePath = "src/test/java/utils/utils.json";
        Gson gson = new Gson();
       // List<TestData> testDataList = gson.fromJson(new FileReader(filePath), new TypeToken<List<TestData>>() {}.getType());

        // Iterate over testDataList and perform tests
       // for (TestData testData : testDataList) {
         //   System.out.println(testData.getBaseUri()+"     "+testData.getExpectedStatusCode());
            // Use testData.getBaseUri(), testData.getMethod(), testData.getEndpoint(), testData.getExpectedStatusCode() to perform API tests
        //}
    }


//    @When("I send a POST request to {string} create a user with id {string} and views {int}")
//    public void iSendAPOSTRequestToCreateAUserWithIdAndViews(String endpoint, String id, int views) {
//        String requestBody = "{\"id\": \"" + id + "\", \"views\": " + views + "}";
//
//        response = given()
//                .contentType(ContentType.JSON)
//                .body(requestBody)
//                .when()
//                .post(endpoint);
//    }
}
