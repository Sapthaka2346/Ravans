package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button Reservation;
    Button pay1, contactBtn;
    Button payprocces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Reservation= (Button) findViewById(R.id.Reservation);


        Reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), makereservation1.class);
                startActivity(i);
            }

        });

        payprocces = findViewById(R.id.continuebtn);

        payprocces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),paymentnew.class);
                startActivity(intent);

            }
        });


    }
    //button on click

    public void clickRooms(View v){

        Intent click =new Intent(this, checkavailability1.class);
        startActivity(click);
    }

    public void contactUsClick(View view) {
        Intent click =new Intent(this, contactus1.class);
        startActivity(click);

    }
}
