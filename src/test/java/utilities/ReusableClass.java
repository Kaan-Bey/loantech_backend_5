package utilities;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

import javax.script.AbstractScriptEngine;

import javax.swing.text.SimpleAttributeSet;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static hooks.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static stepdefinitions.API_Stepdefinitions.fullPath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static utilities.DBUtils.*;


public class ReusableClass {
    static Response response;

    public static Response getRequest(String admin) {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer", "+Authentication.generateToken(admin)")
                .when()
                .get(fullPath);
        return response;
    }


    public static void createConnection() {
        String url = ConfigReader.getProperty("base_url");
        String username = ConfigReader.getProperty("adminUsername");
        String password = ConfigReader.getProperty("adminPassword");

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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