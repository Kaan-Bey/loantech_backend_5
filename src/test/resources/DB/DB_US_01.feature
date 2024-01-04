@DB

Feature: Data Testing

  Scenario: Verify user_ids with "amount" value between $100 and $500 in the "deposits" table in the database

  * database connection is established
  * depositsQuery is prepared
  * data is verified
  * database is closed

