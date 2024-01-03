@API32
Feature: API_US_032 tickets answered access test

  Scenario: API_US_032_TC_01 Test a GET request
            with valid authorization information to the api/tickets/answered endpoint

    * The API user sets "api/tickets/answered" path parameters
    * The API user saves the response from the api endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"

    Scenario: API_US_032_TC_02 Testing sending a GET Request
              with invalid authorization information to the api/tickets/answered endpoint

      * The API user sets "api/tickets/answered" path parameters
      * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

      Scenario Outline: API_US_032_TC_03 api/tickets/details/2 A GET request is sent
                        with valid authorization information and the information returned in the response is tested

        * The API user sets "api/tickets/details/2" path parameters
        * The API user saves the response from the api endpoint with valid authorization information
        * Verify the information of the one with tickets details the id  in the API user response body:<id>, <user_id>, "<name>",  "<email>", "<ticket>", "<subject>"
        Examples:
          | id  | user_id | name  | email           | ticket    | subject   |
          | 2   | 1       | Elf F | agenc@gmail.com | 187898    |Test       |

