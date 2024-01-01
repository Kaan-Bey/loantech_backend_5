Feature: API_US_25 As an administrator, I want to be able to create a new subscriber record via
  API connection.

  @sad
  Scenario: API_US_25_TC_01 API/Subscriber/ADD ENDPoint Visue Authorization information and a post
  body that includes the right data (email) is that Status Code is 200 and the remark information
  in Response Body is "Success".

    *  The API user sets "api/subscriber/add" path parameters
    * The API user prepares a POST request containing the correct data to send to the user subscriber add endpoint
    * The API user saves the response from the api subscriber add endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"

  @sad
  Scenario: API_US_25_TC_02 When a post body contains a post body containing a post body containing
  an Authorization information and wrong data (mail) to APİ/Subscriber/Add Endpoint,it should be
  accurate that the remark information in Response Body is "failed"

    *  The API user sets "api/subscriber/add" path parameters
    * The API user prepares a POST request containing invalid data to send to the user subscriber add endpoint
    * The API user saves the response from the api subscriber add endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API user verifies that the remark information in the response body is "failed"

  @sad
  Scenario: API_US_25_TC_03 Api/Subscriber/Add Endpoint Visue Authorization information and a post
  body that does not contain data (email) is returned to Status Code 203 and the Remark
  information in Response Body is "failed".

    *  The API user sets "api/subscriber/add" path parameters
    * The API user prepares a POST request containing invalid data to send to the user subscriber add endpoint
    * The API user saves the response from the api subscriber add endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API user verifies that the remark information in the response body is "failed"

  @sad
  Scenario: API_US_25_TC_04 When a post body (email) was sent to API/Subscriber/Add Endpoint with
  an Authorization information, it should be correct that Status Code is 401 and the error
  information in Response Body is "Ununauthorized Request"

    *  The API user sets "api/subscriber/add" path parameters
    * The API user prepares a POST request containing the correct data to send to the user subscriber add endpoint

    * The API user records the response POST with invalid authorization information, verifies that the status code is  and confirms that the error information is Unauthorized

  @sad
  Scenario Outline: API_US_25_TC_05 "The new subscriber recording to be formed on the API should be confirmed over the formation of the API.
  (API/subscriber/deTails/{{{id}} Endpoint with APİ/subscriber ID returning in Response Body can be confirmed by sending a record to the endpoint)."

    *  The API user sets "api/subscriber/details/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    Examples:
      | id |
      | 83 |
