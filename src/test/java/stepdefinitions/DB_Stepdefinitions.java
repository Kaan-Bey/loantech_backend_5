package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.DBUtils;
import utilities.QueryManage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Stepdefinitions {



    PreparedStatement preparedStatement;
    ResultSet resultSet;

    QueryManage queryManage = new QueryManage();



    @Given("Database connection is established.")
    public void database_connection_is_established() {

        DBUtils.createConnection();

    }
    @Given("The query is prepared and executed to the support_tickets table.")
    public void the_query_is_prepared_and_executed_to_the_support_tickets_table() throws SQLException {

        String query= queryManage.getSupportTicketsQuery();

        resultSet= DBUtils.getStatement().executeQuery(query);

    }
    @Given("Validates the resultSet returned from the support_tickets table.")
    public void validates_the_result_set_returned_from_the_support_tickets_table() {

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        String query= "SELECT * FROM u168183796_qaloantec.support_tickets";

        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();

        System.out.println(resultSet.getString("name"));

    }
    @Given("The database connection is closed.")
    public void the_database_connection_is_closed() {

        DBUtils.closeConnection();

    }




}
