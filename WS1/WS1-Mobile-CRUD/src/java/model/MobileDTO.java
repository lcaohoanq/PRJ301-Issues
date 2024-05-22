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

    
}
