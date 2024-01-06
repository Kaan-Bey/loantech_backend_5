Feature: API_US_004 As a user, I want to be able to update the close information of a registered user ticket through API connection.

  Scenario Outline: : When a PATCH request with valid authorization information and
                    correct 'id' is sent to the user/ticket/close/{{id}} endpoint, the returned status code should be 200, and the message in
                    the response body should be verified as "Support ticket closed successfully!"

    * The API user sets "user/ticket/close/<id>" path parameters
    * The API user saves the response from the user ticket close endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the message information in the response body is "Support ticket closed successfully!"

    Examples:
      | id  |
      | 353 |

  Scenario: When a PATCH request that does not contain valid authorization information and (id) is sent to the user/ticket/close/{{id}} endpoint, it should be
              verified that the status code returned is 203 and the message information in the response body is "No id".

      * The API user sets "user/ticket/close" path parameters
      * The API user saves the response from the user ticket close endpoint with valid authorization information
      * The API user verifies that the status code is 203
      * The API User verifies that the message information in the response body is "No id"

  Scenario Outline: When a PATCH request containing valid authorization information and an unregistered (id) is sent to the user/ticket/close/{{id}} endpoint, the status code returned is
                        203 and the message information in the response body is "No ticket." It must be verified that
        *  The API user sets "user/ticket/close/<id>" path parameters
        *  The API user saves the response from the user ticket close endpoint with valid authorization information
        *  The API user verifies that the status code is 203
        *  The API User verifies that the message information in the response body is "No ticket."

        Examples:
          | id  |
          | 159 |

  Scenario Outline: When a PATCH body with invalid authorization information and a correct (id) is sent to the user/ticket/close/{{id}} endpoint, it should be verified that the status code returned is
                          401 and the error information in the response body is "Unauthorized request".

          * The API user sets "user/ticket/close/<id>" path parameters
          * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized request

          Examples:
            | id  |
            | 353 |

  Scenario Outline:  It must be verified via the API that the ticket record to be updated via the API has been updated.
                     (You can verify that the record has been updated by sending a GET request to the user/ticket/detail/{{id}} endpoint with
                     the Closed ticket id returned in the response body.)

    * The API user sets "user/ticket/detail/<id>" path parameters
    * The API user saves the response from the user ticket detail endpoint with valid authorization information

    Examples:
      | id  |
      | 353 |