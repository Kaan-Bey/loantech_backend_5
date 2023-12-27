package utilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import javax.script.AbstractScriptEngine;

public class ReusableClass {

    /*
    private String baseUrl = "https://example.com/api"; // API'nin temel URL'si
    @When("I send a GET request to {string}")
    public void iSendAGETRequestToEndpoint(String endpoint) {
        Response response = RestAssured.get(baseUrl + endpoint);
        // İstek sonuçları ile ilgili işlemler burada yapılabilir
        AbstractScriptEngine ScenarioContext;
        ScenarioContext.setContext("response", response); // Senaryo bağlamına response'ı ekleyin
    }
    @When("I send a POST request to {string} with body")
    public void iSendAPOSTRequestToEndpointWithBody(String endpoint, String requestBody) {
        Response response = RestAssured.given().body(requestBody).post(baseUrl + endpoint);
        // İstek sonuçları ile ilgili işlemler burada yapılabilir
        ScenarioContext.setContext("response", response); // Senaryo bağlamına response'ı ekleyin
    }
    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        Response response = (Response) ScenarioContext.getContext("response");
        response.then().statusCode(expectedStatusCode);
    }


     */
}