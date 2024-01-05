Feature:Add multiple data to the "admin_password_resets" table in the database at the same time.

  Scenario: Add multiple data to the "admin_password_resets" table in the database at the same time.
  * Database connection is established.
  * adminpasswordInsertQuery is prepared
  * It is verified that new datas are inserted
  * The database connection is closed.