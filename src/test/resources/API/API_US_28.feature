Feature: API_US_28 As an administrator, I want to access the list of tickets via API connection.

  @API
  Scenario: api/tickets/list' endpoint, it should be verified that the returned status code is 200, and the remark information in the response indicates "success"

    * The API user sets "api/tickets/list" path parameters
    * The API user saves the response from the api ticket list endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"

  Scenario: api/tickets/list' endpoint, it should return a status code of 401, and the response error message should be "Unauthorized request"

    * The API user sets "api/tickets/list" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized
    
  Scenario Outline: Verify the information (user_id, name, email, ticket, subject, status, priority, last_reply, created_at, updated_at) returned in the response for Id(x)

    * The API user sets "api/tickets/list" path parameters
    * The API user saves the response from the api ticket list endpoint with valid authorization information
    * Verify the information of the one with the id <dataIndex> in the API user response body: <user_id>, "<name>", "<email>", "<ticket>", "<subject>", <status>, <priority>, "<last_reply>", "<created_at>", "<updated_at>"
   
    Examples:
      | dataIndex | user_id | name  | email           | ticket | subject | status | priority | last_reply          | created_at                  | updated_at                  |
      | 0         | 1       | Elf F | agenc@gmail.com | 187898 | Test    | 3      | 3        | 2023-11-02 11:16:58 | 2023-10-16T10:08:01.000000Z | 2023-12-29T13:50:10.000000Z |

