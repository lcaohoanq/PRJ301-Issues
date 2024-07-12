package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    /*
    [productID] [char](5) NOT NULL,
	[productName] [varchar](50) NOT NULL,
	[description] [varchar](500) NOT NULL,
	[price] [float] NOT NULL,
	[status] [bit] NOT NULL,
     */

    private String productID;
    private String productName;
    private String description;
    private float price;
    private int status;
    
    public static void main(String[] args) {
        System.out.println(new ProductDTO("1", "Porsche", "Car", 500, 1));
    }

}
