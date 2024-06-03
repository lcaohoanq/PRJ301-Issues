package model;

import java.util.HashMap;
import java.util.Map;

public class WishListDTO {

    private Map<String, MobileDTO> wishList;

    public WishListDTO() {
    }

    public WishListDTO(Map<String, MobileDTO> wishList) {
        this.wishList = wishList;
    }

    public Map<String, MobileDTO> getWishList() {
        return wishList;
    }

    public void setCart(Map<String, MobileDTO> wishList) {
        this.wishList = wishList;
    }

    public boolean add(MobileDTO mobile) {
        try {
            if (this.wishList == null) {
                this.wishList = new HashMap<>();
            }
            if (this.wishList.containsKey(mobile.getMobileId())) {
                int currentQuantity = this.wishList.get(mobile.getMobileId()).getQuantity();
                mobile.setQuantity(currentQuantity + mobile.getQuantity());
            }
            this.wishList.put(mobile.getMobileId(), mobile);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean change(String id, MobileDTO mobile) {
        boolean check = false;
        try {
            if (this.wishList != null) {
                if (this.wishList.containsKey(id)) {
                    this.wishList.replace(id, mobile);
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
            if (this.wishList != null) {
                if (this.wishList.containsKey(id)) {
                    this.wishList.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }

}
