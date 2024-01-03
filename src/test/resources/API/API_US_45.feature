@API45
  Feature: API_US_045 Testing access to pending deposit via API connection

    Scenario: API_US_045_TC_01 Test to verify that when a GET request is sent to the api/deposit/pending endpoint
                                with valid authorization information, the status code returned is 200
                                and the response remark information is "success"

      * The API user sets "api/deposit/pending" path parameters
      * The API user saves the response from the api endpoint with valid authorization information
      * The API user verifies that the status code is 200
      * The API user verifies that the remark information in the response body is "success"

    Scenario: API_US_045_TC_02 Test to verify that when a GET Request is sent to the api/deposit/pending endpoint
                                with invalid authorization information, the status code returned is 401
                                and the response error information is "Unauthorized request"

      * The API user sets "api/deposit/pending" path parameters
      * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

      Scenario Outline: API_US_045_TC_03 Send a GET Request with valid authorization information to the
                                  api/deposit/Id endpoint and verify the information returned in the Response.

        * The API user sets "api/deposit/details/662" path parameters
        * The API user saves the response from the api endpoint with valid authorization information
        * Verify the information of the one with loanplans details the id in the API user response body:<id>, <user_id>, <method_code>,  "<amount>", "<method_currency>", "<charge>"

        Examples:
          | id  | user_id | method_code  | amount        | method_currency | charge        |
          | 662 | 19      | 1000         | 5000.00000000 | USD             | 200.00000000  |





