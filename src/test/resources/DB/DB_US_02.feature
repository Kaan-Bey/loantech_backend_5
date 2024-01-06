Feature: DB_US_02 Verify the "remember_token" information of the data "email=info@loantechexper.com" in the "admins" table in the database

  Scenario: Test the "remember_token" information of the data "email=info@loantechexper.com" in the "admins" table in the database

    * Database connection is established.
    * The query is prepared and executed to the admins table.
    * Verify the remember_token information in the resultSet returned from the Admins table
    * The database connection is closed.

