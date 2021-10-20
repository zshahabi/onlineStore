package input_and_output;

import database.CartDatabase;
import database.CustomerDatabase;
import database.ProductDatabase;

import java.util.Scanner;

public class InputFromUser {
    private Scanner scanner;
    private CartDatabase cartDatabase;

    public InputFromUser() {
        scanner      = new Scanner(System.in);
        cartDatabase = new CartDatabase();
    }

    //get Number from user (Integer)
    public int getNumber(String message, String format, String errorMessage) {

        System.out.println(message);
        String getFromUser = scanner.next();

        boolean isInputOk = getFromUser.matches(format);
        if (!isInputOk) {
            System.out.println(errorMessage);
            return getNumber(message, format, errorMessage);
        }

        return Integer.parseInt(getFromUser);
    }

    //get string with custom type
    public String getString(String message, String format, String errorMessage) {
        System.out.println(message);
        String valueFromUser = scanner.next();

        boolean isInputOk = valueFromUser.matches(format);

        if (!isInputOk) {
            System.out.println(errorMessage);
            return getString(message,format,errorMessage);
        }

        return valueFromUser;

    }

    //get userName for register : userName for register there should not be in database
    public String getUniqueUserName() {
        CustomerDatabase customerDatabase = new CustomerDatabase();

        String userName = "";
        boolean isThereUserName = true;

        do {
            //get userName from user
            userName        = getString("enter your userName : ","[a-zA-Z0-9]*","userName is incorrect ");
            //check userName that is there in database or not
            isThereUserName = customerDatabase.isThereUserName(userName);

            if (isThereUserName)
                System.out.println("sorry there is this userName in app . please enter other userName ");

        }while(isThereUserName);

        return userName;
    }

    //get product id
    public int getProductId() {
        ProductDatabase productDatabase = new ProductDatabase();

        System.out.println("enter product id : ");
        int productId = scanner.nextInt();

        if (!productDatabase.isThereThisProduct(productId)){
            System.out.println("your product id is incorrect ");
            return getProductId();
        }

        return productId;
    }

    //get count of product order
    public int getProductCount(int productId) {
        int count =  getNumber("enter count of product for adding ","[0-9]*","count is incorrect");

        if (!cartDatabase.isThereInDatabase(productId,count)) {
            System.out.println("sorry !!! \t there is not this product with count that you want .");
            return getProductCount(productId);
        }

        return count;
    }

}
