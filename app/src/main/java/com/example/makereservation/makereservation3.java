package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class makereservation3 extends AppCompatActivity {
    Button fin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makereservation3);

        fin = (Button) findViewById(R.id.SUBMIT3);

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"dsf",Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), makereservation1.class);
                startActivity(i);
            }
        });
    }
}
