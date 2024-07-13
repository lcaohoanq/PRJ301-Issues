/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.prj301.shopping;

/**
 *
 * @author hd
 */
public class Products {

    private String productID;
    private String productName;
    private String description;
    private float price;
    private int status;
    private int quantity = 1;

    public Products(String productID, String productName, String description, float price, int status) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public Products(String productName, String description, float price, int status) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public Products(String productName, float price) {
        this.productName = productName;
        this.price = price;
    }
    
    
    

    public Products() {
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

    public int getQuantity() {
        return quantity;
    }
    
    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Products{" + "productID=" + productID + ", productName=" + productName + ", description=" + description + ", price=" + price + ", status=" + status + '}';
    }

}
