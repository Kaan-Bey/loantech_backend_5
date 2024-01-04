package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.QueryManage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB_Stepdefinitions {



    PreparedStatement preparedStatement;
    ResultSet resultSet;

    QueryManage queryManage = new QueryManage();

    @Given("database connection is established")
    public void database_connection_is_established() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("depositsQuery is prepared")
    public void deposits_query_is_prepared() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("data is verified")
    public void data_is_verified() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("database is closed")
    public void database_is_closed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }





}
