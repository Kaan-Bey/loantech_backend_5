package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;
import utilities.QueryManage;
import utilities.ReusableClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class DB_Stepdefinitions {
    Faker faker = new Faker();

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


    @Given("The query is prepared and executed to the admins table.")
    public void the_query_is_prepared_and_executed_to_the_admins_table() throws SQLException {
        query = queryManage.getAdminsQuery();
        resultSet = DBUtils.getStatement().executeQuery(query);

    }

    @Given("Verify the remember_token information in the resultSet returned from the Admins table")
    public void verify_the_remember_token_information_in_the_result_set_returned_from_the_admins_table() throws SQLException {

        String expectedData = "1xUgfVUD1Ggx5CVz7mxLvcye8RXRbeFqSktSIkhya321TqDkLOsqhys4pnJv";

        resultSet.next();

        String actualData = resultSet.getString("remember_token");

        Assert.assertEquals(expectedData, actualData);
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

    @Given("The query is prepared and executed to the Subscribers table.")
    public void the_query_is_prepared_and_executed_to_the_subscribers_table() throws SQLException {
        String query = queryManage.getSubscribersEmailNotLike();
        resultSet = DBUtils.getStatement().executeQuery(query);

    }

    @Given("lists data that does not contain a in email data.")
    public void lists_data_that_does_not_contain_a_in_email_data() throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "     " + resultSet.getString(2));
        }
    }

    @Given("adminpasswordInsertQuery is prepared")
    public void adminpassword_ınsert_query_is_prepared() throws SQLException {
        String email1;
        String email2;
        String token1;
        String token2;
        int status;
        String created_at;
        query = QueryManage.getAdminpasswordInsertQuery();
        email1 = faker.internet().emailAddress();
        email2 = faker.internet().emailAddress();
        token1 = faker.internet().password();
        token2 = faker.internet().password();
        status = 1;
        created_at = "2024.01.03 19:00";
        preparedStatement = DBUtils.getPraperedStatement(query);
        preparedStatement.setString(1, email1);
        preparedStatement.setString(2, token1);
        preparedStatement.setInt(3, status);
        preparedStatement.setString(4, created_at);
        preparedStatement.setString(5, email2);
        preparedStatement.setString(6, token2);
        preparedStatement.setInt(7, status);
        preparedStatement.setString(8, created_at);

    }

    @Given("It is verified that new datas are inserted")
    public void ıt_is_verified_that_new_datas_are_inserted() throws SQLException {

        int rowCount = preparedStatement.executeUpdate();
        Assert.assertEquals(2, rowCount);
    }


    @Given("The query is prepared and executed against the loans table.")
    public void the_query_is_prepared_and_executed_against_the_loans_table() throws SQLException {
        query = queryManage.getDeleteLoanQuery();
        // resultSet = DBUtils.getStatement().executeQuery(query);


    }

    @Given("Validates the resultSet returned from the loans table.")
    public void validates_the_result_set_returned_from_the_loans_table() {

        Assert.assertNull(resultSet);
    }

    @Given("The query is prepared and executed against the Users table.")
    public void the_query_is_prepared_and_executed_against_the_users_table() {
        query = queryManage.getOrderUsersQuery();
    }

    @Given("Verify the result set from the Users table.")
    public void verify_the_result_set_from_the_users_table() {

        Assert.assertNull(resultSet);


    }


    @Given("The query is prepared and executed according to the Update_logs table.")
    public void the_query_is_prepared_and_executed_according_to_the_update_logs_table() {

        query = queryManage.getDeleteUpdateLogQuery();

    }

    @Given("Verify the result set returned from the Update_logs table.")
    public void verify_the_result_set_returned_from_the_update_logs_table() {

        Assert.assertNull(resultSet);


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
            if (!actualuserId.contains(userId)) {
                actualuserId.add(userId);
            }
            for (int i = 0; i < actualuserId.size(); i++) {
                Assert.assertEquals(expecteduserId.get(i), actualuserId.get(i));
            }
        }

    }

    @Given("In the Support messages table in the database, the support ticket id of the data whose {string} information is id is verified.")
    public void ın_the_support_messages_table_in_the_database_the_support_ticket_id_of_the_data_whose_information_is_id_is_verified(String message) throws SQLException {
        query = queryManage.getSupportMessagesQuery();
        preparedStatement = DBUtils.getPraperedStatement(query);

        Assert.assertEquals("sdgf ssdsg sdgsdg", message);


    }

    @Given("The query is prepared and executed to the delay_value table.")
    public void the_query_is_prepared_and_executed_to_the_delay_value_table() throws SQLException {
        query = queryManage.getDelayValueQuery();
        resultSet = DBUtils.getStatement().executeQuery(query);
    }

    @Given("Validates the resultSet returned from the delay_value table.")
    public void validates_the_result_set_returned_from_the_delay_value_table() throws SQLException {
        List<String> delayValueTable = new ArrayList();
        while (resultSet.next()) {
            String name = resultSet.getString("NAME");
            delayValueTable.add(name);
        }
        Assert.assertEquals("KrediYasemin3Kredi3Kredi3Kredi3", delayValueTable.get(0));
        Assert.assertEquals("Personal Finance Loan", delayValueTable.get(1));
        Assert.assertEquals("Bugra Test Loan 123", delayValueTable.get(2));
    }

    @Given("The query is prepared and executed to the fixed_charge table.")
    public void the_query_is_prepared_and_executed_to_the_fixed_charge_table() throws SQLException {
        query = queryManage.getFixedChargeQuery();
        resultSet = DBUtils.getStatement().executeQuery(query);
    }

    @Given("Validates the resultSet returned from the fixed_charge table.")
    public void validates_the_result_set_returned_from_the_fixed_charge_table() throws SQLException {
        List<String> fixedChargeTable = new ArrayList();
        while (resultSet.next()) {
            String name = resultSet.getString("NAME");
            fixedChargeTable.add(name);
        }
        Assert.assertEquals("necmettin", fixedChargeTable.get(0));
        Assert.assertEquals("aylin", fixedChargeTable.get(1));
        Assert.assertEquals("Personal Finance Loan", fixedChargeTable.get(2));
    }

    @Given("The query is prepared and executed to the percent_charge table.")
    public void the_query_is_prepared_and_executed_to_the_percent_charge_table() throws SQLException {
        query = queryManage.getPercentChargeQuery();
        resultSet = DBUtils.getStatement().executeQuery(query);
    }
    @Given("Validates the resultSet returned from the percent_charge table.")
    public void validates_the_result_set_returned_from_the_percent_charge_table() throws SQLException {
        List<String> percentChargeQuery = new ArrayList();
        while (resultSet.next()) {
            String name= resultSet.getString("NAME");
            percentChargeQuery.add(name);
        }
        Assert.assertEquals("Omer", percentChargeQuery.get(0));
        Assert.assertEquals("Personal Finance Loan", percentChargeQuery.get(1));
        Assert.assertEquals("Personal Finance Loan", percentChargeQuery.get(2));
    }
}







