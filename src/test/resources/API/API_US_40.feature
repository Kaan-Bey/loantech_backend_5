Feature:  API_US_40 As an administrator (admin), I want to be able to access the loans
  installments information given id via API connection.

  @sad
  Scenario Outline: API_US_40_TC_01 verify that when a GET request with valid authorisation information
  and correct data (id) is sent to the api/loans/installments/{{id}} endpoint, the status code
  returned is 200 and the response remark is "success"
    *  The API user sets "api/loans/installments/<id>" path parameters
    * The API user saves the response from the api Loans endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"

    Examples:
      | id  |
      | 173 |

  @sad
  Scenario:API_US_40_TC_02  When a GET request is sent to the api/loans/installments/{{id}} endpoint without valid
    authorisation information and (id), it should be verified that the status code returned is
    203 and the response message is "No id"

    *  The API user sets "api/loans/installments" path parameters
    * The API user saves the response from the api Loans endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No id"

  @sad
  Scenario Outline: API_US_40_TC_03 When a GET request is sent to the api/loans/installments/{{id}} endpoint with valid authorisation information
  and an unregistered (id), it should be verified that the status code returned is 203 and the
  response message is "No Loan"
    *  The API user sets "api/loans/installments/<id>" path parameters
    * The API user saves the response from the api Loans endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No Loan"

    Examples:
      | id       |
      | 17398979 |

  @sad
  Scenario Outline: API_US_40_TC_04 When a GET request is sent to the api/loans/installments/{{id}} endpoint with invalid authorisation
  information, it should be verified that the status code returned is 401 and the error information in the response
  body is "Unauthorised request"
    *  The API user sets "api/loans/installments/<loan_id>" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized
    Examples:
      | loan_id |
      | 173 |


  @sad
  Scenario Outline: API_US_40_TC_05 Verify the information(loan_id, delay_charge, installment_date, given_at)
  of id(x) returned in Response
    *  The API user sets "api/loans/installments/<loan_id>" path parameters
    * The API user saves the response from the api Loans endpoint with valid authorization information
    #* The API user verifies that the content of the data field in the response body includes INSTALLMENT : <loan_id>, "<delay_charge>",  "<installment_date>", "<given_at>"

    * Verify the information of the one with Installment the id <dataIndex> in the API user response body:<loan_id>, <id>, "<delay_charge>", "<installment_date>"

    Examples:
      | loan_id | dataIndex | loan_id | id   | delay_charge | installment_date            |
      | 173     | 0         | 173     | 2265 | 0.00000000   | 2023-12-31T05:00:00.000000Z |




