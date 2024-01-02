Feature: API_US_15 As an administrator, I want to update the status information of existing categories via API connection.


  @API
  Scenario Outline: api/categories/status/{{id}} endpoint, the returned status code should be 200,
  and the message in the response body should be verified as "Status changed"

    * The API user sets "api/categories/status/<id>" path parameters
    * The API user saves the response from the api categories status endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API User verifies that the message information in the response body is "Status changed"

    Examples:
      | id |
      | 23 |


  Scenario: api/categories/status/{{id}} endpoint, the returned status code should be 203,
  and the message in the response body should be verified as "No id"

    * The API user sets "api/categories/status" path parameters
    * The API user saves the response from the api categories status endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No id"


  Scenario Outline: api/categories/status/{{id}} endpoint, the returned status code should be 203,
  and the message in the response body should be verified as "No category"

    * The API user sets "api/categories/status/<id>" path parameters
    * The API user saves the response from the api categories status endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No category"

    Examples:
      | id  |
      | 12356 |


  Scenario Outline: api/categories/status/{{id}} endpoint, the returned status code should be 401,
  and the error message in the response body should be verified as "Unauthorized request"

    * The API user sets "api/categories/status/<id>" path parameters
    * The API user saves the response from the api categories status endpoint with invalid authorization information and verifies that the status code is '401' and the error message is Unauthorized

    Examples:
      | id  |
      | 123 |


  Scenario Outline: The update of the desired category status record through the API should be verified.
  This can be confirmed by sending a GET request to the api/categories/details/{{id}}
  endpoint with the Status Updated id returned in the response body to ensure that the status record has been successfully updated

    * The API user sets "api/categories/details/<id>" path parameters
    * The API user saves the response from the api categories details endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user Verifies that the status information in the response body is <status>

    Examples:
      | id | status |
      | 23 | 0      |