package models;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private Map<String ,BookDTO> cart;

    public CartDTO(Map<String, BookDTO> cart) {
        this.cart = cart;
    }

    public CartDTO() {
    }

    public Map<String, BookDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, BookDTO> cart) {
        this.cart = cart;
    }
    
    public boolean add(BookDTO book){
        boolean check = false;
        try {
            if(this.cart==null){
                this.cart = new HashMap<>();
            }
            //if existing item in cart, addition the quantity
            if(this.cart.containsKey(book.getId())){
                //hasmap get(key) -> value = BookDTO.getQuantity();
                int oldquantity = this.cart.get(book.getId()).getQuantity();
                int newquantity = book.getQuantity();
                book.setQuantity(newquantity+oldquantity);
            }
            //else put whole  
            this.cart.put(book.getId(), book);
            check=true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
    
    public boolean remove(String id){
        boolean check = false;
        try {
            if(this.cart!=null){
                if(this.cart.containsKey(id)){
                    this.cart.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return check;
    }
    
}
