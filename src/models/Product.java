package models;

import enums.Availability_status;

import java.util.List;

public class Product {
    private int                 productId;
    private String              productName ;
    private double              productPrice;
    private int                 productCount;
    private Availability_status availability_status;
    private Category            category;
    private List<ProductConfig> productConfig;

    public Product(int productId, String productName, double productPrice, int productCount, Availability_status availability_status, Category category, List<ProductConfig> productConfig) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.availability_status = availability_status;
        this.category = category;
        this.productConfig = productConfig;
    }

    public Product(String productName, double productPrice, int productCount, Availability_status availability_status, Category category, List<ProductConfig> productConfig) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.availability_status = availability_status;
        this.category = category;
        this.productConfig = productConfig;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public Availability_status getAvailability_status() {
        return availability_status;
    }

    public void setAvailability_status(Availability_status availability_status) {
        this.availability_status = availability_status;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCount=" + productCount +
                ", availability_status=" + availability_status +
                ", category=" + category.toString() +
                ", productConfig=" + productConfig.toString() +
                '}';
    }
}
