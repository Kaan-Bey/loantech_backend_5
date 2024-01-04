Feature:  API_US_25 As an administrator (admin) I want to be able to access
  tickets pending via API connection

  @sad
  Scenario: API_US_30_TC_01 Verification test that when a GET request is sent to the
  api/tickets/pending endpoint with valid authorisation information, the status code returned
  is 200 and the response remark is "success"

    *  The API user sets "api/tickets/pending" path parameters
    * The API user saves the response from the api Tickets endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"


  @sad
  Scenario: API_US_30_TC_02  Verification test that when a GET Request is sent to
  the api/tickets/pending endpoint with invalid authorisation information, the status code
  returned is 401 and the response error information is "Unauthorised request"
    *  The API user sets "api/tickets/pending" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

  @sad
  Scenario Outline: API_US_30_TC_03 validation test Id(x) whose Response also returns information
  (user_id, name, email, ticket, ticket, subject, status, priority, last_reply, created_at,
  updated_at)
    * The API user sets "api/tickets/details/<id>" path parameters
    * The API user saves the response from the api Tickets endpoint with valid authorization information
    * The API user verifies that the content of the data field in the response body includes <id>, <user_id>, "<name>", "<email>", "<ticket>", "<subject>", <status>, <priority>, "<last_reply>", "<created_at>", "<updated_at>"

    Examples:
      | id  | user_id | name        | email                | ticket | subject   | status | priority | last_reply          | created_at                  | updated_at                  |
      | 345 | 70      | sadik goden | sadikgoden@gmail.com | 975520 | sadaseffe | 0      | 3        | 2023-12-30 18:02:55 | 2023-12-30T23:02:55.000000Z | 2023-12-30T23:02:55.000000Z |





