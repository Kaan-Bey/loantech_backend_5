Feature: API_US_16 As an administrator, I should be able to unregister categories in the system via the API connection.

  @API
  Scenario Outline: API_US_16_TC_01 When a DELETE request is sent to the api/categories/delete/{{id}} endpoint with valid authorization information and the correct 'id',
  the status code returned should be 200 and the message in the response body should be validated as "category deleted". "


    * The API user sets "api/categories/delete/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    #Api kullanicisi api categories list endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "category deleted"
    #Api kullanicisi response bodydeki remark bilgisinin "success" oldugunu doğrular

    Examples:
      | id  |
      | 590 |


  @API

  Scenario: API_US_16_TC_02 When a DELETE request is sent to the api/categories/delete/{{id}} endpoint without valid authorization information and
  (id); The status code returned should be 203 and the message information in the response body should be "No id".




