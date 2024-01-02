@API39
Feature: API_US_39 As an administrator (admin) I want to be able to access loans rejected via API connection.

  Scenario :API_US_39_TC_01 When a GET request is sent to the api/loans/rejected endpoint with valid authorization information,
  it should be verified that the status code returned is 200 and the response remark is "success".

    * The API user sets "api/loans/rejected" path parameters
    * The API user saves the response from the api loans rejected endpoint with valid authorization information
    * The API user verifies that the status code is 200
    * The API user verifies that the remark information in the response body is "success"

  Scenario: API_US_39_TC_02 When a GET Request is sent to the api/loans/rejected endpoint with invalid authorization information,
  it should be verified that the status code returned is 401 and the response error is "Unauthorized request"

    * The API user sets "api/loans/rejected" path parameters
    * The API user records the response with invalid authorization information, verifies that the status code is '401' and confirms that the error information is Unauthorized

  @API39
  Scenario Outline: API_US_39_TC_03
    * The API user sets "api/loans/rejected" path parameters
    * The API user saves the response from the api loans rejected endpoint with valid authorization information
    * Verify the information of the one with the id <dataIndex> in the API user response body: <id>, "<loan_number>", <user_id>, <plan_id>, "<amount>", "<per_installment>", <installment_interval>, <delay_value>, "<charge_per_installment>", "<delay_charge>", <given_installment>, <total_installment>, "<admin_feedback>", <status>, <due_notification_sent>, <approved_at>, "<created_at>","<updated_at>"

    Examples:
      | id  | dataIndex | loan_number  | user_id | plan_id | amount     | per_installment | installment_interval | delay_value | charge_per_installment | delay_charge | given_installment | total_installment | status | created_at                  | updated_at                  |
      | 450 | 0         | W1OXFJMEJFZA | 8       | 26      | 2.00000000 | 0.02000000      | 1                    | 3           | 1.13000000             | 0.00000000   | 0                 | 999               | 3      | 2024-01-02T14:45:32.000000Z | 2024-01-02T14:45:53.000000Z |
