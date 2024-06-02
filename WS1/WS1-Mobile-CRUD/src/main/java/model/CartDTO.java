package model;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {

    private Map<String, MobileDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, MobileDTO> cart) {
        this.cart = cart;
    }

    public Map<String, MobileDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, MobileDTO> cart) {
        this.cart = cart;
    }

    public boolean add(MobileDTO mobile) {
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(mobile.getMobileId())) {
                int currentQuantity = this.cart.get(mobile.getMobileId()).getQuantity();
                mobile.setQuantity(currentQuantity + mobile.getQuantity());
            }
            this.cart.put(mobile.getMobileId(), mobile);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean change(String id, MobileDTO mobile) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.replace(id, mobile);
                    check = true;
                }
            }
        } catch (Exception e) {
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
        }
        return check;
    }

}
