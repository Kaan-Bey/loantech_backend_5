
@DB06

Feature: DB_US_06 In the "Support_messages" table in the database, verify the "support_ticket_id" of the data whose "message" information is "Tickett".

  Scenario Outline: DB_US_06_TC_01 In the Support_messages table in the database, the support_ticket_id of the data with "message" information ? is tested.

    * Database connection is established.
    * In the Support messages table in the database, the support ticket id of the data whose "<message>" information is id is verified.
    * The database connection is closed.

    Examples:
      | message |
      | sdgf ssdsg sdgsdg    |



