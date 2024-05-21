/*
 * To change this licens header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.book;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
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
            if(this.cart.containsKey(book.getId())){
                int oldquantity = this.cart.get(book.getId()).getQuantity();
                int newquantity = book.getQuantity();
                book.setQuantity(newquantity+oldquantity);
            }
            this.cart.put(book.getId(), book);
            check=true;
        } catch (Exception e) {
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
        }
        return check;
    }
    
}
