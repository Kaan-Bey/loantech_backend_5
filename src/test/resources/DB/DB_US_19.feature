Feature: Users sorting test


  @DB19
  Scenario: DB_US_19_TC_01 List all records in the "Users" table in "lastname" order,
  "firstname" in reverse order and verify the first surname.

    * Database connection is established.
    * The query is prepared and executed against the Users table.
    * Verify the result set from the Users table.
    * The database connection is closed.


