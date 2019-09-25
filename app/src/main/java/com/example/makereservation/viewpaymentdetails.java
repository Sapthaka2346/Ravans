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

public class viewpaymentdetails extends AppCompatActivity {

    ListView stdListview;

    ArrayList<String> rid;
    ArrayList<String> cno;
    ArrayList<String> nam;
    ArrayList<String> cvc;
    ArrayList<String> exday;
//    ArrayList<String> photo_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpaymentdetails);

        stdListview = findViewById(R.id.fbListview);

        rid = new ArrayList<String>();
        cno = new ArrayList<String>();
        nam = new ArrayList<String>();
        cvc = new ArrayList<String>();
        exday = new ArrayList<String>();

        final ArrayList<String> StudentStrList = new ArrayList<>();


        DatabaseReference readRef1 = FirebaseDatabase.getInstance().getReference().child("payment");

        readRef1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    String StudentStr = dsp.getKey();
                    StudentStrList.add(StudentStr);
                }
                for(int i =0 ; i<StudentStrList.size(); i++){
                    DatabaseReference readRef2 = FirebaseDatabase.getInstance().getReference().child("payment").child(StudentStrList.get(i));

                    readRef2.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                // TODO: handle the post
                                String strrid, strcno, strnam, strcvc, strexday;

                                strrid = dataSnapshot.child("rid").getValue().toString();
                                strcno = dataSnapshot.child("cno").getValue().toString();
                                strnam = dataSnapshot.child("nam").getValue().toString();
                                strcvc = dataSnapshot.child("cvc").getValue().toString();
                                strexday = dataSnapshot.child("exday").getValue().toString();

                                rid.add(strrid);
                                cno.add(strcno);
                                nam.add(strnam);
                                cvc.add(strcvc);
                                exday.add(strexday);
//                            photo_link.add(strPhotoLink);

                                MyStudentAdapter adapter = new MyStudentAdapter(getApplicationContext(), rid, cno, nam, cvc, exday);
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

    ArrayList rid;
    ArrayList cno;
    ArrayList nam;
    ArrayList cvc;
    ArrayList exday;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View stdrow = layoutInflater.inflate(R.layout.paymentview, parent, false);

        TextView tvrid = stdrow.findViewById(R.id.tvrid);
        TextView tvcno = stdrow.findViewById(R.id.tvcno);
        TextView tvnam = stdrow.findViewById(R.id.tvname);
        TextView tvcvc = stdrow.findViewById(R.id.tvcvc1);
        TextView tvexday  = stdrow.findViewById(R.id.tvexdate);

        tvrid.setText(rid.get(position).toString());
        tvcno.setText(cno.get(position).toString());
        tvnam.setText(nam.get(position).toString());
        tvcvc.setText(cvc.get(position).toString());
        tvexday.setText(exday.get(position).toString());

        return stdrow;
    }

    MyStudentAdapter(Context c, ArrayList rid, ArrayList cno, ArrayList nam, ArrayList cvc, ArrayList exday) {
        super(c, R.layout.paymentview, R.id.tvrid, rid);
        this.context = c;

        this.rid = rid;
        this.cno = cno;
        this.nam = nam;
        this.cvc = cvc;
        this.exday = exday;

    }
}
