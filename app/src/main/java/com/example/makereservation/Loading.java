package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Thread background = new Thread(){
            public void run(){
                try{
                    sleep(5*1000);

                    Intent i = new Intent(getBaseContext(),LogIn.class);
                    startActivity(i);
                    finish();
                }catch (Exception e){

                }
            }
        };
        background.start();
    }
}
