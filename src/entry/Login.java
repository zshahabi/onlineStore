package entry;

import database.CustomerDatabase;
import input_and_output.InputFromUser;
import models.Customer;

public class Login {
    public static String userName,password; // customer userName and customer Password
    public static  int    customerID ;  //customer ID

    private InputFromUser inputFromUser;
    private CustomerDatabase customerDatabase;


    //asking register or login and calling the method in constructor
    public Login () {
        inputFromUser    = new InputFromUser();
        customerDatabase = new CustomerDatabase();

        int itemChosen = inputFromUser.getNumber("1.login\n2.register","[12]*","please select your item correctly");
        if (itemChosen == 1)
            login();
        else
            register();
    }


    //user login in app
    private void login() {
        String userName = inputFromUser.getString("enter your userName :","[a-zA-Z0-9]*","userName in not correct");
        String password = inputFromUser.getString("enter your password :","[a-zA-Z0-9]*"
                ,"password in not correct ");

        boolean isLoggedIn = customerDatabase.logIn(userName,password); //checking login is ok
        if (!isLoggedIn){ //if login was not ok
            System.out.println("your userName or password is incorrect . ");

            int registerOrLogin = inputFromUser.getNumber("1.login\n2.register","[12]*","select your item correctly (between 1 ,2 )");
            if (registerOrLogin ==1)
                login();
            else
                register();

        }
        else { //
            System.out.println("login successfully");

            this.userName = userName;
            this.password = password;
            this.customerID = customerDatabase.getCustomerIdByUserName(userName);
        }

        customerDatabase.closeConnection();
    }

    //user register in app
    private void register() {
        String firstName = inputFromUser.getString("enter your firstName :","[a-zA-Z]*","first name is incorrect");
        String lastName  = inputFromUser.getString("enter your lastName  :","[a-zA-Z]*","last name is incorrect");
        String fullName  = firstName+" "+lastName;
        String userName  = inputFromUser.getUniqueUserName(); // get unique userName
        String password  = inputFromUser.getString("enter your password :","[a-zA-Z0-9]*"
                ,"password in not correct ");


        customerDatabase.register(new Customer(fullName,userName,password));

        //get customerID of this customer
        this.customerID = customerDatabase.getCustomerIdByUserName(userName);

        customerDatabase.closeConnection();
    }

}
