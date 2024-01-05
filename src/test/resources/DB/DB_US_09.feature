  Feature: Loan deletion and verification of deletion


  @DB09
  Scenario: DB_US_09_TC_01 Verify that the requested data has been deleted by typing "loan_number"
            into the "loans" table in the database.


    * Database connection is established.
    * The query is prepared and executed against the loans table.
    * Validates the resultSet returned from the loans table.
    * The database connection is closed.