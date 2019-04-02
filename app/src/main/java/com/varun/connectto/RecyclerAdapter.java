package com.varun.connectto;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String LOG_TAG = RecyclerAdapter.class.getSimpleName ();
    public static int position;
    ItemListener mListener;
    Context context;
    private ArrayList<RecyclerModel> mItems;

    public RecyclerAdapter(Activity context, ArrayList<RecyclerModel> program, ItemListener listener) {

        this.context = context;
        mItems = program;
        mListener = listener;
    }

//    public void setOnItemClickListener(ItemListener listener) {
//
//        mListener = listener;
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from ( parent.getContext () )
                .inflate ( R.layout.card_layout, parent, false );
        context = parent.getContext ();
        return new ViewHolder ( v );
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData ( mItems.get ( position ) );
    }

    @Override
    public int getItemCount() {
        if (mItems != null) {
            return mItems.size ();
        }
        return 0;
    }

    public interface ItemListener {
        void onItemClick(RecyclerModel pName, int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public RecyclerModel pName;
        TextView name, number;
        ImageView image_he;


        public ViewHolder(View itemView) {

            super ( itemView );
//            itemView.setOnClickListener ( this );
            cardView = itemView.findViewById ( R.id.cardview1 );
            name = itemView.findViewById ( R.id.textview_health );
            number = itemView.findViewById ( R.id.textview_number );
            image_he = itemView.findViewById ( R.id.imageview_health );

        }

        public void setData(RecyclerModel pName) {
            this.pName = pName;
//          image_he.setText(pName.getImageview_health ());
            name.setText ( pName.getTextview_health () );
            number.setText ( pName.getTextview_number () );
        }


//
    }
}
