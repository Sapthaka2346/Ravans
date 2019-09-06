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
    EditText txtname,txtaddress,txtcontact,txtcheckin,txtcheckout;
    Button btnsubmit;
//    DatabaseReference dbRef;
//    makereservation makereservation0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makereservation2);

        txtname=findViewById(R.id.txtname);
        txtaddress=findViewById(R.id.txtaddress);
        txtcontact=findViewById(R.id.txtcontact);
        txtcheckin=findViewById(R.id.txtcheckin);
        txtcheckout=findViewById(R.id.txtcheckout);

        btnsubmit= findViewById(R.id.SUBMIT);

//        makereservation0 = new makereservation();

        SUBMIT = (Button) findViewById(R.id.SUBMIT);

        SUBMIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Intent i = new Intent(getApplicationContext(), makereservation3.class);
               // startActivity(i);

                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        makereservation makereservation0 = new makereservation();

                        DatabaseReference  dbRef = FirebaseDatabase.getInstance().getReference().child("makereservation");
                        try {
                            if (TextUtils.isEmpty(txtname.getText().toString()))
                                Toast.makeText(getApplicationContext(), "Please enter your full name", Toast.LENGTH_LONG).show();
                            else if (isEmpty((txtaddress.getText().toString())))
                                Toast.makeText(getApplicationContext(), "Please enter your address", Toast.LENGTH_LONG).show();
                            else if (isEmpty((txtcontact.getText().toString())))
                                Toast.makeText(getApplicationContext(), "Please enter your contact number", Toast.LENGTH_LONG).show();
                            else if (isEmpty((txtcheckin.getText().toString())))
                                Toast.makeText(getApplicationContext(), "Please enter your Check-In date", Toast.LENGTH_LONG).show();
                            else if (isEmpty((txtcheckout.getText().toString())))
                                Toast.makeText(getApplicationContext(), "Please enter your Check-Out date", Toast.LENGTH_LONG).show();
                            else{
                                makereservation0.setCheckin(txtcheckin.getText().toString().trim());
                                makereservation0.setChekout(txtcheckout.getText().toString().trim());
                                makereservation0.setFullName(txtname.getText().toString().trim());
                                makereservation0.setAddress(txtaddress.getText().toString().trim());
                                makereservation0.setContactnumber(Integer.parseInt(txtcontact.getText().toString().trim()));

                                dbRef.push().setValue(makereservation0);

                                Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_LONG).show();
                                clearControls();
                            }


                        } catch (NumberFormatException e) {
                            Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

            public void clearControls() {
                txtname.setText("");
                txtaddress.setText("");
                txtcheckin.setText("");
                txtcheckout.setText("");
                txtcontact.setText("");
            }
        });
    }
}



