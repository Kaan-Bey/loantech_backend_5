Feature: API_US_37 As an administrator, I want to access the list of running loans via API connection.
  Scenario: api/loans/running' endpoint, it should return a status code of 200,
and the response remark should be "success"

* The API user sets "api/loans/running" path parameters
* The API user saves the response from the api loans paid endpoint with valid authorization information
* The API user verifies that the status code is 200
* The API user verifies that the remark information in the response body is "success"

  Scenario:  When an invalid GET request with unauthorized credentials is sent to the 'api/loans/running' endpoint, it should return a status code of 401, and the response error message should be "Unauthorized request"
    * The API user sets "api/loans/running" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized


  Scenario Outline: Verify the information (loan_number, user_id, plan_id, amount, per_installment, installment_interval, delay_value, charge_per_installment, delay_charge, given_installment,
  total_installment, admin_feedback, status, due_notification_sent, approved_at, created_at, updated_at) returned in the response for Id(x)
    * The API user sets "api/loans/details/<id>" path parameters
    * The API user saves the response from the admin loans details id  endpoint with valid authorization information
    * The API user verifies that the content of the data field in the response body includes <id>, "<loan_number>", <user_id>, <plan_id>, "<amount>", "<per_installment>", <installment_interval>, <delay_value>, "<charge_per_installment>", "<delay_charge>", <given_installment>, <total_installment>, "<application_form>", "<admin_feedback>", <status>, "<due_notification_sent>", "<approved_at>", "<created_at>", "<updated_at>"

Examples:
      | id  | loan_number  | user_id | plan_id | amount        | per_installment | installment_interval | delay_value | charge_per_installment | delay_charge | given_installment | total_installment | application_form | admin_feedback | status | due_notification_sent | approved_at                 | created_at                  | updated_at                  |
      | 12  | ST9JGVK15AKS | 62      | 11      | 2500.00000000 | 100.00000000    | 20                   | 25          | 100.04000000           | 0.00000000   | 0                 | 20                | []               | null           | 1      | null                  | 2023-12-14T08:36:30.000000Z | 2023-12-14T01:07:32.000000Z | 2023-12-14T08:36:30.000000Z |