package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MobileDTO {

    private String mobileId;
    private String description;
    private float price;
    private String mobileName;
    private int yearOfProduction;
    private int quantity;
    private int notSale;

    public MobileDTO(String mobileId, float price, String description, int quantity, int notSale) {
        this.mobileId = mobileId;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.notSale = notSale;
    }

    public MobileDTO(String mobileId, float price, String mobileName, int quantity) {
        this.mobileId = mobileId;
        this.price = price;
        this.mobileName = mobileName;
        this.quantity = quantity;
    }
    
    

}
