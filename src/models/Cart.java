package models;

import java.util.List;

public class Cart {
    private int cartId ;
    private int productCount;
    private int productId;
    private int customerId;
    private Product product;


    public Cart(int cartId, int productCount, int productId, int customerId, Product product) {
        this.cartId = cartId;
        this.productCount = productCount;
        this.productId = productId;
        this.customerId = customerId;
        this.product = product;
    }

    public Cart(int productCount, int productId, int customerId, Product product, Customer customer) {
        this.productCount = productCount;
        this.productId = productId;
        this.customerId = customerId;
        this.product = product;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", productCount=" + productCount +
                ", productId=" + productId +
                ", customerId=" + customerId +
                ", product=" + product +
                '}';
    }
}