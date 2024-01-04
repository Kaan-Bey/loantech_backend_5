
@DB07

Feature: DB_US_07 In the "support_tickets" table in the database, verify the "subject" information of the data whose "ticket" value starts with 4.


  Scenario: DB_US_07_TC_01 (static) Test to verify the "subject" information of the data whose "ticket" value starts with 4 in the "support_tickets" table in the database.

    * Database connection is established.
    * The query is prepared and executed to the support_tickets table.
    * Validates the resultSet returned from the support_tickets table.
    * The database connection is closed.


  Scenario Outline: DB_US_07_TC_01 (dynamic) Validate subject of a ticket with dynamic ticket value

    * Database connection is established.
    * The database contains a ticket with value starting with <ticketValue>
    * I check the subject of the ticket
    * The subject should be valid
    * The database connection is closed.

    Examples:
      | ticketValue |
      | 4           |
