package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Adddetails1 extends AppCompatActivity {

    EditText txtRoomtype,txtCheckin,txtCheckOut,txtAdult,txtChild,txtCost;
    Button btnAdd;
    DatabaseReference dbRef;
    AddDetails addDetails;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddetails1);

        button =(Button) findViewById(R.id.btnadd);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                openActivity2();
            }
        });

        txtRoomtype = findViewById(R.id.rt);
        txtCheckin = findViewById(R.id.CnoID);
        txtCheckOut = findViewById(R.id.CvcID);
        txtAdult = findViewById(R.id.NamID);
        txtChild = findViewById(R.id.EdayID);
        txtCost = findViewById(R.id.CvcID);

        btnAdd = findViewById(R.id.btnadd);

        addDetails = new AddDetails();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("AddDeatils");

                try{
                    if(TextUtils.isEmpty(txtRoomtype.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter Room type", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtCheckin.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter Check in date", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtCheckOut.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter Check Out date", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtAdult.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter number of adults", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtChild.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter number of childs", Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtCost.getText().toString()))
                        Toast.makeText(getApplicationContext(), "please enter cost", Toast.LENGTH_SHORT).show();
                    else{

                        addDetails.setRoomtype(txtRoomtype.getText().toString().trim());
                        addDetails.setCheckin(txtCheckin.getText().toString().trim());
                        addDetails.setCheckout(txtCheckOut.getText().toString().trim());
                        addDetails.setAdults(txtAdult.getText().toString().trim());
                        addDetails.setChilds(txtChild.getText().toString().trim());
                        addDetails.setCost(txtCost.getText().toString().trim());

                       // dbRef.push().setValue(addDetails);

                        dbRef.child(addDetails.getRoomtype()).setValue(addDetails);

                        Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                        clearControls();



                        Intent i = new Intent(getApplicationContext(), AddDetails2.class);
                        startActivity(i);
                    }
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(), "Invalid enters",Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    public void openActivity2() {
        Intent intent = new Intent(this, AddDetails2.class);
        startActivity(intent);
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
