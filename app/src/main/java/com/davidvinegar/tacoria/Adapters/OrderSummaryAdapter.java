package com.davidvinegar.tacoria.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidvinegar.tacoria.Model.Orderable;
import com.davidvinegar.tacoria.R;

import java.util.ArrayList;

/**
 * Created by davidvinegar on 1/4/17.
 */
public class OrderSummaryAdapter  extends RecyclerView.Adapter<OrderSummaryAdapter.OrderHolder>{
    private ArrayList<Orderable> mDataSet;
    private Context context;



    public static class OrderHolder extends RecyclerView.ViewHolder{
        public TextView name;
        TextView price;


        public OrderHolder(TextView v){

            super(v);
            name = v;

        }
    }


    public OrderSummaryAdapter(ArrayList<Orderable> orderablesList){
        mDataSet = orderablesList;
    }

    @Override
    public OrderSummaryAdapter.OrderHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View v= LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.ordersummary_item_textview,viewGroup,false);

        OrderHolder oh = new OrderHolder((TextView)v);
        return oh;


    }

    @Override
    public void onBindViewHolder(OrderHolder viewHolder, int position){

        Log.v("getFoodType", "foodtype= " + mDataSet.get(position).getFoodType());
        viewHolder.name.setText(mDataSet.get(position).getFoodType());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount(){
        return mDataSet.size();
    }

//    @Override
//    public int getItemViewType(int position){
//        int[] mDataSetTypes = {0, 1};
//        return mDataSetTypes[position];
//    }
}
