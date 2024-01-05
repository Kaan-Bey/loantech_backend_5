@DB01

Feature: DB_US_01 Verify user_ids with "amount" value between $100 and $500 in the "deposits" table in the database



Scenario: DB_US_01_TC_01 Test that user identities with an "amount" value between 100 and 500 USD in the "deposit" table in the database are verified.
  * Database connection is established.
  * The query is prepared and executed on the deposit table
  * The user_id information in the resultSet returned from the deposits table is verified.
  * The database connection is closed.