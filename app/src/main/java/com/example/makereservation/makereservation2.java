package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class makereservation2 extends AppCompatActivity {

    Button SUBMIT;
    private String FullName;
    private String Address;
    private int ContactNumber;
    private String checkin;
    private String checkout;

    public makereservation2() {
    }

    public Button getSUBMIT() {
        return SUBMIT;
    }

    public void setSUBMIT(Button SUBMIT) {
        this.SUBMIT = SUBMIT;
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

    public int getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(int contactNumber) {
        ContactNumber = contactNumber;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makereservation2);

        SUBMIT = (Button) findViewById(R.id.SUBMIT);

        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), makereservation3.class);
                startActivity(i);
            }
        });
    }
}

