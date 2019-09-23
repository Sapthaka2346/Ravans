package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class makereservation1 extends AppCompatActivity {
    Button bookNowButton;
    //Button button5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makeresrvation1);

       // button5 = findViewById(R.id.button5);

//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(getApplicationContext(),Makereservationadmin.class);
//                startActivity(intent);
//
//            }
//        });

        bookNowButton = (Button) findViewById(R.id.bookNowBtn);

        bookNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), makereservation4.class);
                startActivity(i);
            }

        });
    }

   public void puka(View view)
    {
        Intent i1 = new Intent (makereservation1.this,Makereservationadmin.class);
       startActivity(i1);
   }
}