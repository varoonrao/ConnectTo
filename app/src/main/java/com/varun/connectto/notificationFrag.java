package com.varun.connectto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class notificationFrag extends Fragment {


    TextView act, rem;
    EditText uid,uname;
    Button btn;
    DatabaseReference reff,reff1;
    Member member;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View rootView=   inflater.inflate(R.layout.fragment_notification, container, false);

//        FirebaseApp.initializeApp(notificationFrag.this);

        act =rootView.findViewById ( R.id.actual );
        rem=rootView.findViewById ( R.id.remaining );
//        btn= rootView.findViewById ( R.id.send );
//        Button btn = (Button) rootView.findViewById ( R.id.btnload );

//        btn.setOnClickListener ( new View.OnClickListener () {
//            @Override
//            public void onClick(View v) {
//                FirebaseApp.initializeApp ( this. )
                reff = FirebaseDatabase.getInstance().getReference().child ( "User_data" ).child ( "0" );
                reff.addValueEventListener ( new ValueEventListener () {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String remain=dataSnapshot.child ( "remaininga_tablets" ).getValue ().toString ();
                        String actual1=dataSnapshot.child ( "actaul_tablet" ).getValue ().toString ();
                        rem.setText(remain);
                        act.setText(actual1);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                } );

//        btn = (Button) rootView.findViewById ( R.id.send );
//        uid=rootView.findViewById ( R.id.unique_id );
//        uname=rootView.findViewById ( R.id.unique_name );
//        member=new Member ();
//        reff1 = FirebaseDatabase.getInstance().getReference().child ( "User_data" ).child ( "patient" );
//        btn.setOnClickListener ( new View.OnClickListener () {
//            @Override
//            public void onClick(View v) {
//
//                member.setUserid ( uid.getText ().toString ().trim () );
//                member.setUsername ( uname.getText ().toString ().trim () );
//
//                reff1.push ().setValue ( member );
//                Toast.makeText ( getActivity (), "Inserted Successfully", Toast.LENGTH_SHORT ).show ();
//            }
//        } );


//        } );


        //btn.setOnClickListener ( new View.OnClickListener () {
          //    @Override
            //  public void onClick(View v) {
//                  reff = FirebaseDatabase.getInstance().getReference().child ( "User_data" ).child ( "0" );
//                  reff.addValueEventListener ( new ValueEventListener () {
//                      @Override
//                      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                          String remain=dataSnapshot.child ( "remaininga_tablets" ).getValue ().toString ();
//                          String actual1=dataSnapshot.child ( "actaul_tablet" ).getValue ().toString ();
//                          remaining.setText(remain);
//                          actual.setText(actual1);
//                      }
//
//                      @Override
//                      public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                      }
//                  } );
          //    }
        //  } );

        return rootView;
    }


    }

