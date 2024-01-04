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
    * Verify the information of the one with the id <dataIndex> in the API user api loans rejected response body: <id>, "<loan_number>", <user_id>, <plan_id>, "<amount>", "<per_installment>", <installment_interval>, <delay_value>, "<charge_per_installment>", "<delay_charge>", <given_installment>, <total_installment>, "<admin_feedback>", <status>, "<created_at>","<updated_at>"

    Examples:
      | dataIndex | id  | loan_number  | user_id | plan_id | amount       | per_installment | installment_interval | delay_value | charge_per_installment | delay_charge | given_installment | total_installment | admin_feedback      | status | created_at                  | updated_at                  |
      | 0         | 455 | MVG4ZSRNZX13 | 80      | 196     | 444.00000000 | 48.84000000     | 30                   | 5           | 34.21000000            | 0.00000000   | 0                 | 11                | Bank info is wrong. | 3      | 2024-01-02T17:30:42.000000Z | 2024-01-02T17:54:46.000000Z |