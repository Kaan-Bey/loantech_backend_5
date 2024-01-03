Feature: API_US_38 As an administrator, I want to access the list of paid loans via API connection.


  @API
  Scenario: api/loans/paid' endpoint, it should return a status code of 200,
  and the response remark should be "success"

    * The API user sets "api/loans/paid" path parameters
    * The API user saves the response from the api loans paid endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"


  Scenario: api/loans/paid' endpoint, it should return a status code of 401,
  and the response error message should be "Unauthorized request"

    * The API user sets "api/loans/paid" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized


  Scenario Outline: id(x) (loan_number, user_id, plan_id, amount, per_installment, installment_interval,
  delay_value, charge_per_installment, delay_charge, given_installment, total_installment, admin_feedback, status,
  due_notification_sent, approved_at, created_at, updated_at)

    * The API user sets "api/loans/details/<id>" path parameters
    * The API user saves the response from the api loans paid endpoint with valid authorization information
    * Verify the information of the one with the <id> in the API user response body: "<loan_number>", <user_id>, <plan_id>, "<amount>", "<per_installment>", <installment_interval>, <delay_value>, "<charge_per_installment>", "<delay_charge>", <given_installment>, <total_installment>, "<admin_feedback>", <status>, "<due_notification_sent>", "<approved_at>", "<created_at>", "<updated_at>"

    Examples:
      | id  | loan_number  | user_id | plan_id | amount        | per_installment | installment_interval | delay_value | charge_per_installment | delay_charge | given_installment | total_installment | admin_feedback | status | due_notification_sent | approved_at | created_at                  | updated_at                  |
      | 411 | ZDR5SYDXCNFN | 26      | 84      | 1000.00000000 | 50.00000000     | 28                   | 1           | 5.25000000             | 0.00000000   | 0                 | 36                | null           | 3      | null                  | null        | 2023-12-29T20:15:49.000000Z | 2023-12-30T17:31:37.000000Z |