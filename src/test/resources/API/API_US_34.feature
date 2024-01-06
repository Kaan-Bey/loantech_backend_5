
@kardelen12
Feature: API_US_034 As an administrator, I want to access the list of loans via API connection.

  Scenario : When a valid GET request with appropriate authorization credentials is sent to the 'api/loans/list' endpoint,
                    it should return a status code of 200, and the response remark should be "success"
    * The API user sets "api/loans/list" path parameters
    * The API user saves the response from the loans list endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"


  Scenario: When a GET Request is sent to the api/loans/list endpoint with invalid authorization information, it should be
                     verified that the status code returned is 401 and the response error information is "Unauthorized request".

     * The API user sets "api/loans/list" path parameters
     * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

  Scenario Outline: Verify the information returned in the Response for id(x) (loan_number, user_id, plan_id, amount, per_installment, installment_interval,
  delay_value, charge_per_installment, delay_charge,total_installment, admin_feedback, status, due_notification_sent, approved_at, created_at, updated_at).

    * The API user sets "api/loans/list" path parameters
    * The API user saves the response from the loans list endpoint with valid authorization information
    * Verify the information of the one with the id <dataIndex> in the API user response body: "<loan_number>", <user_id>, <plan_id>, "<amount>", "<per_installment>", <installment_interval>, <delay_value>, "<charge_per_installment>", "<delay_charge>", <total_installment>, "<admin_feedback>", <status>, "<created_at>", "<updated_at>"

    Examples:

    | dataIndex | loan_number |  user_id | plan_id |   amount     | per_installment | installment_interval | delay_value | charge_per_installment | delay_charge |  total_installment |  admin_feedback      | status |    created_at               |       updated_at            |
    |  0       | ZQ24CAPOY5NG|     65   | 196     | 200.00000000  | 22.00000000     |        30            | 5           |      34.21000000       | 0.00000000  |          11        | Bank info is wrong.  | 3      | 2024-01-03T13:02:04.000000Z     | 2024-01-03T13:02:34.000000Z |

