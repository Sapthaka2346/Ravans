package com.example.makereservation;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class contactus1 extends AppCompatActivity {

    private Button msgupd;

    EditText nt1;
    EditText nt2;
    EditText nt3;
    EditText nt4;

    private boolean isValidMail(String contactEmail){
        String EMAIL_STRING = "^[-a-z0-9~!$%^&*_=+}{\\'?]+(\\.[-a-z0-9~!$%^&*_=+}{\\'?]+)*@([a-z0-9_][-a-z0-9_]*(\\.[-a-z0-9_]+)*\\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,5})?$ ";

        return Pattern.compile(EMAIL_STRING).matcher(contactEmail).matches();
    }

    private boolean isValidMobile(String contactPhone){
        if(!Pattern.matches("[a-zA-Z]+", contactPhone)){
            return contactPhone.length() != 10;
        }
        return false;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus1);

        msgupd = (Button) findViewById(R.id.msgupd);

        msgupd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencontactus2();

            }

        });

        EditText nt1 = findViewById(R.id.contactName);
        EditText nt2 = findViewById(R.id.editText0);
        EditText nt3 = findViewById(R.id.textaddress);
        EditText nt4 = findViewById(R.id.textrooms);

        contactName = findViewById(R.id.contactName);
        contactEmail = findViewById(R.id.contactEmail);
        contactPhone = findViewById(R.id.contactPhone);
        contactMessage = findViewById(R.id.contactMessage);

        button = findViewById(R.id.insertbtn);


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

                    else if(isValidMail(contactEmail.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please enter a valid Email", Toast.LENGTH_SHORT).show();
                    }

                    else  if(isValidMobile(contactPhone.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please enter a valid phone number", Toast.LENGTH_SHORT).show();
                    }
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
                        finish();

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
    public void opencontactus2(){
        Intent intent = new Intent(this, contactus2.class);
        startActivity(intent);
    }
}
