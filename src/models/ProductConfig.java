package models;

public class ProductConfig {
    private int productConfigId;
    private String mark,value;

    public ProductConfig(int productConfigId, String mark, String value) {
        this.productConfigId = productConfigId;
        this.mark = mark;
        this.value = value;
    }

    public ProductConfig(String mark, String value) {
        this.mark = mark;
        this.value = value;
    }

    public int getProductConfigId() {
        return productConfigId;
    }

    public void setProductConfigId(int productConfigId) {
        this.productConfigId = productConfigId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProductConfig{" +
                "productConfigId=" + productConfigId +
                ", mark='" + mark + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
