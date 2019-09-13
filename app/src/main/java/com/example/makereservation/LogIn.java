package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

import static android.text.TextUtils.isEmpty;

public class LogIn extends AppCompatActivity {

    private EditText passwordtxt;
    private EditText usernametxt;
    Button btnlogin;
    Button adminloginbtn;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


      btnlogin = (Button) findViewById(R.id.btnlogin);
      adminloginbtn = (Button) findViewById(R.id.adminloginbtn);
      passwordtxt = (EditText) findViewById(R.id.passwordtxt);
      usernametxt = (EditText) findViewById(R.id.usernametxt);



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(usernametxt.getText().toString(), passwordtxt.getText().toString());
            }


            private void validate(String username, String password) {
                if ((username.equals("user")) && (password.equals("1234"))) {
                    Intent intent = new Intent(LogIn.this, Home.class);
                    startActivity(intent);
                } else if (isEmpty((passwordtxt.getText().toString())))
                    Toast.makeText(getApplicationContext(), "Please enter your password", Toast.LENGTH_LONG).show();
                    counter--;


                    if (counter == 0) {
                        LogIn.setEnabled(false);

                    }
                }



        });
        adminloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Adddetails1.class);
                startActivity(i);
            }
        });

    }



    private static void setEnabled(boolean b) {
    }

    public void addDetasils(View v) {

        Intent click = new Intent(this, Adddetails1.class);
        startActivity(click);
    }
}
