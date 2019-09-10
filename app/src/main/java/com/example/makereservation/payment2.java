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

public class payment2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment2);

        final EditText nt1 = findViewById(R.id.Rid);
        final EditText nt2 = findViewById(R.id.CnoID);
        final EditText nt3 = findViewById(R.id.NamID);
        final EditText nt4 = findViewById(R.id.CvcID);
        final EditText nt5 = findViewById(R.id.EdayID);

        Button btn1 = findViewById(R.id.insertbtn);

        Intent intent1 = getIntent();
        String s1 = intent1.getStringExtra("FirstText");
        String s2 = intent1.getStringExtra("SecondText");
        String s3 = intent1.getStringExtra("ThirdText");
        String s4 = intent1.getStringExtra("ForthText");
        String s5 = intent1.getStringExtra("FifthText");

        nt1.setText(s1);
        nt2.setText(s2);
        nt3.setText(s3);
        nt4.setText(s4);
        nt5.setText(s5);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference dbRef;

                dbRef = FirebaseDatabase.getInstance().getReference().child("payment");
                payment paymentdetails = new payment();

                if(TextUtils.isEmpty(nt1.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please enter payment Registeration ID",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(nt2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"please enter card number",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(nt3.getText().toString())){
                    Toast.makeText(getApplicationContext(),"please enter name",Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(nt4.getText().toString())){
                    Toast.makeText(getApplicationContext(),"please enter the CVC",Toast.LENGTH_SHORT).show();
                }

                else if(TextUtils.isEmpty(nt5.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please enter Expiration Date",Toast.LENGTH_SHORT).show();
                }

                else{

                    paymentdetails.setRid(nt1.getText().toString().trim());
                    paymentdetails.setCno(nt2.getText().toString().trim());
                    paymentdetails.setNam(nt3.getText().toString().trim());
                    paymentdetails.setCvc(nt4.getText().toString().trim());
                    paymentdetails.setExday(nt5.getText().toString().trim());

                    dbRef.child(paymentdetails.getRid()).setValue(paymentdetails);

                    Toast.makeText(getApplicationContext(),"Data Save Succuessfully!",Toast.LENGTH_SHORT).show();

                    Intent second = new Intent(getApplicationContext(),payment3.class);
                    startActivity(second);


                }


            }
        });

    }
}
