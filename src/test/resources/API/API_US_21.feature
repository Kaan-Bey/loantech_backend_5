@API21

Feature: API_US_21 As an administrator, I want to update the status information of existing loan plans via API connection.


  Scenario Outline: API_US_21_TC_01 When a PATCH body with valid authorization information and correct data (id) is
  sent to the api/loanplans/status/{{id}} endpoint, it is tested that the status code returned is 200 and
  the message in the response body is "Status changed".

    * The API user sets "api/loanplans/status/<id>" path parameters
    * The API user saves the response from the api loanplans status endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API User verifies that the message information in the response body is "Status changed"

    Examples:
      | id |
      | 52 |

  Scenario: API_US_21_TC_02 Api/Loanplans/Status/{{id}} When a passion of the Authorization information and
  a patch body that does not contain (id) is sent to the endpoint,
  Status Code is 203 and the Message information in Response Body is "No id".

    * The API user sets "api/loanplans/status" path parameters
    * The API user saves the response from the api loanplans status endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No id"


  Scenario Outline: API_US_21_TC_03 APİ/LoanPlans/Status/{{id}} When a patch Body that contains a patch body
  without registration information and a non -registration information is 203
  and the Message information in Response Body is "No Plan". .

    * The API user sets "api/loanplans/status/<id>" path parameters
    * The API user saves the response from the api loanplans status endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No plan"

    Examples:
      | id |
      | 300   |


  Scenario Outline: API_US_21_TC_04 When a PATCH body is sent to the api/loanplans/status/{{id}} endpoint
  with invalid authorization information, it is tested that   the status code returned is 401
  and the error information in the response body is "Unauthorized request".

    * The API user sets "api/loanplans/status/<id>" path parameters
    * The API user records the response from the PATCH api loanplans status endpoint with invalid authorization information verifies that the status code is '401' and confirms that the error information is Unauthorized


    Examples:
      | id |
      | 52 |


  Scenario Outline: API_US_21_TC_05 "It should be verified that the loanplans status
  record requested to be updated via API has been updated via API.
  (It can be verified that the record has been updated by sending a GET request
  to the api/loanplans/details/{{id}} endpoint with the Loan Plan id returned in the response body)."


    * The API user sets "api/loanplans/details/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the status information in the response body is <status>


    Examples:
      | id | status|
      | 55 | 1     |

