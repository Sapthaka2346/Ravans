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

import static android.text.TextUtils.isEmpty;

public class makereservation2 extends AppCompatActivity {

    Button SUBMIT;
    EditText txtname,txtaddress,txtcontact,txtcheckin,txtcheckout,txtrooms,txtnic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makereservation2);

        txtname=findViewById(R.id.txtname);
        txtaddress=findViewById(R.id.txtaddress);
        txtcontact=findViewById(R.id.txtcontact);
        txtcheckin=findViewById(R.id.txtcheckin);
        txtcheckout=findViewById(R.id.txtcheckout);
        txtnic=findViewById(R.id.txtnic);
        txtrooms=findViewById(R.id.txtrooms);
        txtcheckout=findViewById(R.id.txtcheckout);



        SUBMIT = (Button) findViewById(R.id.SUBMIT);


        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Intent i = new Intent(getApplicationContext(), makereservation3.class);
               // startActivity(i);

                //Insert Code

                SUBMIT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        makereservation makereservation = new makereservation();

                        DatabaseReference  dbRef = FirebaseDatabase.getInstance().getReference().child("MakeReservation");
                        try {
                            if (TextUtils.isEmpty(txtname.getText().toString()))
                                Toast.makeText(getApplicationContext(), "Please enter your full name", Toast.LENGTH_LONG).show();
                            else if (isEmpty((txtaddress.getText().toString())))
                                Toast.makeText(getApplicationContext(), "Please enter your address", Toast.LENGTH_LONG).show();
                            else if (isEmpty((txtnic.getText().toString())))
                                Toast.makeText(getApplicationContext(), "Please enter your NIC", Toast.LENGTH_LONG).show();
                            else if (isEmpty((txtrooms.getText().toString())))
                                Toast.makeText(getApplicationContext(), "Please enter no.of rooms", Toast.LENGTH_LONG).show();
                            else if (isEmpty((txtcontact.getText().toString())))
                                Toast.makeText(getApplicationContext(), "Please enter your contact number", Toast.LENGTH_LONG).show();
                            else if (isEmpty((txtcheckin.getText().toString())))
                                Toast.makeText(getApplicationContext(), "Please enter your Check-In date", Toast.LENGTH_LONG).show();
                            else if (isEmpty((txtcheckout.getText().toString())))
                                Toast.makeText(getApplicationContext(), "Please enter your Check-Out date", Toast.LENGTH_LONG).show();
                            else{

                                makereservation.setCheckin(txtcheckin.getText().toString().trim());
                                makereservation.setnic(txtnic.getText().toString().trim());
                                makereservation.setChekout(txtcheckout.getText().toString().trim());
                                makereservation.setFullName(txtname.getText().toString().trim());
                                makereservation.setAddress(txtaddress.getText().toString().trim());
                                makereservation.setContactnumber(Integer.parseInt(txtcontact.getText().toString().trim()));
                                makereservation.setrooms(Integer.parseInt(txtrooms.getText().toString().trim()));

                                dbRef.push().setValue(makereservation);

                                Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_LONG).show();
                                clearControls();
                            }


                        } catch (NumberFormatException e) {
                            Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_LONG).show(); }
                    }
                });
            }

            public void clearControls() {
                txtname.setText("");
                txtaddress.setText("");
                txtcheckin.setText("");
                txtcheckout.setText("");
                txtcontact.setText("");
                txtnic.setText("");
                txtrooms.setText("");
            }
        });
    }
}



