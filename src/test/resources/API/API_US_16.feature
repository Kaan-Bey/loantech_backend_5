Feature: API_US_16 As an administrator, I should be able to unregister categories in the system via the API connection.

  @API16
  Scenario Outline: API_US_16_TC_01 When a DELETE request is sent to the api/categories/delete/{{id}} endpoint with valid authorization
  information and the correct 'id', the status code returned should be 200 and the message in the response body should be validated as "category deleted". "

    * The API user sets "api/categories/delete/<id>" path parameters
    * The API user saves the response from the user category delete endpoint with valid authorization information
    # Api kullanicisi api categories delete id endpointinden donen response'i gecerli authorization bilgisi ile kaydeder
    * The API user verifies that the status code is 200
    # Api kullanicisi response bodydeki status code bilgisinin "200" oldugunu doğrular
    * The API User verifies that the message information in the response body is "category deleted"
    # Api kullanicisi response bodydeki mesaj bilgisinin "category deleted" oldugunu doğrular

    Examples:
      | id  |
      | 605 |


  @API16
  Scenario: API_US_16_TC_02 When a DELETE request is sent to the api/categories/delete/{{id}} endpoint without valid authorization
  information and id); The status code returned should be 203 and the message information in the response body should be "No id".

    * The API user sets "api/categories/delete" path parameters
    * The API user saves the response from the user category delete endpoint with valid authorization information
    # Api kullanicisi api categories list endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    * The API user verifies that the status code is 203
    # Api kullanicisi response bodydeki status code bilgisinin "203" oldugunu doğrular
    * The API User verifies that the message information in the response body is "No id"
    # Api kullanicisi response bodydeki mesaj bilgisinin "No id" oldugunu doğrular




  @API16
  Scenario: API_US_16_TC_03 When a DELETE request with valid authorization information and a non-existent 'id'
  is sent to the api/categories/delete/{{id}} endpoint,  the returned status code should be 203, and the message
  in the response body should be verified as "No category"

    * The API user sets "api/categories/delete/596" path parameters
    * The API user saves the response from the user category delete endpoint with valid authorization information
    # Api kullanicisi api categories list endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    * The API user verifies that the status code is 203
    # Api kullanicisi response bodydeki status code bilgisinin "203" oldugunu doğrular
    * The API User verifies that the message information in the response body is "No category"
    # Api kullanicisi response bodydeki mesaj bilgisinin "No category" oldugunu doğrular


  @API16
  Scenario Outline: API_US_16_TC_04 When a DELETE request is sent to the api/categories/delete/{{id}} endpoint with valid authorization
  information and a non-existent 'id', the returned status code should be 203 and the error information in the
  response body should verify as: "Unauthorized request"

    * The API user sets "api/categories/delete/<id>" path parameters
    * The API user saves the response from the api categories delete endpoint with invalid authorization information
    # Api kullanicisi user ticket delete endpointinden donen responsei geçersiz authorization bilgisi ile kaydeder,
    * The API user verifies that the status code is 401
    # status codeun 401 ve error bilgisinin Unauthorized oldugunu dogrular
    * The Api User verifies that the error message informatiion in the response body is "Unauthorized request"

    Examples:
      | id  |
      | 606 |
