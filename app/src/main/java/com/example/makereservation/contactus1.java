package com.example.makereservation;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.snapshot.Index;

public class contactus1 extends AppCompatActivity {

    EditText nt1;
    EditText nt2;
    EditText nt3;
    EditText nt4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus1);

        EditText nt1 = findViewById(R.id.contactName);
        EditText nt2 = findViewById(R.id.editText0);
        EditText nt3 = findViewById(R.id.editText10);
        EditText nt4 = findViewById(R.id.editText11);

        contactName = findViewById(R.id.contactName);
        contactEmail = findViewById(R.id.contactEmail);
        contactPhone = findViewById(R.id.contactPhone);
        contactMessage = findViewById(R.id.contactMessage);

        button = findViewById(R.id.button);


        final cnt ct = new cnt();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Contact Us");

                try {
                    if (TextUtils.isEmpty(contactName.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Name", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(contactEmail.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter an Email", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(contactPhone.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a phone number", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(contactMessage.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please enter a Message", Toast.LENGTH_LONG).show();
                    else {
                        ct.setContactName(contactName.getText().toString().trim());
                        ct.setContactEmail(contactEmail.getText().toString().trim());
                        ct.setContactPhone(contactPhone.getText().toString().trim());
                        ct.setContactMessage(contactMessage.getText().toString().trim());

                        //dbRef.push().setValue(ct);
                        dbRef.child(contactName.getText().toString().trim()).setValue(ct);
                        Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                        clearControls();
                        Intent i = new Intent(getApplicationContext(), contactus2.class);
                        startActivity(i);

                    }

                    }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_SHORT).show();
                }
            }



        });
    }


    public void sendData(View view) {
        Intent i = new Intent(getApplicationContext(), contactus2.class);
        startActivity(i);


    }


    EditText contactName,contactEmail,contactPhone,contactMessage;
    Button button;
    DatabaseReference dbRef;
    cnt ct;

    private  void clearControls(){
        contactName.setText("");
        contactEmail.setText("");
        contactPhone.setText("");
        contactMessage.setText("");
    }
}
