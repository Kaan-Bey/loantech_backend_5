Feature: API_US_41 As an administrator, I want to be able to approve the loan information of a user with a given
         ID through the API connection.

  @API41
  Scenario Outline: API_US_41_TC_01 When valid authorization information and correct data (id) is sent with a PATCH request to
  the api/loans/approve/{{id}} endpoint, it should be verified that the status code returned is 200 and the message in
  the response body is "Loan approved successfully".
    
    * The API user sets "api/loans/approve/<id>" path parameters
    * The API user saves the response from the user loans aprove endpoint with valid authorization information
    * The API user verifies that the status code is 200
    # Api kullanicisi response bodydeki status code bilgisinin "200" oldugunu doğrular
    * The API User verifies that the message information in the response body is "Loan approved successfully"
    # Api kullanicisi response bodydeki mesaj bilgisinin "Loan approved successfully" oldugunu doğrular

    Examples:
      | id  |
      | 221|



  @API41
  Scenario Outline: API_US_41_TC_02 When a PATCH request containing valid authorization information and a pre-approved (id) is sent to
  the 'api/loans/approve/{{id}}' endpoint, the status code returned is 203 and the message information in the response is
  "No loan or loan status is not pending." must be verified.

    * The API user sets "api/loans/approve/<id>" path parameters
    * The API user saves the response from the user loans aprove endpoint with valid authorization information
    * The API user verifies that the status code is 203
    # Api kullanicisi response bodydeki status code bilgisinin "203" oldugunu doğrular
    * The API User verifies that the message information in the response body is "No loan or loan status is not pending."
    # Api kullanicisi response bodydeki mesaj bilgisinin "No loan or loan status is not pending." oldugunu doğrular

    Examples:
      | id  |
      | 222 |



  @API41
  Scenario: API_US_41_TC_03 When a PATCH body is sent to the api/loans/approve/{{id}} endpoint without valid authorization information
  and (id), it must be verified that the status code returned is 203 and the message in the response body is "No id".

    * The API user sets "api/loans/approve" path parameters
    * The API user saves the response from the user loans aprove endpoint with valid authorization information
    * The API user verifies that the status code is 203
    # Api kullanicisi response bodydeki status code bilgisinin "203" oldugunu doğrular
    * The API User verifies that the message information in the response body is "No id"
    # Api kullanicisi response bodydeki mesaj bilgisinin "No id" oldugunu doğrular


  @API41
  Scenario Outline: API_US_41_TC_04 When a PATCH body containing valid authorization information and an unregistered (id) is sent to
  the 'api/loans/approve/{{id}}' endpoint, the expected status code is 203 and the message information in the response text
  is "No loan." should be verified as .

    * The API user sets "api/loans/approve/<id>" path parameters
    * The API user saves the response from the user loans aprove endpoint with valid authorization information
    * The API user verifies that the status code is 203
    # Api kullanicisi response bodydeki status code bilgisinin "203" oldugunu doğrular
    * The API User verifies that the message information in the response body is "No loan."
    # Api kullanicisi response bodydeki mesaj bilgisinin "No loan." oldugunu doğrular


    Examples:
      | id  |
      | 1000 |
    
    

  @API41
  Scenario Outline: API_US_41_TC_05 When an invalid authorization is provided to the 'api/loans/approve/{{id}}' endpoint along with a PATCH body,
  the expected status code should be 401 and the error message in the response body should be "Unauthorized request".

    * The API user sets "api/loans/approve/<id>" path parameters
    * The API user saves the response from the api loans aprove endpoint with invalid authorization information information and confirms that the status code is '401' and the error message is Unauthorized
    # Api kullanicisi response bodydeki status code bilgisinin "401", bodydeki error mesaj bilgisinin "Unauthorized" oldugunu doğrular

    Examples:Verify the information of the one with the id
      | id  |
      | 222 |
