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

//        EditText nt1 = findViewById(R.id.contactName);
//        EditText nt2 = findViewById(R.id.editText0);
//        EditText nt3 = findViewById(R.id.textaddress);
//        EditText nt4 = findViewById(R.id.textrooms);

        final EditText nt0 = findViewById(R.id.txt1);
       final EditText nt1 = findViewById(R.id.contactName);
       final EditText nt2 = findViewById(R.id.editText0);
       final EditText nt3 = findViewById(R.id.textaddress);
       final EditText nt4 = findViewById(R.id.textrooms);



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
        final Button upd = findViewById(R.id.button2);
       final Button del = findViewById(R.id.button3);
        //final EditText nt2 = findViewById(R.id.editText0);

        //final EditText t1 = findViewById(R.id.txt1);

        viw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Contact Us").child(nt0.getText().toString());
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
                } );



                upd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FirebaseDatabase.getInstance().getReference().child("cnt");

                DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("Contact Us");
                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            cnt ct =new cnt();

                        if(dataSnapshot.hasChild(nt0.getText().toString().trim())) {
                            try {
                              ct.setContactName(nt1.getText().toString().trim());
                                ct.setContactEmail(nt2.getText().toString().trim());
                               ct.setContactPhone(nt3.getText().toString().trim());
                                ct.setContactMessage(nt4.getText().toString().trim());

                                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Contact Us").child(nt0.getText().toString());
                                dbRef.setValue(ct);
                              //  clearControls();
                                Toast.makeText(getApplicationContext(), "Data update successfully!", Toast.LENGTH_SHORT).show();

                            } catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();

                            }
                        }

                            else
                                Toast.makeText(getApplicationContext(),"No source to update",Toast.LENGTH_SHORT).show();
                            }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                del.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        DatabaseReference delRef =  FirebaseDatabase.getInstance().getReference().child("Contact Us");

                        delRef.addListenerForSingleValueEvent((new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(nt1.getText().toString())){
                                    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("Contact Us").child(nt1.getText().toString());

                                        dbRef.removeValue();

                                        Toast.makeText(getApplicationContext(),"Data Deleted Successfully",Toast.LENGTH_SHORT).show();

                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"No Source to Delete",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        }));
                    }
                });


                    }
        });

                {


    }
            }
        });





   //  public void onUpdateButtonPush(View viw ){
    //   Intent update = new Intent(contactus2.this, contactus3.class);
    //    startActivity(update);
   // }


    }
  //  private  void clearControls(){
  //      contactName.setText("");
  //      contactEmail.setText("");
  //      contactPhone.setText("");
  //      contactMessage.setText("");
  //  }


}


