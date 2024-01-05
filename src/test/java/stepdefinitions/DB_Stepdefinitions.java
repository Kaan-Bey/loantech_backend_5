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
Faker faker=new Faker();

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

       preparedStatement=DBUtils.getPraperedStatement(query);

       preparedStatement.setString(1,expectedmobile);

       rowCount = preparedStatement.executeUpdate();


    }

      @Given("It is verified that the mobile phone number has been updated.")
    public void ıt_is_verified_that_the_mobile_phone_number_has_been_updated() {

        Assert.assertEquals(18, rowCount);
    }
    @Given("The query is prepared and executed to the Subscribers table.")
    public void the_query_is_prepared_and_executed_to_the_subscribers_table() throws SQLException {
    String query=queryManage.getSubscribersEmailNotLike();
    resultSet = DBUtils.getStatement().executeQuery(query);

    }
    @Given("lists data that does not contain a in email data.")
    public void lists_data_that_does_not_contain_a_in_email_data() throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getString(1)+"     "+resultSet.getString(2));
        }
    }
    @Given("adminpasswordInsertQuery is prepared")
    public void adminpassword_ınsert_query_is_prepared() throws SQLException {
        String email1; String email2; String token1; String token2;int status; String created_at;
        query=QueryManage.getAdminpasswordInsertQuery();
        email1=faker.internet().emailAddress();
        email2=faker.internet().emailAddress();
        token1=faker.internet().password();
        token2=faker.internet().password();
        status=1;
        created_at="2024.01.03 19:00";
        preparedStatement=DBUtils.getPraperedStatement(query);
        preparedStatement.setString(1,email1);
        preparedStatement.setString(2,token1);
        preparedStatement.setInt(3,status);
        preparedStatement.setString(4,created_at);
        preparedStatement.setString(5,email2);
        preparedStatement.setString(6,token2);
        preparedStatement.setInt(7,status);
        preparedStatement.setString(8,created_at);

    }
    @Given("It is verified that new datas are inserted")
    public void ıt_is_verified_that_new_datas_are_inserted() throws SQLException {

        int rowCount=preparedStatement.executeUpdate();
        Assert.assertEquals(2,rowCount);
    }

}




