@API11

Feature: API_US_11 As an administrator (admin), I want to be able to access the categories list via API connection.

  Scenario: API_US_11_TC_01 When a valid GET request is sent to the 'api/categories/list' endpoint with the appropriate
  authorization credentials, it should return a status code of 200, and the response remark should be "success"

    * The API user sets "api/categories/list" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"


  Scenario: API_US_11_TC_02  When a GET Request is sent to the api/categories/list endpoint with invalid authorization information,
  it should be verified that the status code returned is 401 and the response error information is "Unauthorized request"

    * The API user sets "api/categories/list" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized


  Scenario Outline: API_US_11_TC_03 Refund the return information of the id (x) in the response (name, image, description, status, created_at, updated_at)

    * The API user sets "api/categories/list" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * Verify the information of the one with the id <dataIndex> in the API user api categories list response body: <id>, "<name>", "<description>",  <status>, "<created_at>", "<updated_at>"

    Examples:
      | dataIndex | id  | name           | description                    | status | created_at                  | updated_at                  |
      | 0         | 621 | Test Category1 | New category for test purposes | 1      | 2023-12-29T10:40:02.000000Z | 2023-12-29T10:40:02.000000Z |


