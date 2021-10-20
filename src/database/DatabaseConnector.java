package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseConnector {
    private Connection connection;

    protected DatabaseConnector() {
    }

    //get connection
    protected Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/online_store", "root", "zo60na84");

        } catch (ClassNotFoundException e) {
            System.out.println("error while connecting to database (error for library) ");
        } catch (SQLException throwables) {
            System.out.println("error while connecting to database (your userName or password for mySql is not vaild)");
        }

        return connection;
    }

    //get statement
    protected Statement getStatement() {
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
        } catch (SQLException e) {
            System.out.println("error while connecting to database ... (wen getStatement)");
        }
        return statement;
    }


    //closing connection
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("error while closing database communication");
        }
    }

}
