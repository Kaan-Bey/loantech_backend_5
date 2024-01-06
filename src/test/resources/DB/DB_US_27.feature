Feature: DB_US_27 Verify the first 3 "names" in the loan_plans table according to the "delay_value" and "fixed_charge" or "percent_charge" values.

  Scenario: DB_US_27_TC_01 Validation test of the first 3 "name" information in the loan_plans table based on "delay_value"

    * Database connection is established.
    * The query is prepared and executed to the delay_value table.
    * Validates the resultSet returned from the delay_value table.
    * The database connection is closed.


  Scenario: DB_US_27_TC_02 Validation test of the first 3 "name" information in the loan_plans table based on "fixed_charge"

    * Database connection is established.
    * The query is prepared and executed to the fixed_charge table.
    * Validates the resultSet returned from the fixed_charge table.
    * The database connection is closed.

  Scenario: DB_US_27_TC_03 Validation test of the first 3 "name" information in the loan_plans table based on "percent_charge"

    * Database connection is established.
    * The query is prepared and executed to the percent_charge table.
    * Validates the resultSet returned from the percent_charge table.
    * The database connection is closed.