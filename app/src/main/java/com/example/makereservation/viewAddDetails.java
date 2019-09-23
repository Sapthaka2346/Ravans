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

public class viewAddDetails extends AppCompatActivity {

    ListView stdListview;

    ArrayList<String> roomtype;
    ArrayList<String> checkin;
    ArrayList<String> checkout;
    ArrayList<String> adults;
    ArrayList<String> childs;
    ArrayList<String> cost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_add_details);

        stdListview = (ListView) findViewById(R.id.adddetailslistview);

        roomtype = new ArrayList<String>();
        checkin = new ArrayList<String>();
        checkout = new ArrayList<String>();
        adults = new ArrayList<String>();
        childs = new ArrayList<String>();
        cost = new ArrayList<String>();

        final ArrayList<String> AddDetailsStrList = new ArrayList<>();
        DatabaseReference readRef1 = FirebaseDatabase.getInstance().getReference().child("AddDeatils");
        readRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    String StudentStr = dsp.getKey();
                    AddDetailsStrList.add(StudentStr);
                }
                for(int i =0 ; i<AddDetailsStrList.size(); i++){
                    DatabaseReference readRef2 = FirebaseDatabase.getInstance().getReference().child("AddDeatils").child(AddDetailsStrList.get(i));

                    readRef2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String strroomtype, strcheckin, strcheckout, stradults , strchilds , strcost;

                            strroomtype = dataSnapshot.child("roomtype").getValue().toString();
                            strcheckin = dataSnapshot.child("checkin").getValue().toString();
                            strcheckout = dataSnapshot.child("checkout").getValue().toString();
                            stradults = dataSnapshot.child("adults").getValue().toString();
                            strchilds = dataSnapshot.child("childs").getValue().toString();
                            strcost = dataSnapshot.child("cost").getValue().toString();

                            roomtype.add(strroomtype);
                            checkin.add(strcheckin);
                            checkout.add(strcheckout);
                            adults.add(stradults);
                            childs.add(strchilds);
                            cost.add(strcost);

                            MyadddetailsAdapter adapter = new MyadddetailsAdapter(getApplicationContext(),roomtype,checkin,checkout,adults,childs,cost);
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
class MyadddetailsAdapter extends ArrayAdapter<String> {
    Context context;

    ArrayList roomtype;
    ArrayList checkin;
    ArrayList checkout;
    ArrayList adults;
    ArrayList child;
    ArrayList cost;


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View stdrow = layoutInflater.inflate(R.layout.viewdetails,parent,false);

        TextView tvroomtype = stdrow.findViewById(R.id.tvroomtype);
        TextView tvcheckin = stdrow.findViewById(R.id.tvcheckin);
        TextView tvcheckout = stdrow.findViewById(R.id.tvcheckout);
        TextView tvadults = stdrow.findViewById(R.id.tvadults);
        TextView tvcilds = stdrow.findViewById(R.id.tvchilds);
        TextView tvcost = stdrow.findViewById(R.id.tvcost);


        tvroomtype.setText(roomtype.get(position).toString());
        tvcheckin.setText(checkin.get(position).toString());
        tvcheckout.setText(checkout.get(position).toString());
        tvadults.setText(adults.get(position).toString());
        tvcilds.setText(child.get(position).toString());
        tvcost.setText(cost.get(position).toString());


        //Photo add to imageview here
//        Glide.with(context)
//                .load(photo_link.get(position).toString())
//                .into(stdPhoto);
       return stdrow;
    }
    MyadddetailsAdapter(Context c,ArrayList roomtype, ArrayList checkin, ArrayList checkout, ArrayList adults, ArrayList child,ArrayList cost) {
        super(c, R.layout.viewdetails, R.id.tvroomtype, roomtype);
        this.context = c;

        this.roomtype = roomtype;
        this.checkin = checkin;
        this.checkout = checkout;
        this.adults = adults;
        this.child = child;
        this.cost = cost;


    }
    }

