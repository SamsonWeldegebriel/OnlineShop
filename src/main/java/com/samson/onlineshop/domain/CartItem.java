package com.samson.onlineshop.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {

    private String id;
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem() {

    }

    public CartItem(String id, Product product, int quantity, BigDecimal totalPrice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
