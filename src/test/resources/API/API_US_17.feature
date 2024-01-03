
@API17
Feature: API_US_017 As an administrator, access to loanplans list via API connection

  Scenario: API_US_017_TC_01 Test of sending a GET request with valid authorization information to the api/loanplans/list endpoint

    * The API user sets "api/loanplans/list" path parameters
    * The API user saves the response from the api endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"

  Scenario: API_US_017_TC_02 Sending a GET Request with invalid authorization information to the api/loanplans/list endpoint

    * The API user sets "api/loanplans/list" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

  Scenario Outline: API_US_017_TC_03 authorization valid to endpoint api/loanplans/details/159
                                      Sending a GET Request with information

    * The API user sets "api/loanplans/details/199" path parameters
    * The API user saves the response from the api endpoint with valid authorization information
    * Verify the information of the one with loanplans the id <dataIndex> in the API user response body:<id>, <category_id>, <form_id>,  "<name>", "<title>", "<minimum_amount>", "<maximum_amount>", "<per_installment>"
    Examples:
     | dataIndex | id  | category_id | form_id  | name | title | minimum_amount   | maximum_amount | per_installment |
     |      0    | 199 | 150         | 435      | omer | qa    | 2000.00000000    | 5000.00000000   | 4.00           |
