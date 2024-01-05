package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;
import utilities.QueryManage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DB_Stepdefinitions {


    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    QueryManage queryManage = new QueryManage();
    String subject;

    int rowCount;
    List<String> actualSubjectList = new ArrayList<>();

    List<String> actualMobileList = new ArrayList<>();

    @Given("Database connection is established.")
    public void database_connection_is_established() {

        DBUtils.createConnection();

    }

    @Given("The query is prepared and executed to the support_tickets table.")
    public void the_query_is_prepared_and_executed_to_the_support_tickets_table() throws SQLException {

        query = queryManage.getSupportTicketQuery();

        resultSet = DBUtils.getStatement().executeQuery(query);
    }

    @Given("Validates the resultSet returned from the support_tickets table.")
    public void validates_the_result_set_returned_from_the_support_tickets_table() throws SQLException {

        List<String> actualSubject = new ArrayList();
        while (resultSet.next()) {
            String subject = resultSet.getString("subject");
            actualSubject.add(subject);
        }

        //   ExpectedList  oluşturup for döngüsünde get(i) değerleri assert edebilirsiniz

    }


    @Given("The database contains a ticket with value starting with {int}")
    public void the_database_contains_a_ticket_with_value_starting_with(int ticketValue) throws SQLException {

        query = queryManage.getSupportTicketQuery();

        resultSet = DBUtils.getStatement().executeQuery(query);

        subject = "Sample Subject for Ticket " + ticketValue;

    }

    @Given("I check the subject of the ticket")
    public void checkSubject() throws SQLException {

// List<String> expectedSubjectList = new ArrayList<>();

        while (resultSet.next()) {

            String subject = resultSet.getString("subject");

            actualSubjectList.add(subject);
        }
        System.out.println(actualSubjectList);
    }


    @Given("The subject should be valid")
    public void validateSubject() {

        Assert.assertEquals("testSubject", actualSubjectList.get(0));
    }

    @Given("The database connection is closed.")
    public void the_database_connection_is_closed() {

        DBUtils.closeConnection();

    }

    @Given("The users table lists usernames with the penultimate letter e {string}")
    public void the_users_table_lists_usernames_with_the_penultimate_letter_e(String expectedmobile) throws SQLException {

        query = queryManage.getSetMobileUpdate();

        preparedStatement = DBUtils.getPraperedStatement(query);

        preparedStatement.setString(1, expectedmobile);

        rowCount = preparedStatement.executeUpdate();


    }

    @Given("It is verified that the mobile phone number has been updated.")
    public void ıt_is_verified_that_the_mobile_phone_number_has_been_updated() {

        Assert.assertEquals(18, rowCount);
    }


    @Given("The query is prepared and executed on the deposit table")
    public void the_query_is_prepared_and_executed_on_the_deposit_table() throws SQLException {
      query = queryManage.getDepositsQuery();
      resultSet = DBUtils.getStatement().executeQuery(query);

    }

    @Given("The user_id information in the resultSet returned from the deposits table is verified.")
    public void the_user_id_information_in_the_result_set_returned_from_the_deposits_table_is_verified() throws SQLException {
     List<Integer> actualuserId = new ArrayList<>();
     Integer[] user_Id = {6, 45, 24, 88, 55, 69, 21, 26, 49, 53, 89, 70, 34, 71, 74, 8, 62, 11, 43, 64, 25, 40, 16, 57, 46, 13, 22, 85, 65, 17, 19, 81, 41, 79, 27, 44, 15, 98, 14, 12, 32, 68, 48, 9, 83, 33, 31, 61, 80};
     List<Integer> expecteduserId = new ArrayList<>(Arrays.asList(user_Id));
     while (resultSet.next()) {
         int userId = resultSet.getInt("user_id");
         if (!actualuserId.contains(userId)){
             actualuserId.add(userId);
         }
         for (int i = 0; i < actualuserId.size(); i++) {
             Assert.assertEquals(expecteduserId.get(i),actualuserId.get(i));
         }
     }

    }
}

// [6, 45, 24, 88, 55, 69, 21, 26, 49, 53, 89, 70, 34, 71, 74, 8, 62, 11, 43, 64, 25, 40, 16, 57, 46, 13, 22, 85, 65, 17, 19, 81, 41, 79, 27, 44, 15, 98, 14, 12, 32, 68, 48, 9, 83, 33, 31, 61, 80]






