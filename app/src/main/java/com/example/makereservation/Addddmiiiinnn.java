package com.example.makereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Addddmiiiinnn extends AppCompatActivity {

    private Button cntbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addddmiiiinnn);

        cntbtn = (Button) findViewById(R.id.cntbtn);
        cntbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencontactus3();
            }
        });
    }
    public void opencontactus3(){
        Intent intent = new Intent(this, contactus3.class);
        startActivity(intent);
    }

}
