package com.samson.onlineshop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Cart implements Serializable {
    private String id;
    private List<CartItem> cartItems;
    private BigDecimal grandTotal;

    public Cart() {
    }

    public Cart(String id, List<CartItem> cartItems, BigDecimal grandTotal) {
        this.id = id;
        this.cartItems = cartItems;
        this.grandTotal = grandTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }
}
