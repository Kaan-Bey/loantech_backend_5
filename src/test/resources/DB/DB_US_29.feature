Feature: Delete in update_logs table


  @DB29
  Scenario: DB_US_29_TC_01 Delete a data according to the "id" value in the update_logs table
  and verify that it has been deleted.

    * Database connection is established.
    * The query is prepared and executed according to the Update_logs table.
    * Verify the result set returned from the Update_logs table.
    * The database connection is closed.