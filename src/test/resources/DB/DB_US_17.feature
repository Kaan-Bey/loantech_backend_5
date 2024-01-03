
@DB17
Feature: DB_US_17 In the "users" table, update the "mobile" number of "usernames" with the penultimate letter e.


  Scenario: DB_US_17_TC_01 Test to update the "mobile" number of "usernames" with the penultimate letter e in the "users" table.

    * Database connection is established.
    * The query is prepared and executed to the support_tickets table.
    * Validates the resultSet returned from the support_tickets table.
    * The database connection is closed.