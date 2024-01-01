
@DB07
Feature: DB_US_07 Verify the "subject" information of the data starting with the "Ticket" value in the "Support_Tickets" table in Database.


  Scenario: DB_US_07_TC_01 Test to verify that the data starting with the value "Ticket" in the Support_Tickets" table in the database is "subject".

    * Database connection is established.
    * The query is prepared and executed to the support_tickets table.
    * Validates the resultSet returned from the support_tickets table.
    * The database connection is closed.