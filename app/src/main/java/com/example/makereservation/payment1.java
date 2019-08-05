package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class payment1 extends AppCompatActivity {

    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment1);

        b1 = findViewById(R.id.bookNowBtn7);

        Intent n1 = getIntent();

        String s2=((Intent)n1).getStringExtra("First text");

    }

    public void clickv(View v){

        Intent click =new Intent(this,payment2.class);
        startActivity(click);
    }
}
