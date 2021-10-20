import entry.Login;
import input_and_output.InputFromUser;
import input_and_output.Print;
import models.Cart;
import models.PriceItemInCart;
import models.Product;

import java.util.Calendar;
import java.util.List;


public class Main {

    private Login login;
    private InputFromUser  inputFromUser;
    private ShopOperations shopOperations;
    private Print          print;

    public static void main(String[] args) {
        Main obj           = new Main();
        obj.inputFromUser  = new InputFromUser();
        obj.shopOperations = new ShopOperations();
        obj.print          = new Print();

        System.out.println("welcome to this online store \n\n");

        //register or login (wen app run )
        obj.login = new Login(); // login and register operation will be done in constructor


        while (obj.showMainMenu());

    }

    //show main menu
    private boolean showMainMenu() {
        int itemChosen = inputFromUser.getNumber("1.add new order\n2.delete order from cart\n3.print all products in my chart\n" +
                "4.print price of all products in cart\n5.confirm order\n6.print products in this shop\n7.exit ","[1-7]*","item selection is incorrect");
        switch (itemChosen) {
            case 1:
                //get products from database and print that
                List<Product> products = shopOperations.getAllProducts();
                print.printProducts(products);

                //get productID of userProduct and add to customer cart
                int productId = inputFromUser.getProductId();
                int count     = inputFromUser.getProductCount(productId);
                shopOperations.addNewOrderToCart(productId,count);
                break;

            case 2:
                //get orderID of order in cart and delete that from user cart
                int cartID = inputFromUser.getProductId();
                shopOperations.deleteOrderFromCart(cartID);
                break;

            case 3:
                //get products in customer cart and print theme
                List<Cart> carts= shopOperations.getAllProductInMyCart();
                print.printCarts(carts);
                break;

            case 4:
                //get product details for getting 1.productName 2.productPrice 3.productCount
                List<PriceItemInCart> priceLists = shopOperations.getPriceListInCart();
                print.printPricesItems(priceLists);
                break;

            case 5:
                //confirm order
                shopOperations.confirmOrder();
                break;

            case 6:
                //get products in shop and print
                products = shopOperations.getShopProducts();
                print.printProducts(products);
                break;

            case  7:
                System.out.println("goodBye");
                return false;

        }
        return true;
    }


}
