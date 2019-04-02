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
import android.widget.Toast;
public class aboutFrag extends Fragment {
    static int heartValue = 75;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate ( R.layout.fragment_about, container, false );
        Button callCareTakerButton = (Button) rootView.findViewById ( R.id.callcaretaker );
        callCareTakerButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                call ();
            }
        } );

        Button callambulancebutton=(Button) rootView.findViewById ( R.id.callambu );
        callambulancebutton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                callambu ();
            }
        } );


return rootView;




//        Button caretaker = (Button) getView ().findViewById ( R.id.callcaretaker );
//        caretaker.setOnClickListener ( new View.OnClickListener () {
//
//            @Override
//            public void onClick(View v) {
////                View view = LayoutInflater.from ( .this ).inflate ( R.layout.fragment_about, null );
//
//                Intent intent=new Intent ( Intent.ACTION_CALL );
//        intent.setData ( Uri.parse ( "tel:9483927651" ) );
//
//
//            }
//            public boolean callPermision() {
//
//                if (Build.VERSION.SDK_INT >= 23) {
//                    if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE)
//                            == PackageManager.PERMISSION_GRANTED) {
//
//                        //permission is granted
//
//
//                        return true;
//                    } else {
//
//                        requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE}, 1);
//
//                        return false;
//                    }
//                } else
//
//                { //permission is automatically granted on sdk<23 upon installation
//
//                    return true;
//                }
//            }
//        } );
//        return rootView;



   }
   public void call(){
       Intent intent=new Intent ( Intent.ACTION_CALL );
       intent.setData ( Uri.parse ( "tel:9483927651" ) );
       aboutFrag.this.getActivity ().startActivity ( intent );
   }

    public void callambu(){
        Intent intent=new Intent ( Intent.ACTION_CALL );
        intent.setData ( Uri.parse ( "tel:8073001404" ) );
        aboutFrag.this.getActivity ().startActivity ( intent );
    }
}
