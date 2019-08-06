package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class check extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
    }

    public void checkAvailabilityBtnClicked(View view) {
        Toast.makeText(getApplicationContext(),"Available",Toast.LENGTH_SHORT).show();

    }
}
