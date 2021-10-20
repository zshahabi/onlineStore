package models;

public class PriceItemInCart {
    private String productName ;
    private double productPrice;
    private int    productCount;

    public PriceItemInCart(String productName, double productPrice, int productCount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "PriceItemInCart{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCount=" + productCount +
                '}';
    }
}
