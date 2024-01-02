Feature: As an administrator, I want to create a new category record via API connection.

  Scenario: API_US_13_TC01 When a POST request with valid authorization information and correct data (name, description) is sent to the api/categories/add endpoint, the returned status code should be 200, and the remark in the response body should be verified as "success"

      * The API user sets "api/categories/add" path parameters
      * The API user prepares a POST request containing the correct data to send to the user categories add endpoint
      * The API user saves the response from the api subscriber details endpoint with valid authorization information
      * The API user verifies that the status code is 200
      * The API user verifies that the remark information in the response body is "success"

  Scenario: API_US_13_TC02 When a POST request with valid authorization information and no data (name, description) is sent to the api/categories/add endpoint, the returned status code should be 203, and the remark in the response body should be verified as "failed"

    * The API user sets "api/categories/add" path parameters
    * The API user prepares a POST request containing the invalid data to send to the user categories add endpoint
    * The API user saves the response from the api subscriber details endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API user verifies that the remark information in the response body is "failed"


  Scenario: API_US_13_TC03 When a POST (name, description) request with valid authorization information and incomplete missing data (description) is sent to the api/categories/add endpoint, the returned status code should be 203, and the remark in the response body should be verified as "failed"

    * The API user sets "api/categories/add" path parameters
    * The API user prepares a POST request containing the invalid data to send to the user categories add endpoint
    * The API user saves the response from the api subscriber details endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API user verifies that the remark information in the response body is "failed"


  Scenario: API_US_13_TC04When a POST request with invalid authorization information and a POST body (name, description) is sent to the api/categories/add endpoint, the returned status code should be 401, and the error message in the response body should be verified as 'Unauthorized request'

    * The API user sets "api/categories/add" path parameters
    * The API user prepares a POST request containing the correct data to send to the user categories add endpoint
    * The API user records the response POST with invalid authorization information, verifies that the status code is  and confirms that the error information is Unauthorized


  Scenario Outline: API_US_13_TC05 The creation of a new category record through the API should be verified. This can be confirmed by sending a GET request to the api/categories/details/{{id}} endpoint with the Added category id returned in the response body

    * The API user sets "api/categories/details/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    Examples:
      | id |
      | 621 |