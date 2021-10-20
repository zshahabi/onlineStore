package models;

public class Shop {
    private int shopId;
    private int count;
    private int productId;

    public Shop(int shopId, int count, int productId) {
        this.shopId = shopId;
        this.count = count;
        this.productId = productId;
    }

    public Shop(int count, int productId) {
        this.count = count;
        this.productId = productId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
