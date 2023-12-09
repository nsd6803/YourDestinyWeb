package com.example.yourdestinyweb.models;

import java.util.List;

public class Order {
    private List<Appointment> items;
    private String email;
    private String address;
    private String time;


    public Order(List<Appointment> items, String email, String address, String time) {
        this.items = items;
        this.email = email;
        this.address = address;
        this.time = time;
    }

    public List<Appointment> getMeat() {
        return items;
    }

    public void setMeat(List<Appointment> meat) {
        this.items = meat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Your order:\n" +
                items + "\n" +
                "Address: " + address + "\n" +
                "Time: " + time;
    }
}
