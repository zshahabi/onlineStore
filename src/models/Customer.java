package models;

public class Customer {
    private int customerId ;
    private String fullName;
    private String userName ;
    private String password;

    //for getting from database
    public Customer(int customerId, String fullName, String userName, String password) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
    }

    //for inserting to database : because id is autoincrement
    public Customer(String fullName, String userName, String password) {
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}