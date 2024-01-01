Feature: API_US_31 As an administrator, I want to access the tickets that are in the 'closed' status via API connection.

  @API31
  Scenario: API_US_31_TC_01 When a GET request is sent to the 'api/tickets/closed' endpoint with valid authorization,
  verify that the status code returned is 200 and the description in the response is "success".

    * The API user sets "api/tickets/closed" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    # Api kullanicisi api categories list endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"
    #Api kullanicisi response bodydeki remark bilgisinin "success" oldugunu doğrular

  @API31
  Scenario: API_US_31_TC_02 When an invalid GET request is sent to the 'api/tickets/closed' endpoint, the error code returned is 401
  and the response error message should be verified as "Unauthorized request".

    * The API user sets "api/ticket/closed" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized Requist
    # Api kullanicisi user ticket close endpointinden donen responsei geçersiz authorization bilgisi ile kaydeder, status codeun 401 ve error bilgisinin Unauthorized oldugunu dogrular



  @API31
  Scenario Outline: API_US_31_TC_03 Verify the information (user_id, name, email, ticket, subject, status, priority, last_reply, created_at, updated_at)
  returned in the id(x) response

    * The API user sets "api/ticket/closed" path parameters
    * The API user saves the response from the api ticket list endpoint with valid authorization information
    * The API user verifies that the content of the data field in the response body includes <id>, <user_id>, "<name>", "<email>", "<ticket>", "<subject>", <status>, <priority>, "<last_reply>", "<created_at>", "<updated_at>"
    #API kullanicisi response bodydeki data <id>, <user_id>, "<name>", "<email>", "<ticket>", "<subject>", <status>, <priority>, "<last_reply>", "<created_at>", "<updated_at>" içeriklerini doğrular
    * Verify the information of the one with the id <dataIndex> in the API user response body: <id>, <user_id>, "<name>", "<email>", "<ticket>","<subject>", <status>, <priority>, "<last_reply>", "<created_at>", "<updated_at>"

    Examples:
      | dataIndex | id  | user_id | name        | email               | ticket   | subject   | status |priority | last_reply          | created_at                  | updated_at                  |
      | 0         | 437 | 10      | Ahmet Kaya  | ahmetkaya@gmail.com | 305500   | AhmetKaya | 3      | 0       | 2023-12-31 12:49:42 | 2023-12-31T17:49:42.000000Z | 2023-12-31T17:49:43.000000Z |



  # Examples:
  #   | id  | user_id | name        | email                   | ticket | subject     | status | priority | last_reply          | created_at                  | updated_at                  |
  #   | 437 | 10      | Ahmet Kaya  | ahmetkaya@gmail.com     | 305500 | AhmetKaya   | 3      | 0        | 2023-12-31 12:49:42 | 2023-12-31T17:49:42.000000Z | 2023-12-31T17:49:43.000000Z |


