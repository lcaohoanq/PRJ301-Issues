package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileError {
    private String mobileId;
    private String description;
    private String price;
    private String mobileName;
    private String yearOfProduction;
    private String quantity;
    private String notSale;
}
