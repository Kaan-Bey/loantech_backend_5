@DB17
Feature: DB_US_17 In the "users" table, update the "mobile" number of "usernames" with the penultimate letter e.

  Scenario Outline: DB_US_17_TC_01 Test to update the "mobile" number of "usernames" with the penultimate letter e in the "users" table.

    * Database connection is established.
    * The users table lists usernames with the penultimate letter e "<expectedmobile>"
    * It is verified that the mobile phone number has been updated.
    * The database connection is closed.

    Examples:
      | expectedmobile |
      | 0543526583     |
