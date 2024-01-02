Feature: API_US_09 As a user, I want to access the user list transactions through API connection.
  Scenario: API_US_09_TC01 As a user, I want to access the user list transactions through API connection.

    * The API user sets "user/list/transaction" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"


  Scenario:API_US_09_TC02 When a GET Request is sent to the api/categories/transaction endpoint with invalid authorization information,
  it should be verified that the status code returned is 401 and the response error information is "Unauthorized request"

    * The API user sets "user/list/transaction" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized


  Scenario Outline:API_US_09_TC03 Verify the information returned in the response for the entity with id(x) (user_id, amount, charge, post_balance, trx_type, trx, details, remark, created_at, updated_at)

    * The API user sets "user/list/transaction" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * Verify the information of the one with the id <dataIndex> in the API user response body: <id>, <user_id>, "<amount>",  "<charge>", "<post_balance>", "<trx_type>","<trx>", "<details>","<remark>", "<created_at>", "<updated_at>"

    Examples:
      | dataIndex | id  |user_id      |amount           |charge     |post_balance  |trx_type|trx          |details                                          |remark         |created_at                 |updated_at|
      | 0         | 929 | 43          | 24946.00000000  | 0.00000000|8586.89000000 |-       |S8CCCN8NC572 |$24,846.00 Charged for application fee Test Loan |application_fee|2023-12-21T17:39:31.000000Z|2023-12-21T17:39:31.000000Z|