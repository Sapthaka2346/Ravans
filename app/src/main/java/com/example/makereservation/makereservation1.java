package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class makereservation1 extends AppCompatActivity {
    Button bookNowButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makeresrvation1);

        bookNowButton = (Button) findViewById(R.id.bookNowBtn);

        bookNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), makereservation2.class);
                startActivity(i);
            }

        });
    }
}