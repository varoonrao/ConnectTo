package com.varun.connectto;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class dashboardFrag extends Fragment {
    static int heartValue = 65;
    TextView heart_rate,blood_pressure,height_f,weight_f,ecg_f,sugar_level_f;
    DatabaseReference reff;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        heart_rate=rootView.findViewById ( R.id.heartRate );
        blood_pressure=rootView.findViewById ( R.id.bloodPressure );
        height_f=rootView.findViewById ( R.id.height );
        weight_f=rootView.findViewById ( R.id.weight );
        ecg_f=rootView.findViewById ( R.id.ecg );
        sugar_level_f=rootView.findViewById ( R.id.sugar_level );


        reff = FirebaseDatabase.getInstance().getReference().child ( "User_data" ).child ( "0" );
        reff.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String heart=dataSnapshot.child ( "HeartRate" ).getValue ().toString ();
                String bloodPressure=dataSnapshot.child ( "BloodPressure" ).getValue ().toString ();
                String height=dataSnapshot.child ( "Height" ).getValue ().toString ();
                String weight=dataSnapshot.child ( "Weight" ).getValue ().toString ();
                String ecg=dataSnapshot.child ( "ECG" ).getValue ().toString ();
                String sugar=dataSnapshot.child ( "SugarLevel" ).getValue ().toString ();
                heart_rate.setText(heart);
                blood_pressure.setText(bloodPressure);
                height_f.setText(height);
                weight_f.setText(weight);
                ecg_f.setText(ecg);
                sugar_level_f.setText(sugar);

                //Log.i(remain,"Remain");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );

        Button callCareTakerButton = (Button) rootView.findViewById ( R.id.callcaretaker );
        callCareTakerButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                call ();
            }
        } );

        if(heartValue >= 95){
            call ();
        }

        return rootView;

    }
    public void call(){
        Intent intent=new Intent ( Intent.ACTION_CALL );
        intent.setData ( Uri.parse ( "tel:9483927651" ) );
        dashboardFrag.this.getActivity ().startActivity ( intent );
    }


}
