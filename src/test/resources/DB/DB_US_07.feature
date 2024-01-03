
@DB07
Feature: DB_US_07 In the "support_tickets" table in the database, verify the "subject" information of the data whose "ticket" value starts with 4.


  Scenario: DB_US_07_TC_01 Test to verify the "subject" information of the data whose "ticket" value starts with 4 in the "support_tickets" table in the database.

    * Database connection is established.
    * The query is prepared and executed to the support_tickets table.
    * Validates the resultSet returned from the support_tickets table.
    * The database connection is closed.