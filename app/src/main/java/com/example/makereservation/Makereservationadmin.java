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
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Makereservationadmin extends AppCompatActivity {

    ListView stdListview;

    ArrayList<String> address;
    ArrayList<String> checkin1;
    ArrayList<String> checkout1;
    ArrayList<String> contactnumber;
    ArrayList<String> fullname;
    ArrayList<String> rooms;
    ArrayList<String> nic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makereservationadmin);

        stdListview = (ListView) findViewById(R.id.makereservationListview);

        checkin1 = new ArrayList<String>();
        checkout1 = new ArrayList<String>();
        address = new ArrayList<String>();
        contactnumber = new ArrayList<String>();
        fullname = new ArrayList<String>();
        rooms = new ArrayList<String>();
        nic = new ArrayList<String>();

        final ArrayList<String> StudentStrList = new ArrayList<>();
        DatabaseReference readRef1 = FirebaseDatabase.getInstance().getReference().child("MakeReservation");
        readRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    String StudentStr = dsp.getKey();
                    StudentStrList.add(StudentStr);
                }
                for(int i =0 ; i<StudentStrList.size(); i++){
                    DatabaseReference readRef2 = FirebaseDatabase.getInstance().getReference().child("MakeReservation").child(StudentStrList.get(i));

                    readRef2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String strcheckin1 ,strcheckout1, straddress, strcontactnumber , strrooms,strnic,strfullname;

                            strcheckin1 = dataSnapshot.child("checkin").getValue().toString();
                            strcheckout1 = dataSnapshot.child("checkout").getValue().toString();
                            straddress = dataSnapshot.child("address").getValue().toString();
                            strcontactnumber = dataSnapshot.child("contactnumber").getValue().toString();
                            strrooms = dataSnapshot.child("rooms").getValue().toString();
                            strnic = dataSnapshot.child("nic").getValue().toString();
                            strfullname = dataSnapshot.child("fullName").getValue().toString();


                            checkin1.add(strcheckin1);
                            checkout1.add(strcheckout1);
                            address.add(straddress);
                            fullname.add(strfullname);
                            contactnumber.add(strcontactnumber);
                            rooms.add(strrooms);
                            nic.add(strnic);



                            MyReservationAdapter adapter = new MyReservationAdapter(getApplicationContext(),checkin1,checkout1,address,contactnumber,rooms,fullname,nic);
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
class MyReservationAdapter extends ArrayAdapter<String> {
    Context context;

    ArrayList checkin1;
    ArrayList checkout1;
    ArrayList address;
    ArrayList contactnumber;
    ArrayList fullname;
    ArrayList rooms;
    ArrayList nic;

    public MyReservationAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View stdrow = layoutInflater.inflate(R.layout.makereservationlayout,parent,false);

        TextView tvcheckin = stdrow.findViewById(R.id.tvcheckout);
        TextView tvcheckout = stdrow.findViewById(R.id.tvcontactnumber);
        TextView tvaddress = stdrow.findViewById(R.id.tvaddress);
        TextView tvcontactnumber = stdrow.findViewById(R.id.tvcontactnumber);
        TextView tvfullname = stdrow.findViewById(R.id.tvcontactnumber);
        TextView tvnic = stdrow.findViewById(R.id.tvcheckout);
        TextView tvrooms = stdrow.findViewById(R.id.tvrooms);

        tvcheckin.setText(checkin1.get(position).toString());
        tvcheckout.setText(checkout1.get(position).toString());
        tvaddress.setText(address.get(position).toString());
        tvcontactnumber.setText(contactnumber.get(position).toString());
        tvfullname.setText(contactnumber.get(position).toString());
        tvnic.setText(contactnumber.get(position).toString());
        tvrooms.setText(contactnumber.get(position).toString());

        //Photo add to imageview here
      // Glide.with(context)
       //         .load(photo_link.get(position).toString())
        //        .into(stdPhoto);
        return stdrow;
    }
    MyReservationAdapter(Context c, ArrayList nic, ArrayList fullname, ArrayList address, ArrayList contactnumber, ArrayList checkin1, ArrayList checkout1, ArrayList rooms){
        super(c, R.layout.makereservationlayout, R.id.tvcheckout, nic);
        this.context = c;

        this.checkin1 = checkin1;
        this.checkout1 = checkout1;
        this.address = address;
        this.fullname = fullname;
        this.rooms = rooms;
        this.contactnumber = contactnumber;
        this.nic=nic;
    }

}
