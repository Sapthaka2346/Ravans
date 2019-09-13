package com.example.makereservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    Button send;
    private Button bookNowBtn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bookNowBtn6 = (Button) findViewById(R.id.bookNowBtn6);

        bookNowBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencheckavailable1();
            }
        });

    }
    public void opencheckavailable1(){
        Intent intent = new Intent(this, checkavailability1.class);
        startActivity(intent);
    }


        public void Resavation(View view)
        {
            Intent i1 = new Intent (Home.this,makereservation1.class);
            startActivity(i1);
        }

        public void Gallery(View view)
        {
            Intent i1 = new Intent (Home.this,slideshowGallary.class);
            startActivity(i1);
        }


       public void room(View view)
      {
           Intent i1 = new Intent (Home.this,checkavailability1.class);
           startActivity(i1);
    }

        public void contact(View view)
        {
            Intent i1 = new Intent (Home.this,contactus1.class);
            startActivity(i1);
        }

        public void Payment(View view)
        {
            Intent i1 = new Intent (Home.this,paymentnew.class);
            startActivity(i1);
        }

     //   public void facilities(View view){
     //       Intent intent = new Intent(Home.this,.class);
     //       startActivity(intent);
     //   }

    }

