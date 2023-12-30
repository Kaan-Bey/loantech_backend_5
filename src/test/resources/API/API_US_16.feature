Feature: API_US_16
  @API
  Scenario: API_US_16_TC_01


    * The API user sets "api/categories/list" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    #Api kullanicisi api categories list endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"
    #Api kullanicisi response bodydeki remark bilgisinin "success" oldugunu doğrular


  Scenario Outline :

    * The API user sets "api/categories/delete/<id>" path parameters
   *  The API user saves the response from the api categories list endpoint with valid authorization information
    #Api kullanicisi user ticket delete endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
  * The API user verifies that the status code is 200
  * The API User verifies that the message information in the response body is "success"

    Examples:
      | id  |
      | 576 |
