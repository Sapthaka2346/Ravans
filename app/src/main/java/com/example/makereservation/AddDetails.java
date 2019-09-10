package com.example.makereservation;

import java.util.Date;

public class AddDetails {


    private String Roomtype;
    private String Checkin;
    private String Checkout;
    private String Adults;
    private  String  Childs;
    private String Cost;


    public AddDetails() {
    }

    public String getRoomtype() {
        return Roomtype;
    }

    public void setRoomtype(String roomtype) {
        Roomtype = roomtype;
    }

    public String getCheckin() {
        return Checkin;
    }

    public void setCheckin(String checkin) {
        Checkin = checkin;
    }

    public String  getCheckout() {
        return Checkout;
    }

    public void setCheckout(String checkout) {
        Checkout = checkout;
    }

    public String getAdults() {
        return Adults;
    }

    public void setAdults(String adults) {
        Adults = adults;
    }

    public String getChilds() {
        return Childs;
    }

    public void setChilds(String childs) {
        Childs = childs;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }
}
