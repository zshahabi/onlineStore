import database.CartDatabase;
import database.ProductDatabase;
import models.Cart;
import models.PriceItemInCart;
import models.Product;

import java.util.List;

public class ShopOperations {

    private ProductDatabase productDatabase ;
    private CartDatabase cartDatabase;

    public ShopOperations() {
        productDatabase = new ProductDatabase();
        cartDatabase    = new CartDatabase();
    }

    //int menu 1 : adding new order => called in Main
    public void addNewOrderToCart(int productId,int count) {
        cartDatabase.addNewOrderToCart(productId,count);
        System.out.println("adding done successfully");
    }

    // in menu 2 : delete order from cart
    public void deleteOrderFromCart(int orderID) {
        cartDatabase.deleteOrderFromCart(orderID);
    }

    //in menu 3 : print all products in my cart
    public List<Cart> getAllProductInMyCart() {
        return cartDatabase.getProductInCart();
    }

    //in menu 4 : print price list in cart
    public List<PriceItemInCart> getPriceListInCart() {
        //todo
        return null;
    }

    //in menu 5 : confirm order
    public void confirmOrder() {
        //todo
    }

    //in menu 6 : get products in shop
    public List<Product> getShopProducts() {
        //todo
        return null;
    }

    //get all products : for showing to user while user wanna add new order
    public List<Product> getAllProducts() {
        //get all products from database
        return productDatabase.getAllProducts();
    }



}
