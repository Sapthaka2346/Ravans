package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button Reservation;
    Button pay1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Reservation= (Button) findViewById(R.id.Reservation);


        Reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }

        });



    }
    //button on click
    public void clickv(View v){

            Intent click =new Intent(this,payment1.class);
            startActivity(click);
    }

    public void clickRooms(View v){

        Intent click =new Intent(this,Room.class);
        startActivity(click);
    }

}
