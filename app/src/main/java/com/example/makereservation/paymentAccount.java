package com.example.makereservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class paymentAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_account);

        final TextView p1 = findViewById(R.id.rid);
        final TextView p2 = findViewById(R.id.cno);
        final TextView p3 = findViewById(R.id.nd);
        final TextView p4 = findViewById(R.id.Cvcd);
        final TextView p5 = findViewById(R.id.dd);

        Button btnView = findViewById(R.id.button10);


        //View Method//

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reafRef = FirebaseDatabase.getInstance().getReference().child("payment").child(p1.getText().toString());
                reafRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChildren()) {
                            p2.setText(dataSnapshot.child("cno").getValue().toString());
                            p3.setText(dataSnapshot.child("nam").getValue().toString());
                            p4.setText(dataSnapshot.child("cvc").getValue().toString());
                            p5.setText(dataSnapshot.child("exday").getValue().toString());
                            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getApplicationContext(), "No source to display", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        }

    public void pay2(View view){

        Intent second = new Intent(getApplicationContext(), payment3.class);
        startActivity(second);

    }
    }