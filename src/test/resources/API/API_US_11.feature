Feature: API_US_11 As an administrator (admin), I want to be able to access the categories list via API connection.
  @API
Scenario: API_US_11_TC_01 When a valid GET request is sent to the 'api/categories/list' endpoint with the appropriate
authorization credentials, it should return a status code of 200, and the response remark should be "success"

* The API user sets "api/categories/list" path parameters
* The API user saves the response from the api categories list endpoint with valid authorization information
    #Api kullanicisi api categories list endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
* The API user verifies that the status code is 200
* The API user verifies that the remark information in the response body is "success"
    #Api kullanicisi response bodydeki remark bilgisinin "success" oldugunu doğrular


