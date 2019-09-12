package com.example.makereservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

        public void Resavation(View view)
        {
            Intent i1 = new Intent (Home.this,makereservation.class);
            startActivity(i1);
        }

     //   public void Rates(View view)
     //   {
      //      Intent i1 = new Intent (Home.this,.class);
     //       startActivity(i1);
     //   }


     //   public void room(View view)
     //   {
     //       Intent i1 = new Intent (Home.this,.class);
     //       startActivity(i1);
    //}

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

