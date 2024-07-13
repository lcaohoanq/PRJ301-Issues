/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.prj301.shopping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hd
 */
public class Cart {

    private Map<String, Products> cart;

    public Cart(Map<String, Products> cart) {
        this.cart = cart;
    }

    public Cart() {
    }

    public Map<String, Products> getCart() {
        return cart;
    }

    public void setCart(Map<String, Products> cart) {
        this.cart = cart;
    }

    public boolean add(Products product) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            //if existing item in cart, addition the quantity
            if (this.cart.containsKey(product.getProductID())) {
                //hasmap get(key) -> value = Products.getQuantity();
                int oldquantity = this.cart.get(product.getProductID()).getQuantity();
                int newquantity = product.getQuantity();
                product.setQuantity(newquantity + oldquantity);
            }
            //else put whole  
            this.cart.put(product.getProductID(), product);
            check = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return check;
    }

    public boolean remove(String id) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
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
