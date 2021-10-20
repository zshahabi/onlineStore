package input_and_output;

import models.Cart;
import models.PriceItemInCart;
import models.Product;

import java.util.List;

public class Print {

    //print products
    public void printProducts(List<Product> products) {
        for (Product product:products) {
            System.out.println(product.toString());
        }

    }

    //print prices items
    public void printPricesItems(List<PriceItemInCart> priceItemInCarts) {
        for (PriceItemInCart item:priceItemInCarts) {
            System.out.println(item.toString());
        }
    }

    //print carts
    public void printCarts(List<Cart> carts) {
        for (Cart cart:carts) {
            System.out.println(cart.toString());
        }
    }

}
