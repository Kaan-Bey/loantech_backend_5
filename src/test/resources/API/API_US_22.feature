Feature: API_US_022 As an administrator, I should be able to delete a loan plan record in the system through API connection.

  Scenario Outline: When a valid DELETE request with appropriate authorization credentials and
                    correct data (id) is sent to the 'api/loanplans/delete/{{id}}' endpoint, it should return a status code of 200,
                    and the message in the response body should be "Loan plan deleted"

    * The API user sets "api/loanplans/delete/<id>" path parameters
    * The API user saves the response from the loanplans delete endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * API User verifies that the message information in the response body is "Loan plan deleted"

    Examples:
      | id  |
      | 204 |

  Scenario:  When a DELETE request without the required data (id) and with valid authorization
             credentials is sent to the 'api/loanplans/delete/{{id}}' endpoint,
             it should return a status code of 203, and the message in the response body should be "No id"

    * The API user sets "api/loanplans/delete" path parameters
    * The API user saves the response from the loanplans delete endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No id"

  Scenario Outline:  When a DELETE request with valid authorization credentials and an (id) that does not correspond
                     to an existing record is sent to the 'api/loanplans/delete/{{id}}' endpoint,
                     it should return a status code of 203, and the message in the response body should be "No loanplan."

    * The API user sets "api/loanplans/delete/<id>" path parameters
    * The API user saves the response from the loanplans delete endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No loanplan."

    Examples:
      | id  |
      | 159 |

  Scenario Outline: When an invalid DELETE request body is sent with unauthorized credentials to the 'api/loanplans/delete/{{id}}' endpoint, it should return a status code of 401,
                    and the error message in the response body should be "Unauthorized request"

    * The API user sets "api/loanplans/delete/<id>" path parameters
    * The API user saves the response from the loanplans delete endpoint with invalid authorization information and confirms that the status code is '401' and the error message is Unauthorized

    Examples:
      | id  |
      | 204 |

  Scenario Outline:  The deletion of the loan plan record intended to be removed through the API should be verified.
                     This can be confirmed by sending a GET request to the 'api/loanplans/details/{{id}}' endpoint with the
                     Deleted Loan Plan id returned in the response body, thus validating that the record has been deleted

    * The API user sets "api/loanplans/delete/<id>" path parameters
    * The API user saves the response from the loanplans delete endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No loanplan."


    Examples:
      | id  |
      | 204 |