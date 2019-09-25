package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Addddmiiiinnn extends AppCompatActivity {

    private Button cntbtn;
    private Button pybtn;
    private Button adbtn;
    private Button mkrbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addddmiiiinnn);

        cntbtn = (Button) findViewById(R.id.cntbtn);
        pybtn = (Button) findViewById(R.id.pybtn);
        adbtn = (Button) findViewById(R.id.adbtn);
        mkrbtn=(Button) findViewById(R.id.button6);


       cntbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencontactus3();

            }

        });
       pybtn.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
               openpaymentnew();
            }
        });
        adbtn.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                openadddetails1();
            }
        });
//     //   mkrbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openmakereservationadmin();
//            }
//        });


    }
    public void opencontactus3(){
        Intent intent = new Intent(this, contactus3.class);
        startActivity(intent);
    }

    public void openpaymentnew(){
        Intent intent = new Intent(this, viewpaymentdetails.class);
        startActivity(intent);
    }
    public void openadddetails1(){
        Intent intent = new Intent(this,Adddetails1.class);
        startActivity(intent);
    }

    public void Reserve(View view)
    {
        Intent i1 = new Intent (Addddmiiiinnn.this,Makereservationadmin.class);
        startActivity(i1);
    }
}
