
Feature:API_US_12 As an administrator, I want to be able to access the categories details
  information of the user whose id is given via API connection.

  @sad
  Scenario Outline: API_US_12_TC_01 When a GET request with valid authorisation information and correct
  data (id) is sent to the api/categories/details/{{id}} endpoint, it should be verified that
  the status code returned is 200 and the response remark is "success"

    * The API user sets "api/categories/details/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"

    Examples:
      | id  |
      | 602 |

  @sad
  Scenario:  API_US_12_TC_02 Api/Categories/Details/{{id}} Endpoint'e valid Authorization information
  and (id) when a get request is  sent to the status Code 203 and Response Message
  information should be correct.

    * The API user sets "api/categories/details" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    *  The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No id"

  @sad
  Scenario Outline:  API_US_12_TC_03  Api/Categories/Details/{{id}} When a ghetDiest contains an unreasonable
  Authorization information and a non -registration information,
  the status code is 203 and the Response Message information is "No Category".

    * The API user sets "api/categories/details/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    *  The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No category"
    Examples:
      | id  |
      | 951 |

  @sad
  Scenario Outline:  API_US_12_TC_04 APİ/Categories/Details/{{id}} When a get request was sent to Endpoint
  with Authorization information, Status Code is 401 and the Error information in Response
  Body is "UNUNUTHORIZED REQUEST".

    * The API user sets "api/categories/details/<id>" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized
    Examples:
      | id  |
      | 542 |

  @sad
  Scenario Outline:  API_US_12_TC_05 The contents of the data (id, name, image, description, status,
  created_at, updated_at) in Response Body should be verified.

    * The API user sets "api/categories/details/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * Verify the information of the one with the id <dataIndex> in the API user response body: <id>, "<name>", "<description>",  <status>, "<created_at>", "<updated_at>"

    Examples:
      | dataIndex | id  | name        | description     | status | created_at                  | updated_at                  |
      | 0         | 602 | sadiksadece | sadecesaddeceu. | 1      | 2023-12-31T13:10:21.000000Z | 2023-12-31T13:10:21.000000Z |





