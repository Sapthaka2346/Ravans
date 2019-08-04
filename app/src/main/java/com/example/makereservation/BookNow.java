package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class BookNow extends AppCompatActivity {

    Button SUBMIT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);

        SUBMIT = (Button) findViewById(R.id.SUBMIT);

        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Finish.class);
                startActivity(i);
            }
        });
    }
}

