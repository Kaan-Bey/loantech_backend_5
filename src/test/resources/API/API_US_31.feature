Feature: API_US_31

  @API
  Scenario: API_US_31_TC_01 When a GET request is sent to the 'api/tickets/closed' endpoint with valid authorization,
  verify that the status code returned is 200 and the description in the response is "success".

    * The API user sets "api/tickets/closed" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    #Api kullanicisi api categories list endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"
    #Api kullanicisi response bodydeki remark bilgisinin "success" oldugunu doğrular

  @API
  Scenario: API_US_31_TC_02 When an invalid GET request is sent to the 'api/tickets/closed' endpoint, the error code returned is 401
  and the response error message should be verified as "Unauthorized request".
    * The API user sets "api/ticket/closed" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized Requist
    # Api kullanicisi user ticket close endpointinden donen responsei geçersiz authorization bilgisi ile kaydeder, status codeun 401 ve error bilgisinin Unauthorized oldugunu dogrular


