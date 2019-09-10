package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class makereservation4 extends AppCompatActivity {

    private Button InsertButton;
    private Button DeleteorUpdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makereservation4);


        InsertButton = (Button) findViewById(R.id.btninsert);
        DeleteorUpdateButton = (Button) findViewById(R.id.btndelorup);

        InsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), makereservation2.class);
                startActivity(i);
            }
        });

        DeleteorUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), makereservation3.class);
                startActivity(i);


            }


        });
    }
}




