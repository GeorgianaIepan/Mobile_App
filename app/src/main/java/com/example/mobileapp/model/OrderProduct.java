package com.example.mobileapp.model;

public class OrderProduct {
    private int idOrderProduct;
    private int order;
    private int product;
    private int quantity;

    public OrderProduct(int idOrderProduct, int order, int product, int quantity) {
        this.idOrderProduct = idOrderProduct;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderProduct() {

    }

    public int getIdOrderProduct() {
        return idOrderProduct;
    }

    public void setIdOrderProduct(int idOrderProduct) {
        this.idOrderProduct = idOrderProduct;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "idOrderProduct=" + idOrderProduct +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
