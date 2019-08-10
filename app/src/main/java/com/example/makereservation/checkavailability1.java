package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class checkavailability1 extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkavailability1);

//        button =(Button) findViewById(R.id.button12);
//        button.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//
//                openActivity3();
//            }
//        });

    }
//    public void openActivity3() {
//        Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
//
//    }

    public void searchclicked(View view) {


        Intent i = new Intent(getApplicationContext(), checkavailability2.class);
        startActivity(i);
//        Intent intent = new Intent(this, checkavailability2.class);
//        startActivity(intent);
    }
}
