package models;

public class ProductDTO {

    private String productID;
    private String productName;
    private String description;
    private float price;
    private int status;

    public ProductDTO(String productID, String productName, String description, float price, int status) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productID=" + productID + ", productName=" + productName + ", description=" + description + ", price=" + price + ", status=" + status + '}';
    }

}
