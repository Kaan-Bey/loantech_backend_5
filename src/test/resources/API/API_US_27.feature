Feature: As an administrator, I should be able to delete a subscriber record in the system through API connection.

   Scenario Outline: As an administrator, I should be able to delete a subscriber record in the system through API connection.



     * The API user sets "api/subscriber/delete/<id>" path parameters
     * The API user saves the response from the user api loans delete endpoint with valid authorization information
     * The API user verifies that the status code is 200
     * The API User verifies that the message information in the response body is "Subscriber deleted successfully"
        ##335--341 arası kullanılabilir##
       Examples:
       |id  |
       |334 |

   Scenario Outline: When a DELETE request with valid authorization credentials and without the required (id) is sent to the 'api/subscriber/delete/{{id}}' endpoint, it should return a status code of 203, and the message in the response body should be "No id"

     * The API user sets "api/subscriber/delete/<id>" path parameters
     * The API user saves the response from the user api loans delete endpoint with valid authorization information
     * The API user verifies that the status code is 203
     * The API User verifies that the message information in the response body is "No id"
     Examples:
       |id  |
       | |

  Scenario Outline:When a DELETE request with valid authorization credentials and an (id) that does not correspond to an existing record is sent to the 'api/subscriber/delete/{{id}}' endpoint, it should return a status code of 203, and the message in the response body should be "No subscriber "

    * The API user sets "api/subscriber/delete/<id>" path parameters
    * The API user saves the response from the user api loans delete endpoint with valid authorization information
    * The API user verifies that the status code is 203
    * The API User verifies that the message information in the response body is "No subscriber "

    Examples:
      |id  |
      |334 |


  Scenario:  When an invalid DELETE request body is sent with unauthorized credentials to the 'api/subscriber/delete/{{id}}' endpoint, it should return a status code of 401, and the error message in the response body should be "Unauthorized request"

    * The API user sets "api/subscriber/delete/<id>" path parameters
    * The API user saves the response from the api categories delete endpoint with invalid authorization information information and confirms that the status code is '401' and the error message is Unauthorized



  Scenario Outline: The deletion of the desired subscriber record via API should be confirmed by sending a GET request to the 'api/subscriber/details/{{id}}' endpoint with the Deleted Subscriber id obtained from the response body. This verification process ensures that the record has been successfully deleted

    * The API user sets "api/subscriber/delete/<id>" path parameters
    * The API user saves the response from the user api loans delete endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API User verifies that the message information in the response body is "Subscriber deleted successfully"



    Examples:
      | id  |
      | 338 |