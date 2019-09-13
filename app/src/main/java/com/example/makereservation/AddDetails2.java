package com.example.makereservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class AddDetails2 extends AppCompatActivity {


    EditText txtRoomtype,txtCheckin,txtCheckOut,txtAdult,txtChild,txtCost, txtSearch;
    Button btnUpdate,btnDelete,btnShow;
    DatabaseReference dbRef;
    AddDetails addDetails1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddetails2);

        txtRoomtype = findViewById(R.id.rt1);
        txtCheckin = findViewById(R.id.CvcID);
        txtCheckOut = findViewById(R.id.NamID);
        txtAdult = findViewById(R.id.EdayID);
        txtChild = findViewById(R.id.c1);
        txtCost = findViewById(R.id.co1);
        //txtSearch = findViewById(R.id.search);

        btnUpdate = findViewById(R.id.btnadd);
        btnDelete = findViewById(R.id.btndelete);
        btnShow = findViewById(R.id.btnshow);

        addDetails1 = new AddDetails();

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(btnShow.getText().toString())){
                    Toast.makeText(getApplicationContext(), "fill search", Toast.LENGTH_SHORT).show();
                }else{
                    try{
                        DatabaseReference readref = FirebaseDatabase.getInstance().getReference().child("AddDeatils").child(txtRoomtype.getText().toString());
                        readref.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.hasChildren()){
                                    txtRoomtype.setText(dataSnapshot.child("roomtype").getValue().toString());
                                    txtCheckin.setText(dataSnapshot.child("checkin").getValue().toString());
                                    txtCheckOut.setText(dataSnapshot.child("checkout").getValue().toString());
                                    txtAdult.setText(dataSnapshot.child("adults").getValue().toString());
                                    txtChild.setText(dataSnapshot.child("childs").getValue().toString());
                                    txtCost.setText(dataSnapshot.child("cost").getValue().toString());
                                    Toast.makeText(getApplicationContext(), "show successfully", Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(getApplicationContext(), "no source to display", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }catch(Exception ex){
                        Toast.makeText(getApplicationContext(), "error occured", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DatabaseReference updateRef = FirebaseDatabase.getInstance().getReference().child("AddDeatils");
                updateRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(txtRoomtype.getText().toString())){
                            addDetails1.setRoomtype(txtRoomtype.getText().toString());
                            addDetails1.setCheckin(txtCheckin.getText().toString());
                            addDetails1.setCheckout(txtCheckOut.getText().toString());
                            addDetails1.setAdults(txtAdult.getText().toString());
                            addDetails1.setChilds(txtChild.getText().toString());
                            addDetails1.setCost(txtCost.getText().toString());

                            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("AddDeatils").child(txtRoomtype.getText().toString());
                            dbRef.setValue(addDetails1);

                            Toast.makeText(getApplicationContext(), "Data updated successfully",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "No source to Update",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });








        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("AddDeatils");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(txtRoomtype.getText().toString())){
                            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("AddDeatils").child(txtRoomtype.getText().toString());
                            dbRef.removeValue();

                            Toast.makeText(getApplicationContext(), "Data deleted successfully",Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(getApplicationContext(), "no source to delete", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }




    private void clearControls(){
        txtRoomtype.setText("");
        txtCheckin.setText("");
        txtCheckOut.setText("");
        txtAdult.setText("");
        txtChild.setText("");
        txtCost.setText("");

    }
}
