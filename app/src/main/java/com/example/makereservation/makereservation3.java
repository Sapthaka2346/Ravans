package com.example.makereservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    EditText txtname,txtaddress,txtcontact,txtcheckin,txtcheckout,txtrooms,txtnic;
    Button btnupdate,btndelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makereservation3);



        final EditText t1 = findViewById(R.id.txtname);
        final EditText t2 = findViewById(R.id.txtnic);
        final EditText t3 = findViewById(R.id.txtcontact);
        final EditText t4 = findViewById(R.id.txtcheckin);
        final EditText t5 = findViewById(R.id.txtcheckout);
        final EditText t6 = findViewById(R.id.txtaddress);
        final EditText t7 = findViewById(R.id.txtrooms);


        final Button b1 = findViewById(R.id.btnshow);
        final Button b2 = findViewById(R.id.btndelete);
        final Button b3 = findViewById(R.id.btnupdate);

        //show code
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference readref = FirebaseDatabase.getInstance().getReference().child("MakeReservation").child("MakeReservation1");
                readref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            t1.setText(dataSnapshot.child("name").getValue().toString());
                            t6.setText(dataSnapshot.child("address").getValue().toString());
                            t2.setText(dataSnapshot.child("nic").getValue().toString());
                            t4.setText(dataSnapshot.child("checkin").getValue().toString());
                            t5.setText(dataSnapshot.child("checkout").getValue().toString());
                            t7.setText(dataSnapshot.child("rooms").getValue().toString());
                            t3.setText(dataSnapshot.child("contact").getValue().toString());

                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to Display",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                // update code

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DatabaseReference upref = FirebaseDatabase.getInstance().getReference().child("MakeReservation") ;
                        upref.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.hasChild("makereservation0")){
                                  try{
                                      makereservation.setnic(txtnic.getText().toString().trim());
                                      makereservation.setname(txtname.getText().toString().trim());
                                      makereservation.setaddress(txtaddress.getText().toString().trim());
                                      makereservation.setcheckin(txtcheckin.getText().toString().trim());
                                      makereservation.setcheckout(txtcheckout.getText().toString().trim());
                                      makereservation.setrooms(Integer.parseInt(txtrooms.getText().toString().trim()));
                                      makereservation.setcontact(Integer.parseInt(txtcontact.getText().toString().trim()));

                                    //  dbref = FirebaseDatabase.getInstance().getReference().child("MakeReservation").child("MakeReservation1");
                                  //    dbRef.setVale(makereservation);
                                    //  clearControls();
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
                                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("MakeReservation");



                            @Override
                            public void onClick(View view) {

                            }
                        });
                    }
                });

            }
        });
    }
}
