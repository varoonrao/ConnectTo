package com.varun.connectto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.Firebase;

public class historyFrag extends Fragment {
    private Firebase mRef;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);



//        mRef = new Firebase ( "https://connect-to-9f7e5.firebaseio.com/User_data/0" );
//
//        mRef.addValueEventListener ( new ValueEventListener () {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                Map<String,String> map= dataSnapshot.getValue (Map.class);
//
//                String name=map.get("UserName");
////                String age=map.get ( "Age" );
//                String blood=map.get ( "BloodGroup" );
//
//                Log.v ( "E_VALUE","NAME :" + name );
//                Log.v ( "E_VALUE","blood :" + blood );
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//                Log.w(TAG, "Failed to read value." );
//            }
//
//
//        } );



        return rootView;
    }


}
