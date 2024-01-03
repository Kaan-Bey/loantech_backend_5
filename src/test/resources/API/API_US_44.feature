@API44
Feature: API_US_044 Testing access to deposit list via API connection

  Scenario: API_US_044_TC_01 A GET request with valid authorization information is
                                sent to the api/deposit/list endpoint
    * The API user sets "api/deposit/list" path parameters
    * The API user saves the response from the api endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"

    Scenario: API_US_044_TC_02 A GET Request is sent to the api/deposit/list
                                  endpoint with invalid authorization information

      * The API user sets "api/deposit/list" path parameters
      * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

      Scenario Outline: API_US_044_TC_03 Test to verify the information returned in Response with ID 654
        * The API user sets "api/deposit/details/654" path parameters
        * The API user saves the response from the api endpoint with valid authorization information
        * Verify the information of the one with deposit details the id  in the API user response body:<id>, <user_id>, <method_code>,  "<amount>", "<method_currency>", "<charge>"

        Examples:
          | id  | user_id | method_code  | amount           | method_currency    | charge          |
          | 654 | 15      | 1003         | 800.00000000     | USD                |9.00000000       |
