
@DB27
Feature: DB_US_27 Verify the first 3 "names" in the loan_plans table according to the "delay_value" and "fixed_charge" or "percent_charge" values.


  Scenario: DB_US_27_TC_01 Validation test of the first 3 "name" information in the loan_plans table based on "delay_value" and "fixed_charge" or "percent_charge" values.

    * Database connection is established.
    * The query is prepared and executed to the delay_value table.
    * Validates the resultSet returned from the delay_value table.
    * The database connection is closed.