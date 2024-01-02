
@API29

Feature: API_US_29 As an administrator, I want to access the ticket information of a user with a specified ID via API connection.


  Scenario Outline: API_US_29_TC_01 When a valid GET request with appropriate authorization credentials and
  correct data (id) is sent to the 'api/tickets/details/{{id}}' endpoint, it should return a status code of 200,
  and the response remark should be "success"


    * The API user sets "api/tickets/details/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"


    Examples:
      | id |
      | 410 |

  Scenario Outline: API_US_29_TC_02 When a GET request with valid authorization credentials and
  without the required data (id) is sent to the 'api/tickets/details/{{id}}' endpoint,
  it should return a status code of 203, and the response message should be "No id"

    * The API user sets "api/tickets/details/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No id"

    Examples:
      | id  |
      | 0 |

  Scenario Outline: API_US_29_TC_03 When a GET request with valid authorization credentials and
  an (id) that does not correspond to an existing record is sent to the 'api/tickets/details/{{id}}' endpoint,
  it should return a status code of 203, and the response message should be "No ticket."

    * The API user sets "api/tickets/details/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No ticket."

    Examples:
      | id  |
      | 500 |


  Scenario Outline: API_US_29_TC_04 When an invalid GET request with unauthorized credentials is
  sent to the 'api/tickets/details/{{id}}' endpoint, it should return a status code of 401,
  and the error message in the response body should be "Unauthorized request".

    * The API user sets "api/tickets/details/<id>" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized


    Examples:
      | id |
      |    |

  Scenario Outline: API_US_29_TC_05 Verify the contents of the data (id, user_id, name, email,
  ticket, subject, status, priority, last_reply, created_at, updated_at) in the response body

    * The API user sets "api/tickets/details/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * Verify the information of the one with the <id> in the API user api tickets details response body: <user_id>, "<name>", "<email>", "<ticket>", "<subject>", <status>, <priority>, "<last_reply>", "<created_at>", "<updated_at>"
  #API kullanıcı response body icindeki <dataIndex> indexe sahip olanın bilgilerini doğrular: <user_id>, "<name>", "<email>", "<ticket>", "<subject>", <status>, <priority>, "<last_reply>", "<created_at>", "<updated_at>"

    Examples:
      | id  | user_id | name       | email               | ticket | subject    | status | priority | last_reply          | created_at                  | updated_at                  |
      | 410 | 46      | kaan karan | kaankaran@gmail.com | 682099 | kaan karan | 0      | 3        | 2023-12-31 11:53:39 | 2023-12-31T16:53:39.000000Z | 2023-12-31T16:53:39.000000Z |




