package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    @Given("The API user saves the response from the user list loan endpoint with valid authorization information")
    public void TheAPIusersavestheresponsefromtheuserlistloanendpointwithvalidauthorizationinformation() {

        response = RestAssured.given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("user"))
                .when()
                .get(fullPath);

        response.prettyPrint();

    }

    @Then("The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized")
    public void TheAPIUserRecordsTheResponseWithInvalidAuthorizationInformationVerifiesThatTheStatusCodeIsAndConfirmsThatTheErrorInformationIsUnauthorized() {
        try {
            response = RestAssured.given()
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



    @Given("Verify the information of the one with the {int} in the API user response body: {int}, {string}, {string}, {string}, {string}, {int}, {int}, {string}, {string}, {string}")
    public void verify_the_information_of_the_one_with_the_in_the_apı_user_response_body(int id, int user_id, String name, String email, String ticket, String subject, int status, int priority, String last_reply, String created_at, String updated_at) {
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
    @Given("The API user verifies that the status information in the response body is {int}")
    public void the_apı_user_verifies_that_the_status_information_in_the_response_body_is(int status) {

        jsonPath=response.jsonPath();

        Assert.assertEquals(status, jsonPath.getInt("data[0].status"));

    }


    @Given("The API user saves the response from the api loanplans status endpoint with valid authorization information")
    public void the_apı_user_saves_the_response_from_the_api_loanplans_status_endpoint_with_valid_authorization_information() {

        response = RestAssured.given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .patch(fullPath);

        response.prettyPrint();

    }

    @Given("The API user records the response from the api loanplans status endpoint with invalid authorization information verifies that the status code is '401' and confirms that the error information is Unauthorized")
    public void the_apı_user_records_the_response_from_the_api_loanplans_status_endpoint_with_invalid_authorization_information_verifies_that_the_status_code_is_and_confirms_that_the_error_information_is_unauthorized() {
        try {
            response = RestAssured.given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                    .when()
                    .patch(fullPath);
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("mesaj: " + mesaj);

        Assert.assertTrue(mesaj.contains("status code: 401, reason phrase: Unauthorized"));
    }


    @And("The API user saves the response from the api categories status endpoint with valid authorization information")
    public void TheAPIusersavestheresponsefromtheapicategoriesstatusendpointwithvalidauthorizationinformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .patch(fullPath);

        response.prettyPrint();

    }

    @Then("The API user saves the response from the api categories status endpoint with invalid authorization information and verifies that the status code is '401' and the error message is Unauthorized")
    public void theAPIUserSavesTheResponseFromTheApiCategoriesStatusEndpointWithInvalidAuthorizationInformationAndVerifiesThatTheStatusCodeIsAndTheErrorMessageIsUnauthorized() {
        try {
            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                    .when()
                    .patch(fullPath);
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("mesaj: " + mesaj);

        Assert.assertTrue(mesaj.contains("status code: 401, reason phrase: Unauthorized"));
    }

    @And("The API user saves the response from the api categories details endpoint with valid authorization information")
    public void TheAPIusersavestheresponsefromtheapicategoriesdetailsendpointwithvalidauthorizationinformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }

    @Then("The API user Verifies that the status information in the response body is {int}")
    public void The_apı_user_verifies_that_the_status_information_in_the_response_body_is(int status) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(status, jsonPath.getInt("data[0].status"));


    }

    @Given("The API user saves the response from the api ticket list endpoint with valid authorization information")
    public void TheAPIUserSavesTheResponseFromTheApiTicketListEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }

    @Then("Verify the information of the one with the id {int} in the API user response body: {int}, {string}, {string}, {string}, {string}, {int}, {int}, {string}, {string}, {string}")
    public void Verify_the_information_of_the_one_with_the_id_in_the_apı_user_response_body(int dataIndex, int user_id, String name, String email, String ticket, String subject, int status, int priority, String last_reply, String created_at, String updated_at) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(user_id, jsonPath.getInt("data[" + dataIndex + "].user_id"));
        Assert.assertEquals(name, jsonPath.getString("data[" + dataIndex + "].name"));
        Assert.assertEquals(email, jsonPath.getString("data[" + dataIndex + "].email"));
        Assert.assertEquals(ticket, jsonPath.getString("data[" + dataIndex + "].ticket"));
        Assert.assertEquals(subject, jsonPath.getString("data[" + dataIndex + "].subject"));
        Assert.assertEquals(status, jsonPath.getInt("data[" + dataIndex + "].status"));
        Assert.assertEquals(priority, jsonPath.getInt("data[" + dataIndex + "].priority"));
        Assert.assertEquals(last_reply, jsonPath.getString("data[" + dataIndex + "].last_reply"));
        Assert.assertEquals(created_at, jsonPath.getString("data[" + dataIndex + "].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data[" + dataIndex + "].updated_at"));
    }
}

