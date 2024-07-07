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
	private String url;

    public MobileDTO(String mobileId, float price, String description, int quantity, int notSale) {
        this.mobileId = mobileId;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.notSale = notSale;
    }

	public MobileDTO(String mobileId, String description, float price, String mobileName, int yearOfProduction, int quantity, int notSale) {
		this.mobileId = mobileId;
		this.description = description;
		this.price = price;
		this.mobileName = mobileName;
		this.yearOfProduction = yearOfProduction;
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
