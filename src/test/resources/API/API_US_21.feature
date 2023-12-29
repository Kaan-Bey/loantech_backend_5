Feature: API_US_21 As an administrator, I want to update the status information of existing loan plans via API connection.

@API21
  Scenario Outline: API_US_21_TC_01 Api/Categories/Update/id Endpoint'te validated authorization information with
  the right (id) and correct data (name) that includes a post body that returned to the status Code 200 and the Message information
  in the Response Body "Category Updated" Category Updated Successfully "should be accurate

    * The API user sets "api/loanplans/status/{{id}}" path parameters
    * The API user verifies that the status code is 200
    * The API User verifies that the message information in the response body is "status chaged"

  Examples:
  | id  |
  | 9  |