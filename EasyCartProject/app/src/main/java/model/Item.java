package model;

public class Item {
    private int quantity;
    private Products product;
    private Float totalPrice;

    public Item() {
    }

    public Item(int quantity, Products product, Float totalPrice) {
        this.quantity = quantity;
        this.product = product;
        this.totalPrice = totalPrice;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Float getTotalPrice() {
        totalPrice = quantity * product.getPrice();
        return totalPrice;
    }

    public void setTotalPrice() {
        
        totalPrice = quantity * product.getPrice();
    }

    

    @Override
    public String toString() {
        return "Item{" + "quantidade=" + quantity + ", product=" + product + ", totalPrice=" + totalPrice + '}';
    }
    
    
}
