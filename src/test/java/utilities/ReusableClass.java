package utilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import javax.script.AbstractScriptEngine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static utilities.DBUtils.*;

public class ReusableClass {

    /*
    public static void createConnection()  {
        String url=ConfigReader.getProperty("base_url");
        String username=ConfigReader.getProperty("adminUsername");
        String password=ConfigReader.getProperty("adminPassword");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


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