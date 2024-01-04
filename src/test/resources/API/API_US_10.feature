Feature: API_US_10 As a user, I want to access the list of loans via API connection.


  @API
  Scenario: user/list/loan' endpoint with the appropriate authorization credentials,
  it should return a status code of 200, and the response remark should be "success"

    * The API user sets "user/list/loan" path parameters
    * The API user saves the response from the user list loan endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"


  Scenario: user/list/loan' endpoint with invalid authorization information,
  the returned status code is 401, and the error message in the response body is "Unauthorized request"

    * The API user sets "user/list/loan" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized


  Scenario Outline: id(x) (loan_number, user_id, plan_id, amount, per_installment, installment_interval, delay_value, charge_per_installment,
  delay_charge, given_installment, total_installment, admin_feedback, status, due_notification_sent, approved_at, created_at, updated_at)

    * The API user sets "user/list/loan" path parameters
    * The API user saves the response from the user list loan endpoint with valid authorization information
    * Verify the information of the one with the idd <dataIndex> in the API user response body: "<loan_number>", <user_id>, <plan_id>, "<amount>", "<per_installment>", <installment_interval>, <delay_value>, "<charge_per_installment>", "<delay_charge>", <given_installment>, <total_installment>, "<admin_feedback>", <status>, "<due_notification_sent>", "<approved_at>", "<created_at>", "<updated_at>"

    Examples:
      | dataIndex | loan_number  | user_id | plan_id | amount       | per_installment | installment_interval | delay_value | charge_per_installment | delay_charge | given_installment | total_installment | admin_feedback | status | due_notification_sent | approved_at | created_at                  | updated_at                  |
      | 0         | D8T2HEUSZPBX | 46      | 25      | 100.00000000 | 10.00000000     | 100                  | 10          | 101.00000000           | 0.00000000   | 0                 | 100               | null           | 0      | null                  | null        | 2023-12-22T04:15:36.000000Z | 2023-12-22T04:15:36.000000Z |