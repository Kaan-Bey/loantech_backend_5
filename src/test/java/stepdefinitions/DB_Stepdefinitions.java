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

    List<String> actualSubjectList = new ArrayList<>();

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


    @Given("The database contains a ticket with value starting with {int}, {int}, {string}")
    public void the_database_contains_a_ticket_with_value_starting_with(int ticketValue, int dataindex, String expectedStatus) throws SQLException {

        query = queryManage.getSupportTicketQuery();

        resultSet = DBUtils.getStatement().executeQuery(query);
        Assert.assertEquals("Test", actualSubjectList.get(0));

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

        Assert.assertEquals("Test", actualSubjectList.get(0));
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

}



