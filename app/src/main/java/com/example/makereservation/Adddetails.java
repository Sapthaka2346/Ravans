package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Adddetails extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddetails);

        button =(Button) findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                openActivity2();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, AddDetailsEdit.class);
        startActivity(intent);
    }
}
