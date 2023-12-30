Feature: API_US_21 As an administrator, I want to update the status information of existing loan plans via API connection.

  @API21
  Scenario Outline: API_US_21_TC_01 When a PATCH body with valid authorization information and correct data (id) is
  sent to the api/loanplans/status/{{id}} endpoint, it is tested that the status code returned is 200 and
  the message in the response body is "Status changed".



    * The API user sets "api/loanplans/status/<id>" path parameters
    * A patch body that contains the right data (id) is sent.
    * The API user verifies that the status code is 200
    * The API User verifies that the message information in the response body is "status chaged"

    Examples:
      | id |
      | 13 |

