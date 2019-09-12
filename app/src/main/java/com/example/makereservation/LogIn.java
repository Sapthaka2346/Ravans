package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity {
    Button userloginbtn;
    Button btnlogin;
    Button adminloginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        userloginbtn = (Button) findViewById(R.id.userloginbtn);
        adminloginbtn=(Button)findViewById(R.id.adminloginbtn);

        userloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);

            }


        });
        adminloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Adddetails1.class);
                startActivity(i);
            }
        });

    }

    public void addDetasils(View v){

        Intent click =new Intent(this, Adddetails1.class);
        startActivity(click);
    }
}
