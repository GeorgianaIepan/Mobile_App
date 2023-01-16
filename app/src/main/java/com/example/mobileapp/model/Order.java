package com.example.mobileapp.model;

public class Order {
    private int idOrder;
    private int user;
    private String address;

    public Order(int idOrder, int user, String address) {
        this.idOrder = idOrder;
        this.user = user;
        this.address = address;
    }

    public Order() {

    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", user=" + user +
                ", address='" + address + '\'' +
                '}';
    }
}
