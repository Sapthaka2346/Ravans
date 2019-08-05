package com.example.makereservation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateDelete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        EditText nt1 = findViewById(R.id.contactName);
        EditText nt2 = findViewById(R.id.editText0);
        EditText nt3 = findViewById(R.id.editText10);
        EditText nt4 = findViewById(R.id.editText11);

        Intent intent2 = getIntent();

        String s1 = intent2.getStringExtra("Cname");
        String s2 = intent2.getStringExtra("Cemail");
        String s3 = intent2.getStringExtra("Cphone");
        String s4 = intent2.getStringExtra("Cmessage");

        nt1.setText(s1);
        nt2.setText(s2);
        nt3.setText(s3);
        nt4.setText(s4);

    }
}
