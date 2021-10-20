package database;

import models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDatabase extends DatabaseConnector{

    public CustomerDatabase() {
        super();
    }

    //login the app
    public boolean logIn(String userName,String password) {
        String query = "SELECT custommer_id FROM online_store.custommer WHERE user_name='%s' AND customer_password='%s';";
        query = String.format(query,userName,password);

        try {
            Statement statement = getStatement();
            ResultSet set = statement.executeQuery(query);

            if (set.next())
                return true;

            //close connection
            super.closeConnection();

        } catch (SQLException e) {
            System.out.println("error while login ....");
        }

        return false;
    }

    public void register(Customer customer) {
        String query = "INSERT INTO `online_store`.`custommer`(`full_name`,`user_name`,`customer_password`)VALUES('%s','%s','%s');";
        query = String.format(query,customer.getFullName(),customer.getUserName(),customer.getPassword());

        try {
            Statement statement = getStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //is there the userName : for wen user wanna register
    public boolean isThereUserName(String userName) {
        String query = "SELECT user_name FROM online_store.custommer WHERE user_name='%s' ;";
        query = String.format(query,userName);


        try {
            Statement statement = getStatement();
            ResultSet set = statement.executeQuery(query);

            if (set.next())
                return true;

            super.closeConnection();

        } catch (SQLException e) {
            System.out.println("error while requesting to database ... ");
        }

        return false;
    }

    //get customerID by userName
    public int getCustomerIdByUserName(String userName) {
        int customerID = -1;

        String query = "SELECT custommer_id FROM custommer WHERE user_name = '%S';";
        query = String.format(query,userName);

        try {
            Statement statement = getStatement();
            ResultSet set       = statement.executeQuery(query);

            if (set.next())
                customerID = set.getInt("custommer_id");

        } catch (SQLException e) {
            System.out.println("error ...");
        }

        return customerID;
    }


}
