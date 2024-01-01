package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.Authentication;
import utilities.ConfigReader;

import java.util.Arrays;

import static hooks.HooksAPI.spec;
import static io.restassured.path.json.JsonPath.given;

public class API_Stepdefinitions {


    public static String fullPath;
    Response response;
    String mesaj;
    JsonPath jsonPath;
    JSONObject requestBody;


    @Given("The API user sets {string} path parameters")
    public void The_apı_user_sets_path_parameters(String rawPaths) {
        String[] paths = rawPaths.split("/");

        System.out.println(Arrays.toString(paths));

        StringBuilder tempPath = new StringBuilder("/{");


        for (int i = 0; i < paths.length; i++) {

            String key = "pp" + i;
            String value = paths[i].trim();

            spec.pathParam(key, value);

            tempPath.append(key + "}/{");
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));

        fullPath = tempPath.toString();
        System.out.println("fullPath = " + fullPath);
    }


    @Given("The API user saves the response from the api categories list endpoint with valid authorization information")
    public void The_apı_user_saves_the_response_from_the_api_categories_list_endpoint_with_valid_authorization_information() {

        response = RestAssured.given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }


    @Given("The API user verifies that the status code is {int}")
    public void theAPIUserVerifiesThatTheStatusCodeIs(int status) {
        response.then()
                .assertThat()
                .statusCode(status);
    }


    @Given("The API user verifies that the remark information in the response body is {string}")
    public void theAPIUserVerifiesThatTheRemarkInformationInTheResponseBodyIs(String remark) {
        response.then()
                .assertThat()
                .body("remark", Matchers.equalTo(remark));
    }


    @Given("The API User verifies that the message information in the response body is {string}")
    public void theAPIUserVerifiesThatTheMessageInformationInTheResponseBodyIs(String message) {
        response.then()
                .assertThat()
                .body("data.message", Matchers.equalTo(message));

    }

    @Given("API user saves the response from the api categories list endpoint with valid authorization information")
    public void API_user_saves_the_response_from_the_api_categories_list_endpoint_with_valid_authorization_information() {

        response = RestAssured.given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("user"))
                .when()
                .get(fullPath);

        response.prettyPrint();

    }

    @Then("Verify the information of the one with the id {int} in the API user response body: {string}, {int}, {int}, {string}, {string}, {int}, {int}, {string}, {string}, {int}, {int}, {string}, {int}, {string}, {string}, {string}, {string}")
    public void Verify_the_information_of_the_one_with_the_id_in_the_apı_user_response_body(int dataIndex, String loan_number, int user_id, int plan_id, String amount, String per_installment, int installment_interval, int delay_value, String charge_per_installment, String delay_charge, int given_installment, int total_installment, String admin_feedback, int status, String due_notification_sent, String approved_at, String created_at, String updated_at) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(loan_number, jsonPath.getString("data[" + dataIndex + "].loan_number"));
        Assert.assertEquals(user_id, jsonPath.getInt("data[" + dataIndex + "].user_id"));
        Assert.assertEquals(plan_id, jsonPath.getInt("data[" + dataIndex + "].plan_id"));
        Assert.assertEquals(amount, jsonPath.getString("data[" + dataIndex + "].amount"));
        Assert.assertEquals(per_installment, jsonPath.getString("data[" + dataIndex + "].per_installment"));
        Assert.assertEquals(installment_interval, jsonPath.getInt("data[" + dataIndex + "].installment_interval"));
        Assert.assertEquals(delay_value, jsonPath.getInt("data[" + dataIndex + "].delay_value"));
        Assert.assertEquals(charge_per_installment, jsonPath.getString("data[" + dataIndex + "].charge_per_installment"));
        Assert.assertEquals(delay_charge, jsonPath.getString("data[" + dataIndex + "].delay_charge"));
        Assert.assertEquals(given_installment, jsonPath.getInt("data[" + dataIndex + "].given_installment"));
        Assert.assertEquals(total_installment, jsonPath.getInt("data[" + dataIndex + "].total_installment"));
        Assert.assertNull(admin_feedback, jsonPath.getString("data[" + dataIndex + "].admin_feedback"));
        Assert.assertEquals(status, jsonPath.getInt("data[" + dataIndex + "].status"));
        Assert.assertNull(due_notification_sent, jsonPath.getString("data[" + dataIndex + "].due_notification_sent"));
        Assert.assertNull(approved_at, jsonPath.getString("data[" + dataIndex + "].approved_at"));
        Assert.assertEquals(created_at, jsonPath.getString("data[" + dataIndex + "].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data[" + dataIndex + "].updated_at"));

    }


    @Given("The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized")
    public void theAPIUserRecordsTheResponseWithInvalidAuthorizationInformationVerifiesThatTheStatusCodeIsAndConfirmsThatTheErrorInformationIsUnauthorized() {
        try {
            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                    .when()
                    .get(fullPath);
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("mesaj: " + mesaj);

        Assert.assertTrue(mesaj.contains("status code: 401, reason phrase: Unauthorized"));
    }


    @Given("Verify the information of the one with the id {int} in the API user response body: {int}, {string}, {string},  {int}, {string}, {string}")
    public void verify_the_information_of_the_one_with_the_id_in_the_apı_user_response_body(int dataIndex, int id, String name, String description, int status, String created_at, String updated_at) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(id, jsonPath.getInt("data[" + dataIndex + "].id"));
        Assert.assertEquals(name, jsonPath.getString("data[" + dataIndex + "].name"));
        Assert.assertNull(jsonPath.get("data[" + dataIndex + "].image"));
        Assert.assertEquals(description, jsonPath.getString("data[" + dataIndex + "].description"));
        Assert.assertEquals(status, jsonPath.getInt("data[" + dataIndex + "].status"));
        Assert.assertEquals(created_at, jsonPath.getString("data[" + dataIndex + "].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data[" + dataIndex + "].updated_at"));
    }


    @Given("A patch body that contains the right data {int} is sent")
    public void a_patch_body_that_contains_the_right_data_is_sent(int int1) {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                //           .body(requestBody.toString())
                .patch(fullPath);

        response.prettyPrint();
    }


    @When("The API user prepares a POST request containing the correct data to send to the user subscriber add endpoint")
    public void theAPIUserPreparesAPOSTRequestContainingTheCorrectDataToSendToTheUserSubscriberAddEndpoint() {
        requestBody = new JSONObject();

        requestBody.put("email", ConfigReader.getProperty("email"));
    }

    @When("The API user prepares a POST request containing invalid data to send to the user subscriber add endpoint")
    public void theAPIUserPreparesAPOSTRequestContainingInvalidDataToSendToTheUserSubscriberAddEndpoint() {
        requestBody = new JSONObject();

        requestBody.put("invalidmail", ConfigReader.getProperty("invalidmail"));
    }

    @Then("The API user saves the response from the api subscriber details endpoint with valid authorization information")
    public void theAPIUserSavesTheResponseFromTheApiSubscriberDetailsEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .body(requestBody.toString())
                .post(fullPath);

        response.prettyPrint();
    }

    @When("The API user saves the response from the api subscriber add endpoint with valid authorization information")
    public void theAPIUserSavesTheResponseFromTheApiSubscriberAddEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .body(requestBody.toString())
                .post(fullPath);

        response.prettyPrint();

    }


     @When("The API user saves the response from the api Tickets endpoint with valid authorization information")
      public void theAPIUserSavesTheResponseFromTheApiTicketsEndpointWithValidAuthorizationInformation() {

     response = RestAssured.given()
            .spec(spec)
            .header("Accept", "application/json")
            .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
            .when()
            .get(fullPath);

     response.prettyPrint();
   }

    @When("The API user verifies that the content of the data field in the response body includes {}, {}, {string}, {string}, {string}, {string}, {}, {}, {string}, {string}, {string}")
    public void theAPIUserVerifiesThatTheContentOfTheDataFieldInTheResponseBodyIncludes(int id, int user_id, String name, String email, String ticket, String subject, int status, int priority, String last_reply, String created_at, String updated_at) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(id, jsonPath.getInt("data.id"));
        Assert.assertEquals(user_id, jsonPath.getInt("data.user_id"));
        Assert.assertEquals(name, jsonPath.getString("data.name"));
        Assert.assertEquals(email, jsonPath.getString("data.email"));
        Assert.assertEquals(ticket, jsonPath.getString("data.ticket"));
        Assert.assertEquals(subject, jsonPath.getString("data.subject"));
        Assert.assertEquals(status, jsonPath.getInt("data.status"));
        Assert.assertEquals(priority, jsonPath.getInt("data.priority"));
        Assert.assertEquals(last_reply, jsonPath.getString("data.last_reply"));
        Assert.assertEquals(created_at, jsonPath.getString("data.created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data.updated_at"));

    }

    @When("The API user saves the response from the api Loans endpoint with valid authorization information")
    public void theAPIUserSavesTheResponseFromTheApiLoanEndpointWithValidAuthorizationInformation() {
        response = RestAssured.given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }


    @When("The API user verifies that the content of the data field in the response body includes INSTALLMENT : {int}, {string},  {string}, {string}")
    public void theAPIUserVerifiesThatTheContentOfTheDataFieldInTheResponseBodyIncludesINSTALLMENT(int loan_id, String delay_charge, String installment_date, String given_at) {
        jsonPath = response.jsonPath();
        Assert.assertEquals(loan_id, jsonPath.getInt("data.loan_id"));
        //Assert.assertEquals(id, jsonPath.getInt("data.id"));
        Assert.assertEquals(delay_charge, jsonPath.getString("data.delay_charge"));
        Assert.assertEquals(installment_date, jsonPath.getString("data.installment_date"));
        Assert.assertEquals(given_at, jsonPath.getString("data.given_at"));
    }


    @When("The API user records the response POST with invalid authorization information, verifies that the status code is  and confirms that the error information is Unauthorized")
    public void theAPIUserRecordsTheResponsePOSTWithInvalidAuthorizationInformationVerifiesThatTheStatusCodeIsAndConfirmsThatTheErrorInformationIsUnauthorized() {
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                .when()
                .body(requestBody.toString())
                .post(fullPath);

        response.prettyPrint();

    }

    @When("Verify the information of the one with Installment the id {int} in the API user response body:{int}, {int}, {string}, {string}")
    public void verifyTheInformationOfTheOneWithInstallmentTheIdInTheAPIUserResponseBody(int dataIndex, int loan_id, int id,  String delay_charge, String installment_date )
    {

        jsonPath = response.jsonPath();
        Assert.assertEquals(loan_id, jsonPath.getInt("data.data[" + dataIndex + "].loan_id"));
        Assert.assertEquals(id, jsonPath.getInt("data.data[" + dataIndex + "].id"));
        Assert.assertEquals(delay_charge, jsonPath.getString("data.data[" + dataIndex + "].delay_charge"));
        Assert.assertEquals(installment_date, jsonPath.getString("data.data[" + dataIndex + "].installment_date"));
        Assert.assertNull( jsonPath.getString("data.data[" + dataIndex + "].given_at"));

    }

}











