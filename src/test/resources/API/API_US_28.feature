Feature: API_US_28 As an administrator, I want to access the list of tickets via API connection.


  @API
  Scenario: api/tickets/list' endpoint, it should be verified that the returned status code is 200,
  and the remark information in the response indicates "success"

    * The API user sets "api/tickets/list" path parameters
    * The API user saves the response from the api ticket list endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"


  Scenario: api/tickets/list' endpoint, it should return a status code of 401,
  and the response error message should be "Unauthorized request"

    * The API user sets "api/tickets/list" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized


  Scenario Outline: Verify the information (user_id, name, email, ticket, subject,
  status, priority, last_reply, created_at, updated_at) returned in the response for Id(x)

    * The API user sets "api/tickets/details/<id>" path parameters
    * The API user saves the response from the api ticket list endpoint with valid authorization information
    * Verify the information of the one with the <id> in the API user response body: <user_id>, "<name>", "<email>", "<ticket>", "<subject>", <status>, <priority>, "<last_reply>", "<created_at>", "<updated_at>"

    Examples:
      | id  | user_id | name       | email               | ticket | subject    | status | priority | last_reply          | created_at                  | updated_at                  |
      | 410 | 46      | kaan karan | kaankaran@gmail.com | 682099 | kaan karan | 0      | 3        | 2023-12-31 11:53:39 | 2023-12-31T16:53:39.000000Z | 2023-12-31T16:53:39.000000Z |