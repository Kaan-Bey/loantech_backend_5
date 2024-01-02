Feature: API_US_43 As an administrator, I should be able to delete a credit record
  in the system via API connection.

  @API43
  Scenario Outline: API_US_43_TC_01 When a valid DELETE request is sent to endpoint 'api/loans/delete/{{id}}'
  with valid authorization information and correct (id), the expected status code should be 200 and
  the message information in the response body should be "Loan deleted"

    * The API user sets "api/loans/delete/<id>" path parameters
    * The API user saves the response from the user api loans delete endpoint with valid authorization information
    # Api kullanicisi api categories delete id endpointinden donen response'i gecerli authorization bilgisi ile kaydeder
    * The API user verifies that the status code is 200
    # Api kullanicisi response bodydeki status code bilgisinin "200" oldugunu doğrular
    * The API User verifies that the message information in the response body is "Loan deleted"
    # Api kullanicisi response bodydeki mesaj bilgisinin "loan deleted" oldugunu doğrular

    Examples:
      | id  |
      | 446 |

  @API43
  Scenario: API_US_43_TC_02 When a valid DELETE request is sent to the 'api/loans/delete/{{id}}' endpoint with
  correct authorization but without the required (id) appended, the expected status code should be 203 and the
  message information response body should be confirmed as "No id"

    * The API user sets "api/loans/delete" path parameters
    * The API user saves the response from the user api loans delete endpoint with valid authorization information
    # Api kullanicisi api categories list endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    * The API user verifies that the status code is 203
    # Api kullanicisi response bodydeki status code bilgisinin "203" oldugunu doğrular
    * The API User verifies that the message information in the response body is "No id"
    # Api kullanicisi response bodydeki mesaj bilgisinin "No id" oldugunu doğrular

  @API43
  Scenario: API_US_43_TC_03  When a valid DELETE request is sent to the 'api/loans/delete/{{id}}' endpoint with
  an (id) corresponding to a record that is not with valid authorization, the expected status code should be 203 and
  the message information in the response body should be confirmed as "No loan".

    * The API user sets "api/loans/delete/432" path parameters
    * The API user saves the response from the user api loans delete endpoint with valid authorization information
    # Api kullanicisi api categories list endpointinden donen responsei gecerli authorization bilgisi ile kaydeder
    * The API user verifies that the status code is 203
    # Api kullanicisi response bodydeki status code bilgisinin "203" oldugunu doğrular
    * The API User verifies that the message information in the response body is "No loan."
    # Api kullanicisi response bodydeki mesaj bilgisinin "No category" oldugunu doğrular

    @API43
    Scenario Outline: API_US_43_TC_04 When a DELETE request is sent to the 'api/loans/delete/{{id}}' endpoint with unauthorized
    authorization information, the expected status code is 401 and the error message in the response body is confirmed
    to be "Unauthorized request".

      * The API user sets "api/loans/delete/<id>" path parameters
      * The API user saves the response from the api categories delete endpoint with invalid authorization information information and confirms that the status code is '401' and the error message is Unauthorized
      # Api kullanicisi user loans delete endpointinden donen responsei geçersiz authorization bilgisi ile kaydeder, status codeun 401 ve error bilgisinin Unauthorized oldugunu dogrular

      Examples:
        | id  |
        | 429 |

  @API16
  Scenario Outline: API_US_43_TC_05 "The deletion of the requested loan record must be verified via the API. (Can be confirmed by verifying that the record has been deleted by sending a GET request to the api/loans/details/{{id}}
  endpoint with the Deleted loan ID returned in the response body.)"

    * The API user sets "api/loans/details/<id>" path parameters
    * The API user saves the response from the api categories list endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No Loan"

    Examples:
      | id  |
      | 429 |







