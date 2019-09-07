package com.example.makereservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class contactus2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus2);

       final EditText nt1 = findViewById(R.id.contactName);
       final EditText nt2 = findViewById(R.id.editText0);
       final EditText nt3 = findViewById(R.id.editText10);
       final EditText nt4 = findViewById(R.id.editText11);

        Intent intent2 = getIntent();

        String s1 = intent2.getStringExtra("Cname");
        String s2 = intent2.getStringExtra("Cemail");
        String s3 = intent2.getStringExtra("Cphone");
        String s4 = intent2.getStringExtra("Cmessage");

        nt1.setText(s1);
        nt2.setText(s2);
        nt3.setText(s3);
        nt4.setText(s4);

        Button viw = findViewById(R.id.button14);
        final EditText t1 = findViewById(R.id.txt);

        viw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("cnt").child(t1.getText().toString());
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            nt1.setText(dataSnapshot.child("contactName").getValue().toString());
                            nt2.setText(dataSnapshot.child("contactEmail").getValue().toString());
                            nt3.setText(dataSnapshot.child("contactPhone").getValue().toString());
                            nt4.setText(dataSnapshot.child("contactMessage").getValue().toString());
                            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();

                        }
                        else{
                            Toast.makeText(getApplicationContext(),"No source to display",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                } );{

                };

            }
        }); {

    }

 //    public void onUpdateButtonPush(View view ){
   //     Intent update = new Intent(contactus2.this, contactus3.class);
    //    startActivity(update);
    //}

    }
}
