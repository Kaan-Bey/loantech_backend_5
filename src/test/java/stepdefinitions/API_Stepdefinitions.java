package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import utilities.Authentication;
import utilities.ConfigReader;
import utilities.Authentication;
import utilities.ConfigReader;

import java.util.Arrays;

import static hooks.HooksAPI.spec;
import static io.restassured.path.json.JsonPath.given;
import static org.junit.Assert.assertEquals;

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

    @Given("The API user verifies that the success attribute in the response body is true")
    public void the_apı_user_verifies_that_the_success_attribute_in_the_response_body_is_true() {
        response.then()
                .assertThat()
                .body("success", Matchers.equalTo(true));
    }

    @Given("The API user saves the response from the user ticket detail endpoint with valid authorization information")
    public void the_apı_user_saves_the_response_from_the_user_ticket_detail_endpoint_with_valid_authorization_information() {

        response = RestAssured.given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("user"))
                .when()
                .get(fullPath);

        response.prettyPrint();
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
    public void Verify_the_information_of_the_one_with_the_id_in_the_apı_user_response_body(int dataIndex, String
            loan_number, int user_id, int plan_id, String amount, String per_installment, int installment_interval, int delay_value, String charge_per_installment, String delay_charge, int given_installment, int total_installment, String admin_feedback, int status, String due_notification_sent, String approved_at, String created_at, String updated_at) {
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

    @Then("The API user verifies that the content of the data field in the response body includes {int}, {int}, {string}, {string}, {string}, {string}, {int}, {int}, {string}, {string}, {string}")
    public void the_apı_user_verifies_that_the_content_of_the_data_field_in_the_response_body_includes(int id, int user_id, String name, String email, String ticket, String subject, int status, int priority, String last_reply, String created_at, String updated_at) {
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


    @Given("Verify the information of the one with the {int} in the API user api tickets details response body: {int}, {string}, {string}, {string}, {string}, {int}, {int}, {string}, {string}, {string}")
    public void verify_the_information_of_the_one_with_the_in_the_apı_user_api_tickets_details_response_body(int id, int user_id, String name, String email, String ticket, String subject, int status, int priority, String last_reply, String created_at, String updated_at) {

        jsonPath = response.jsonPath();

        Assert.assertEquals(id, jsonPath.getInt("data.id"));
        Assert.assertEquals(user_id, jsonPath.getInt("data.user_id"));
        Assert.assertEquals(name, jsonPath.getString("data.name"));
        Assert.assertEquals(email, jsonPath.getString("data.email"));
        Assert.assertEquals(ticket, jsonPath.get("data.ticket"));
        Assert.assertEquals(subject, jsonPath.getString("data.subject"));
        Assert.assertEquals(status, jsonPath.getInt("data.status"));
        Assert.assertEquals(priority, jsonPath.getInt("data.priority"));
        Assert.assertEquals(last_reply, jsonPath.getString("data.last_reply"));
        Assert.assertEquals(created_at, jsonPath.getString("data.created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data.updated_at"));
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

    @When("The API user records the response POST with invalid authorization information, verifies that the status code is {string} and confirms that the error information is Unauthorized")
    public void theAPIUserRecordsTheResponsePOSTWithInvalidAuthorizationInformationVerifiesThatTheStatusCodeIsAndConfirmsThatTheErrorInformationIsUnauthorized(int arg0) {
        try {
            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                    .when()
                    .post(fullPath);
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("mesaj: " + mesaj);
        Assert.assertTrue(mesaj.contains("status code: 401, reason phrase: Unauthorized"));
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

    @Given("The API user saves the response from the user category delete endpoint with valid authorization information")
    public void the_apı_user_saves_the_response_from_the_user_category_delete_endpoint_with_valid_authorization_information() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .delete(fullPath);

        response.prettyPrint();
    }

    @Given("The API user saves the response from the api categories delete endpoint with invalid authorization information information and confirms that the status code is {string} and the error message is Unauthorized")
    public void the_apı_user_saves_the_response_from_the_api_categories_delete_endpoint_with_invalid_authorization_information_information_and_confirms_that_the_status_code_is_and_the_error_message_is_unauthorized(String string) {
        try {
            response = given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                    .when()
                    .delete(fullPath);
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("mesaj: " + mesaj);

        Assert.assertTrue(mesaj.contains("status code: 401, reason phrase: Unauthorized"));
    }


    @Given("The API user verifies that the content of the data field in the user ticket detail response body includes {int}, {int}, {string}, {string}, {string}, {string}, {int}, {int}, {string}, {string}, {string}")
    public void the_apı_user_verifies_that_the_content_of_the_data_field_in_the_user_ticket_detail_response_body_includes(int id, int user_id, String name, String email, String ticket, String subject, int status, int priority, String last_reply, String created_at, String updated_at) {

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

    @Given("The API user saves the response from the user ticket close endpoint with valid authorization information")
    public void the_apı_user_saves_the_response_from_the_user_ticket_close_endpoint_with_valid_authorization_information() {
        response = RestAssured.given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("user"))
                .when()
                .patch(fullPath);

        response.prettyPrint();
    }

    @When("The API user verifies that the content of the data field in the response body includes INSTALLMENT : {int}, {string},  {string}, {string}")
    public void theAPIUserVerifiesThatTheContentOfTheDataFieldInTheResponseBodyIncludesINSTALLMENT(
            int loan_id, String delay_charge, String installment_date, String given_at) {
        jsonPath = response.jsonPath();
        Assert.assertEquals(loan_id, jsonPath.getInt("data.loan_id"));
        //Assert.assertEquals(id, jsonPath.getInt("data.id"));
        Assert.assertEquals(delay_charge, jsonPath.getString("data.delay_charge"));
        Assert.assertEquals(installment_date, jsonPath.getString("data.installment_date"));
        Assert.assertEquals(given_at, jsonPath.getString("data.given_at"));
    }


    @When("The API user records the response POST with invalid authorization information, verifies that the status code is  and confirms that the error information is Unauthorized")
    public void theAPIUserRecordsTheResponsePOSTWithInvalidAuthorizationInformationVerifiesThatTheStatusCodeIsAndConfirmsThatTheErrorInformationIsUnauthorized
            () {
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
    public void verifyTheInformationOfTheOneWithInstallmentTheIdInTheAPIUserResponseBody(int dataIndex,
                                                                                         int loan_id, int id, String delay_charge, String installment_date) {

        jsonPath = response.jsonPath();
        Assert.assertEquals(loan_id, jsonPath.getInt("data.data[" + dataIndex + "].loan_id"));
        Assert.assertEquals(id, jsonPath.getInt("data.data[" + dataIndex + "].id"));
        Assert.assertEquals(delay_charge, jsonPath.getString("data.data[" + dataIndex + "].delay_charge"));
        Assert.assertEquals(installment_date, jsonPath.getString("data.data[" + dataIndex + "].installment_date"));
        Assert.assertNull(jsonPath.getString("data.data[" + dataIndex + "].given_at"));

    }


    @Then("Verify the information of the one with the id {int} in the API user response body: {int}, {string}, {string}, {string}, {string}, {int}, {int}, {string}, {string}, {string}")
    public void Verify_the_information_of_the_one_with_the_id_in_the_apı_user_response_body(int dataIndex,
                                                                                            int user_id, String name, String email, String ticket, String subject, int status, int priority, String
                                                                                                    last_reply, String created_at, String updated_at) {
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


    @Given("Verify the information of the one with the id {int} in the API user response body: {int}, {int}, {string},  {string}, {string}, {string},{string}, {string},{string}, {string}, {string}")
    public void verify_the_information_of_the_one_with_the_id_in_the_apı_user_response_body(int dataIndex, int id, int user_id, String amount, String charge, String post_balance, String trx_type, String trx, String details, String remark, String created_at, String updated_at) {
        jsonPath = response.jsonPath();
        Assert.assertEquals(id, jsonPath.getInt("data[" + dataIndex + "].id"));
        Assert.assertEquals(user_id, jsonPath.getInt("data[" + dataIndex + "].user_id"));
        Assert.assertEquals(amount, jsonPath.getString("data[" + dataIndex + "].amount"));
        Assert.assertEquals(charge, jsonPath.getString("data[" + dataIndex + "].charge"));
        Assert.assertEquals(post_balance, jsonPath.getString("data[" + dataIndex + "].post_balance"));
        Assert.assertEquals(trx_type, jsonPath.getString("data[" + dataIndex + "].trx_type"));
        Assert.assertEquals(trx, jsonPath.getString("data[" + dataIndex + "].trx"));
        Assert.assertEquals(details, jsonPath.getString("data[" + dataIndex + "].details"));
        Assert.assertEquals(remark, jsonPath.getString("data[" + dataIndex + "].remark"));
        Assert.assertEquals(created_at, jsonPath.getString("data[" + dataIndex + "].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data[" + dataIndex + "].updated_at"));


    }



    @Given("The API user prepares a POST request containing the correct data to send to the user categories add endpoint")
    public void the_apı_user_prepares_a_post_request_containing_the_correct_data_to_send_to_the_user_categories_add_endpoint() {
        requestBody = new JSONObject();
        requestBody.put("name", ConfigReader.getProperty("name"));
        requestBody.put("description", ConfigReader.getProperty("description"));

    }

    @Given("The API user prepares a POST request containing the invalid data to send to the user categories add endpoint")
    public void the_apı_user_prepares_a_post_request_containing_the_invalid_data_to_send_to_the_user_categories_add_endpoint() {
        requestBody = new JSONObject();

        requestBody.put("invalidName", ConfigReader.getProperty("invalidName"));
        requestBody.put("invalidDescription", ConfigReader.getProperty("invalidDescription"));

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

    @Given("The API user verifies that the message information in the response body is {string}")
    public void the_apı_user_verifies_that_the_message_information_in_the_response_body_is(String message) {
        response.then()
                .assertThat()
                .body("message", Matchers.equalTo(message));
    }

    @Given("The API user records the response with invalid authorization information, verifies that the status code is {string} and confirms that the error information is Unauthorized request")
    public void the_apı_user_records_the_response_with_invalid_authorization_information_verifies_that_the_status_code_is_and_confirms_that_the_error_information_is_unauthorized_request(String string) {
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

    @Given("The API user records the response from the PATCH api loanplans status endpoint with invalid authorization information verifies that the status code is {string} and confirms that the error information is Unauthorized")
    public void the_apı_user_records_the_response_from_the_patch_api_loanplans_status_endpoint_with_invalid_authorization_information_verifies_that_the_status_code_is_and_confirms_that_the_error_information_is_unauthorized(String string) {

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

    @Given("The API user saves the response from the loanplans delete endpoint with valid authorization information")
    public void the_apı_user_saves_the_response_from_the_loanplans_delete_endpoint_with_valid_authorization_information() {

        response = RestAssured.given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .delete(fullPath);

        response.prettyPrint();
    }

    @Given("API User verifies that the message information in the response body is {string}")
    public void apı_user_verifies_that_the_message_information_in_the_response_body_is(String message) {

        response.then()
                .assertThat()
                .body("data.message", Matchers.equalTo(message));

    }

    @Given("The API user saves the response from the loanplans delete endpoint with invalid authorization information and confirms that the status code is {string} and the error message is Unauthorized")
    public void the_apı_user_saves_the_response_from_the_loanplans_delete_endpoint_with_invalid_authorization_information_and_confirms_that_the_status_code_is_and_the_error_message_is_unauthorized(String string) {
        try {
            response = RestAssured.given()
                    .spec(spec)
                    .header("Accept", "application/json")
                    .headers("Authorization", "Bearer " + ConfigReader.getProperty("invalidToken"))
                    .when()
                    .delete(fullPath);
        } catch (Exception e) {
            mesaj = e.getMessage();
        }
        System.out.println("mesaj: " + mesaj);

        Assert.assertTrue(mesaj.contains("status code: 401, reason phrase: Unauthorized"));
    }

    @Given("The API user verifies that the status information in the response body is {int}")
    public void the_apı_user_verifies_that_the_status_information_in_the_response_body_is(int status) {

        jsonPath = response.jsonPath();

        Assert.assertEquals(status, jsonPath.getInt("data[0].status"));
    }
    @Given("The API user saves the response from the loans list endpoint with valid authorization information")
    public void the_apı_user_saves_the_response_from_the_loans_list_endpoint_with_valid_authorization_information() {
        response = RestAssured.given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();

    }
    @Then("Verify the information of the one with the id {int} in the API user response body: {int}, {int}, {string}, {string}, {string}, {string}, {int}, {int}, {string}, {string}, {string}")
    public void verify_the_information_of_the_one_with_the_id_in_the_apı_user_response_body(int dataIndex, int id, int user_id, String name, String email, String ticket, String subject, int status, int priority, String last_reply, String created_at, String updated_at) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(id, jsonPath.getInt("data[" + dataIndex + "].id"));
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

    @Given("The API user saves the response from the user loans aprove endpoint with valid authorization information")
    public void the_apı_user_saves_the_response_from_the_user_loans_aprove_endpoint_with_valid_authorization_information() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .patch(fullPath);

        response.prettyPrint();
    }

    @Given("The API user saves the response from the api loans aprove endpoint with invalid authorization information information and confirms that the status code is {string} and the error message is Unauthorized")
    public void the_apı_user_saves_the_response_from_the_api_loans_aprove_endpoint_with_invalid_authorization_information_information_and_confirms_that_the_status_code_is_and_the_error_message_is_unauthorized(String string) {
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

    @Given("The API user saves the response from the user api loans delete endpoint with valid authorization information")
    public void the_apı_user_saves_the_response_from_the_user_api_loans_delete_endpoint_with_valid_authorization_information() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .delete(fullPath);

        response.prettyPrint();
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


    @Then("Verify the information of the one with the idd {int} in the API user response body: {string}, {int}, {int}, {string}, {string}, {int}, {int}, {string}, {string}, {int}, {int}, {string}, {int}, {string}, {string}, {string}, {string}")
    public void VerifytheinformationoftheonewiththeiddintheAPIuserresponsebody(int dataIndex, String loan_number, int user_id, int plan_id, String amount, String per_installment, int installment_interval, int delay_value, String charge_per_installment, String delay_charge, int given_installment, int total_installment, String admin_feedback, int status, String due_notification_sent, String approved_at, String created_at, String updated_at) {
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

    @Then("The API user saves the response from the api categories status endpoint with invalid authorization information and verifies that the status code is '401' and the error message is Unauthorized")
    public void TheAPIUserSavesTheResponseFromTheApiCategoriesStatusEndpointWithInvalidAuthorizationInformationAndVerifiesThatTheStatusCodeIsAndTheErrorMessageIsUnauthorized() {
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


    @Given("Verify the information of the one with the id {int} in the API user response body: {string}, {int}, {int}, {string}, {string}, {int}, {int}, {string}, {string}, {int}, {string}, {int}, {string}, {string}")
    public void verify_the_information_of_the_one_with_the_id_in_the_apı_user_response_body(int dataIndex , String loan_number, int user_id, int plan_id, String amount , String per_installment, int installment_interval , int delay_value, String charge_per_installment, String delay_charge, int total_installment, String admin_feedback, int status,  String created_at, String updated_at) {

        jsonPath = response.jsonPath();

        Assert.assertEquals(loan_number, jsonPath.getString("data.data[" + dataIndex + "].loan_number"));
        Assert.assertEquals(user_id, jsonPath.getInt("data.data[" + dataIndex  + "].user_id"));
        Assert.assertEquals(plan_id, jsonPath.getInt("data.data[" + dataIndex  + "].plan_id"));
        Assert.assertEquals(amount, jsonPath.getString("data.data[" + dataIndex  + "].amount"));
        Assert.assertEquals(per_installment, jsonPath.getString("data.data[" + dataIndex  + "].per_installment"));
        Assert.assertEquals(installment_interval , jsonPath.getInt("data.data[" + dataIndex  + "].installment_interval "));
        Assert.assertEquals(delay_value, jsonPath.getInt("data.data[" + dataIndex  + "].delay_value"));
        Assert.assertEquals(charge_per_installment, jsonPath.getString("data.data[" + dataIndex  + "].charge_per_installment"));
        Assert.assertEquals(delay_charge, jsonPath.getString("data.data[" + dataIndex  + "].delay_charge"));
        Assert.assertEquals(total_installment, jsonPath.getInt("data.data[" + dataIndex  + "].total_installment"));
        Assert.assertEquals(admin_feedback, jsonPath.getString("data.data[" + dataIndex + "].admin_feedback"));
        Assert.assertEquals(status, jsonPath.getInt("data.data[" + dataIndex  + "].status"));
        Assert.assertNull( jsonPath.getString("data.data[" +dataIndex  + "].due_notification_sent"));
        Assert.assertNull(jsonPath.getString("data.data[" + dataIndex  + "].approved_at"));
        Assert.assertEquals(created_at, jsonPath.getString("data.data[" + dataIndex  + "].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data.data[" + dataIndex  + "].updated_at"));

        }
    @Then("The API user Verifies that the status information in the response body is {int}")
    public void Theapıuserverifiesthatthestatusinformationintheresponsebodyis(int status) {
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

    @Given("The API user saves the response from the api loans paid endpoint with valid authorization information")
    public void TheAPIusersavestheresponsefromtheapiloanspaidendpointwithvalidauthorizationinformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }

    @Given("Verify the information of the one with the {int} in the API user response body: {string}, {int}, {int}, {string}, {string}, {int}, {int}, {string}, {string}, {int}, {int}, {string}, {int}, {string}, {string}, {string}, {string}")
    public void Verifytheinformationoftheonewiththeintheapıuserresponsebody(int id, String loan_number, int user_id, int plan_id, String amount, String per_installment, int installment_interval, int delay_value, String charge_per_installment, String delay_charge, int given_installment, int total_installment, String admin_feedback, int status, String due_notification_sent, String approved_at, String created_at, String updated_at) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(id, jsonPath.getInt("data.id"));
        Assert.assertEquals(loan_number, jsonPath.getString("data.loan_number"));
        Assert.assertEquals(user_id, jsonPath.getInt("data.user_id"));
        Assert.assertEquals(plan_id, jsonPath.getInt("data.plan_id"));
        Assert.assertEquals(amount, jsonPath.getString("data.amount"));
        Assert.assertEquals(per_installment, jsonPath.getString("data.per_installment"));
        Assert.assertEquals(installment_interval, jsonPath.getInt("data.installment_interval"));
        Assert.assertEquals(delay_value, jsonPath.getInt("data.delay_value"));
        Assert.assertEquals(charge_per_installment, jsonPath.getString("data.charge_per_installment"));
        Assert.assertEquals(delay_charge, jsonPath.getString("data.delay_charge"));
        Assert.assertEquals(given_installment, jsonPath.getInt("data.given_installment"));
        Assert.assertEquals(total_installment, jsonPath.getInt("data.total_installment"));
        Assert.assertNull(admin_feedback, jsonPath.getString("admin_feedback"));
        Assert.assertEquals(status, jsonPath.getInt("data.status"));
        Assert.assertNull(due_notification_sent, jsonPath.getString("data.due_notification_sent"));
        Assert.assertNull(approved_at, jsonPath.getString("data.approved_at"));
        Assert.assertEquals(created_at, jsonPath.getString("data.created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data.updated_at"));

    }


@Given("Verify the information of the one with the id {int} in the API user api loans rejected response body: {int}, {string}, {int}, {int}, {string}, {string}, {int}, {int}, {string}, {string}, {int}, {int}, {string}, {int}, {string},{string}")
 public void verify_the_information_of_the_one_with_the_id_in_the_apı_user_api_loans_rejected_response_body(int dataIndex, int id, String loan_number, int user_id, int plan_id, String amount, String per_installment, int installment_interval, int delay_value, String charge_per_installment, String delay_charge, int given_installment, int total_installment, String admin_feedback,
int status, String created_at, String updated_at) {

    jsonPath = response.jsonPath();
    Assert.assertEquals(id, jsonPath.getInt("data.data[" + dataIndex + "].id"));
    Assert.assertEquals(loan_number, jsonPath.getString("data.data[" + dataIndex + "].loan_number"));
    Assert.assertEquals(user_id, jsonPath.getInt("data.data[" + dataIndex + "].user_id"));
    Assert.assertEquals(plan_id, jsonPath.getInt("data.data[" + dataIndex + "].plan_id"));
    Assert.assertEquals(amount, jsonPath.getString("data.data[" + dataIndex + "].amount"));
    Assert.assertEquals(per_installment, jsonPath.getString("data.data[" + dataIndex + "].per_installment"));
    Assert.assertEquals(installment_interval, jsonPath.getInt("data.data[" + dataIndex + "].installment_interval"));
    Assert.assertEquals(delay_value, jsonPath.getInt("data.data[" + dataIndex + "].delay_value"));
    Assert.assertEquals(charge_per_installment, jsonPath.getString("data.data[" + dataIndex + "].charge_per_installment"));
    Assert.assertEquals(delay_charge, jsonPath.getString("data.data[" + dataIndex + "].delay_charge"));
    Assert.assertEquals(given_installment, jsonPath.getInt("data.data[" + dataIndex + "].given_installment"));
    Assert.assertEquals(total_installment, jsonPath.getInt("data.data[" + dataIndex + "].total_installment"));
    Assert.assertEquals(admin_feedback, jsonPath.getString("data.data[" + dataIndex + "].admin_feedback"));
    Assert.assertEquals(status, jsonPath.getInt("data.data[" + dataIndex + "].status"));
    Assert.assertEquals(created_at, jsonPath.getString("data.data[" + dataIndex + "].created_at"));
    Assert.assertEquals(updated_at, jsonPath.getString("data.data[" + dataIndex + "].updated_at"));
    }


    @Given("Verify the information of the one with the id {int} in the API user api categories list response body: {int}, {string}, {string},  {int}, {string}, {string}")
    public void verify_the_information_of_the_one_with_the_id_in_the_apı_user_api_categories_list_response_body(int dataIndex, int id, String name, String description, int status, String created_at, String updated_at) {
        jsonPath = response.jsonPath();

        Assert.assertEquals(id, jsonPath.getInt("data[" + dataIndex + "].id"));
        Assert.assertEquals(name, jsonPath.getString("data[" + dataIndex + "].name"));
        Assert.assertEquals(description, jsonPath.getString("data[" + dataIndex + "].description"));
        Assert.assertEquals(status, jsonPath.getInt("data[" + dataIndex + "].status"));
        Assert.assertEquals(created_at, jsonPath.getString("data[" + dataIndex + "].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("data[" + dataIndex + "].updated_at"));
    }


    @Given("The API user saves the response from the api loans rejected endpoint with valid authorization information")
    public void The_apı_user_saves_the_response_from_the_api_loans_rejected_endpoint_with_valid_authorization_information() {
        response = RestAssured.given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .get(fullPath);
        response.prettyPrint();
    }



    @Given("The API user saves the response from the api endpoint with valid authorization information")
    public void the_apı_user_saves_the_response_from_the_api_endpoint_with_valid_authorization_information() {
        // ..
        response = RestAssured.given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .get(fullPath);
        response.prettyPrint();
    }
    @Given("Verify the information of the one with loanplans the id {int} in the API user response body:{int}, {int}, {int},  {string}, {string}, {string}, {string}, {string}")
    public void verify_the_information_of_the_one_with_loanplans_the_id_in_the_apı_user_response_body(int dataIndex, int id, int category_id, int form_id, String name, String title, String minimum_amount, String maximum_amount, String per_installment) {
        // []
        jsonPath = response.jsonPath();
        Assert.assertEquals(id, jsonPath.getInt("data[" + dataIndex + "].id"));
        Assert.assertEquals(category_id, jsonPath.getInt("data[" + dataIndex + "].category_id"));
        Assert.assertEquals(form_id, jsonPath.getInt("data[" + dataIndex + "].form_id"));
        Assert.assertEquals(name, jsonPath.getString("data[" + dataIndex + "].name"));
        Assert.assertEquals(title, jsonPath.getString("data[" + dataIndex + "].title"));
        Assert.assertEquals(minimum_amount, jsonPath.getString("data[" + dataIndex + "].minimum_amount"));
        Assert.assertEquals(maximum_amount, jsonPath.getString("data[" + dataIndex + "].maximum_amount"));
        Assert.assertEquals(per_installment, jsonPath.getString("data[" + dataIndex + "].per_installment"));
    }
    @Given("Verify the information of the one with tickets details the id  in the API user response body:{int}, {int}, {string},  {string}, {string}, {string}")
    public void verify_the_information_of_the_one_with_tickets_details_the_id_in_the_apı_user_response_body(int id, int user_id, String name, String email, String ticket, String subject) {
        // | id  | user_id | name  | email           | ticket    | subject   |
        jsonPath = response.jsonPath();
        Assert.assertEquals(id, jsonPath.getInt("data.id"));
        Assert.assertEquals(user_id, jsonPath.getInt("data.user_id"));
        Assert.assertEquals(name, jsonPath.getString("data.name"));
        Assert.assertEquals(email, jsonPath.getString("data.email"));
        Assert.assertEquals(ticket, jsonPath.getString("data.ticket"));
        Assert.assertEquals(subject, jsonPath.getString("data.subject"));
    }
    @Given("Verify the information of the one with deposit details the id  in the API user response body:{int}, {int}, {int},  {string}, {string}, {string}")
    public void verify_the_information_of_the_one_with_deposit_details_the_id_in_the_apı_user_response_body(int id, int user_id, int method_code, String amount, String method_currency, String charge) {
        //  | id  | user_id | method_code  | amount           | method_currency    | charge          |
        jsonPath = response.jsonPath();
        Assert.assertEquals(id, jsonPath.getInt("data.id"));
        Assert.assertEquals(user_id, jsonPath.getInt("data.user_id"));
        Assert.assertEquals(method_code, jsonPath.getInt("data.method_code"));
        Assert.assertEquals(amount, jsonPath.getString("data.amount"));
        Assert.assertEquals(method_currency, jsonPath.getString("data.method_currency"));
        Assert.assertEquals(charge, jsonPath.getString("data.charge"));
    }
    @Given("Verify the information of the one with loanplans details the id in the API user response body:{int}, {int}, {int},  {string}, {string}, {string}")
    public void verify_the_information_of_the_one_with_loanplans_details_the_id_in_the_apı_user_response_body(int id, int user_id, int method_code, String amount, String method_currency, String charge) {
        //  | id  | user_id | method_code  | amount        | method_currency | charge        |
        jsonPath = response.jsonPath();
        Assert.assertEquals(id, jsonPath.getInt("data.id"));
        Assert.assertEquals(user_id, jsonPath.getInt("data.user_id"));
        Assert.assertEquals(method_code, jsonPath.getInt("data.method_code"));
        Assert.assertEquals(amount, jsonPath.getString("data.amount"));
        Assert.assertEquals(method_currency, jsonPath.getString("data.method_currency"));
        Assert.assertEquals(charge, jsonPath.getString("data.charge"));

    }


    @Then("The API user saves the response from the admin loans details id  endpoint with valid authorization information")
    public void theAPIUserSavesTheResponseFromTheAdminLoansDetailsIdEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("admin"))
                .when()
                .get(fullPath);

        response.prettyPrint();
    }
    @And("The API user saves the response from the user ticket list endpoint with valid authorization information")
    public void theAPIUserSavesTheResponseFromTheUserTicketListEndpointWithValidAuthorizationInformation() {
        response = given()
                .spec(spec)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + Authentication.generateToken("user"))

                .when()
                .get(fullPath);

        response.prettyPrint();
    }

    @Then("The API user verifies that the content of the data field in the response body includes {int}, {string}, {int}, {int}, {string}, {string}, {int}, {int}, {string}, {string}, {int}, {int}, {string}, {string}, {int}, {string}, {string}, {string}, {string}")
    public void the_api_user_verifies_that_the_content_of_the_data_field_in_the_response_body_includes(int id, String loan_number, int user_id, int plan_id, String amount, String per_installment, int installment_interval, int delay_value, String charge_per_installment, String delay_charge, int given_installment, int total_installment, String application_form, String admin_feedback, int status, String due_notification_sent, String approved_at, String created_at, String updated_at) {
        jsonPath = response.jsonPath();

        assertEquals(id, jsonPath.getInt("data.id"));
        assertEquals(loan_number, jsonPath.getString("data.loan_number"));
        assertEquals(user_id, jsonPath.getInt("data.user_id"));
        assertEquals(plan_id, jsonPath.getInt("data.plan_id"));
        assertEquals(amount, jsonPath.getString("data.amount"));
        assertEquals(per_installment, jsonPath.getString("data.per_installment"));
        assertEquals(installment_interval, jsonPath.getInt("data.installment_interval"));
        assertEquals(delay_value, jsonPath.getInt("data.delay_value"));
        assertEquals(charge_per_installment, jsonPath.getString("data.charge_per_installment"));
        assertEquals(delay_charge, jsonPath.getString("data.delay_charge"));
        assertEquals(given_installment, jsonPath.getInt("data.given_installment"));
        assertEquals(total_installment, jsonPath.getInt("data.total_installment"));
        assertEquals(application_form, jsonPath.getString("data.application_form"));
        Assert.assertNull(admin_feedback, jsonPath.getString("data.admin_feedback"));
        assertEquals(status, jsonPath.getInt("data.status"));
        Assert.assertNull(due_notification_sent, jsonPath.getString("data.due_notification_sent"));
        assertEquals(approved_at, jsonPath.getString("data.approved_at"));
        assertEquals(created_at, jsonPath.getString("data.created_at"));
        assertEquals(updated_at, jsonPath.getString("data.updated_at"));



    }


}

