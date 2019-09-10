package com.example.makereservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class makereservation3 extends AppCompatActivity {
    EditText txtname,txtaddress,txtcontact,txtcheckin,txtcheckout,txtrooms,txtnic,txtsearch;
    Button btnupdate,btndelete;

     EditText t1, t2, t3, t4, t5, t6, t7, t8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makereservation3);



          t1 = findViewById(R.id.textnic);
          t2 = findViewById(R.id.textfullname);
          t3 = findViewById(R.id.Cv);
          t4 = findViewById(R.id.textaddress);
          t5 = findViewById(R.id.textcheckin);
          t6 = findViewById(R.id.textcheckout);
          t7 = findViewById(R.id.textrooms);
          t8= findViewById(R.id.txtsearch);


        final Button b1 = findViewById(R.id.btnshow);
        final Button b2 = findViewById(R.id.btndelete);
        final Button b3 = findViewById(R.id.btnupdate);

        //show code
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(TextUtils.isEmpty(t8.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Fill search", Toast.LENGTH_SHORT).show();
                }else {

                    try {
                        DatabaseReference readref = FirebaseDatabase.getInstance().getReference().child("MakeReservation").child(t8.getText().toString());
                        readref.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.hasChildren()) {

                                    t1.setText(dataSnapshot.child("nic").getValue().toString());
                                    t6.setText(dataSnapshot.child("checkout").getValue().toString());
                                    t2.setText(dataSnapshot.child("fullName").getValue().toString());
                                    t4.setText(dataSnapshot.child("address").getValue().toString());
                                   t5.setText(dataSnapshot.child("checkin").getValue().toString());
                                    t7.setText(dataSnapshot.child("rooms").getValue().toString());
                                    t3.setText(dataSnapshot.child("contactnumber").getValue().toString());
                                    Toast.makeText(getApplicationContext(), "Show Successfully", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "No Source to Display", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Intent i = new Intent(getApplicationContext(), makereservation4.class);
                                startActivity(i);
                            }
                        });


                    } catch (Exception ex) {
                        Toast.makeText(getApplicationContext(), "Error occured.", Toast.LENGTH_SHORT).show();
                    /*Intent i = new Intent(getApplicationContext(), makereservation4.class);
                    startActivity(i);*/
                    }
                }

                // update code

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatabaseReference upref = FirebaseDatabase.getInstance().getReference().child("MakeReservation") ;
                        upref.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild(t1.getText().toString().trim())){
                                  try{
                                      makereservation resObj = new makereservation();

                                      resObj.setNic(t1.getText().toString().trim());
                                      resObj.setFullName(t2.getText().toString().trim());
                                      resObj.setAddress(t4.getText().toString().trim());
                                      resObj.setCheckin(t5.getText().toString().trim());
                                      resObj.setCheckout(t6.getText().toString().trim());
                                      resObj.setRooms(Integer.parseInt(t7.getText().toString().trim()));
                                      resObj.setContactnumber(Integer.parseInt(t3.getText().toString().trim()));

                                      DatabaseReference upref1 = FirebaseDatabase.getInstance().getReference().child("MakeReservation");
                                      upref1.child(t1.getText().toString().trim()).setValue(resObj);

                                      //Feedback to the user via a toast...
                                      Toast.makeText(getApplicationContext(),"Data Updated Successfully",Toast.LENGTH_SHORT).show();



                                  }catch(NumberFormatException e){
                                      Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_SHORT).show();
                                  }
                                }else
                                    Toast.makeText(getApplicationContext(),"No Source to Update",Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });

                        //Delete Code
                        b2.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {
                                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("MakeReservation");
                                 delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                     @Override
                                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                         if (dataSnapshot.hasChild(t8.getText().toString())){
                                             DatabaseReference dbRef= FirebaseDatabase.getInstance().getReference().child("MakeReservation").child(t1.getText().toString());

                                             dbRef.removeValue();

                                             Toast.makeText(getApplicationContext(),"Data Deleted Successfully!",Toast.LENGTH_SHORT).show();
                                         }else{
                                             Toast.makeText(getApplicationContext(),"No Source to Delete",Toast.LENGTH_SHORT).show();
                                         }

                                         Intent i = new Intent(getApplicationContext(), makereservation4.class);
                                         startActivity(i);

                                     }

                                     @Override
                                     public void onCancelled(@NonNull DatabaseError databaseError) {

                                     }
                                 });


                            }
                        });
                    }
                });

            }
        });
    }
}
