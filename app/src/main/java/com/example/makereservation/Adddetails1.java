package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Adddetails1 extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddetails1);

        button =(Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                openActivity2();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, AddDetails2.class);
        startActivity(intent);
    }
}
