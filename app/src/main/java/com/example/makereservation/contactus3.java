package com.example.makereservation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class contactus3 extends AppCompatActivity {

    ListView stdListview;

    ArrayList<String> contactName;
    ArrayList<String> contactEmail;
    ArrayList<String> contactPhone;
    ArrayList<String> contactMessage;
    //ArrayList<String> photo_link;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus3);

        stdListview = (ListView) findViewById(R.id.contactListview);

        contactName = new ArrayList<String>();
        contactEmail = new ArrayList<String>();
        contactPhone = new ArrayList<String>();
        contactMessage = new ArrayList<String>();
        //photo_link = new ArrayList<String>();

        final ArrayList<String> contactStrList = new ArrayList<>();
        DatabaseReference readRef1 = FirebaseDatabase.getInstance().getReference().child("Contact Us");
        readRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    String contactStr = dsp.getKey();
                    contactStrList.add(contactStr);
                }
                for(int i =0 ; i<contactStrList.size(); i++){
                    DatabaseReference readRef2 = FirebaseDatabase.getInstance().getReference().child("Contact Us").child(contactStrList.get(i));

                    readRef2.addListenerForSingleValueEvent(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String strName, strEmail, strMessage,  strPhone;

                            strName = dataSnapshot.child("contactName").getValue().toString();
                            strEmail = dataSnapshot.child("contactEmail").getValue().toString();
                            strPhone = dataSnapshot.child("contactPhone").getValue().toString();
                            //strPhotoLink = dataSnapshot.child("photoLink").getValue().toString();
                            strMessage = dataSnapshot.child("contactMessage").getValue().toString();

                            contactName.add(strName);
                            contactEmail.add(strEmail);
                            contactPhone.add(strPhone);
                            contactMessage.add(strMessage);
                            //photo_link.add(strPhotoLink);

                            MyStudentAdapter adapter = new MyStudentAdapter(getApplicationContext(),contactName,contactEmail,contactPhone,contactMessage);
                            stdListview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
class MyStudentAdapter extends ArrayAdapter<String> {
    Context context;

    ArrayList contactName;
    ArrayList contactEmail;
    ArrayList contactPhone;
    ArrayList contactMessage;
  //  ArrayList photo_link;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cntrow = layoutInflater.inflate(R.layout.contactview,parent,false);

        TextView tvcontactName = cntrow.findViewById(R.id.tvcontactName);
        TextView tvcontactEmail = cntrow.findViewById(R.id.tvcontactEmail);
        TextView tvcontactPhone = cntrow.findViewById(R.id.tvcontactPhone);
        TextView tvcontactMessage = cntrow.findViewById(R.id.tvcontactMessage);
        //ImageView stdPhoto = cntrow.findViewById(R.id.stdPhoto);

        tvcontactName.setText(contactName.get(position).toString());
        tvcontactEmail.setText(contactEmail.get(position).toString());
        tvcontactPhone.setText(contactPhone.get(position).toString());
        tvcontactMessage.setText(contactMessage.get(position).toString());

        //Photo add to imageview here
        //Glide.with(context)
             //   .load(photo_link.get(position).toString())
               // .into(stdPhoto);
        return cntrow;
    }
    MyStudentAdapter(Context c,ArrayList contactName, ArrayList contactEmail, ArrayList contactPhone, ArrayList contactMessage){
        super(c, R.layout.contactview, R.id.tvcontactName, contactName);
        this.context = c;

        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.contactMessage = contactMessage;
        //this.photo_link = photo_link;

    }

}
