package sample.cart;

import java.util.HashMap;
import java.util.Map;

import sample.product.ProductDTO;

public class CartDTO {

  private Map<String, ProductDTO> cart;

  public CartDTO() {
  }

  public CartDTO(Map<String, ProductDTO> cart) {
    this.cart = cart;
  }

  public Map<String, ProductDTO> getCart() {
    return cart;
  }

  public void setCart(Map<String, ProductDTO> cart) {
    this.cart = cart;
  }

  public boolean add(ProductDTO product) {
    try {
      if (this.cart == null) {
        this.cart = new HashMap<>();
      }
      if (this.cart.containsKey(product.getId())) {
        int currentQuantity = this.cart.get(product.getId()).getQuantity();
        product.setQuantity(currentQuantity + product.getQuantity());
      }
      this.cart.put(product.getId(), product);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return false;
  }

  public boolean change(String id, ProductDTO mobile) {
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
