package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

import static android.text.TextUtils.isEmpty;

public class LogIn extends AppCompatActivity {

    private EditText passwordtxt;
    private EditText usernametxt;
    Button btnlogin;
//    Button adminloginbtn;

    RadioButton radioAdmin;
    RadioButton radioUser;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

      btnlogin = (Button) findViewById(R.id.btnlogin);
//      adminloginbtn = (Button) findViewById(R.id.adminloginbtn);
      passwordtxt = (EditText) findViewById(R.id.passwordtxt);
      usernametxt = (EditText) findViewById(R.id.usernametxt);

        radioAdmin = findViewById(R.id.adminloginbtn);
        radioUser = findViewById(R.id.userloginbtn);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(radioAdmin.isChecked()){
                    //Go to Admin Dashboard
                    if(TextUtils.isEmpty(usernametxt.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_LONG).show();
                    }else if(TextUtils.isEmpty(passwordtxt.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();
                    }else{
                         validateAdmin( usernametxt.getText().toString(),  passwordtxt.getText().toString());
                    }

                }else if(radioUser.isChecked()){
                    //Go to USer Dashboard
                    if(TextUtils.isEmpty(usernametxt.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_LONG).show();
                    }else if(TextUtils.isEmpty(passwordtxt.getText().toString())){
                        Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();
                    }else {
                        validateUser(usernametxt.getText().toString(), passwordtxt.getText().toString());
                    }
                }

//                validate(usernametxt.getText().toString(), passwordtxt.getText().toString());
            }


            private void validateUser(String username, String password) {
                if ((username.equals("user")) && (password.equals("1234"))) {
                    Intent intent = new Intent(LogIn.this, Home.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Username or password incorrect", Toast.LENGTH_LONG).show();


                    counter--;

                    if (counter == 0) {
                        LogIn.setEnabled(false);

                    }
                }
            }

            private void validateAdmin(String username, String password) {
                if ((username.equals("admin")) && (password.equals("1234"))) {
                    Intent intent = new Intent(LogIn.this, Addddmiiiinnn.class);
                    startActivity(intent);
                } else{
                    Toast.makeText(getApplicationContext(), "Username or password incorrect", Toast.LENGTH_LONG).show();
                    counter--;

                    if (counter == 0) {
                        LogIn.setEnabled(false);

                    }
                }

            }



        });
//        adminloginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), Addddmiiiinnn.class);
//                startActivity(i);
//            }
//        });

    }



    private static void setEnabled(boolean b) {
    }


}
