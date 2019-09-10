package com.example.makereservation;

public class makereservation {
    private String FullName;
    private String Address;
    private int Contactnumber;
    private String checkin;
    private String checkout;
    private String nic;
    private int rooms;

    public makereservation() {
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getContactnumber() {
        return Contactnumber;
    }

    public void setContactnumber(int contactnumber) {
        Contactnumber = contactnumber;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
}
