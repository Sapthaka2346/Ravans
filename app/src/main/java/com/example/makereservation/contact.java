package com.example.makereservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class contact extends AppCompatActivity {

    EditText nt1;
    EditText nt2;
    EditText nt3;
    EditText nt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainka);

        EditText nt1 = findViewById(R.id.contactName);
        EditText nt2 = findViewById(R.id.editText0);
        EditText nt3 = findViewById(R.id.editText10);
        EditText nt4 = findViewById(R.id.editText11);

    }

    public void sendData(View view) {
        Intent i = new Intent(getApplicationContext(), UpdateDelete.class);
        startActivity(i);
    }
}