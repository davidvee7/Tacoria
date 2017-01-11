package com.davidvinegar.tacoria.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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
        public TextView orderableName;
        public TextView orderablePrice;
        public TextView orderableDescription;
        public CardView orderCard;
        public TextView orderableRemove;

        public OrderHolder(View v){

            super(v);

            orderCard = (CardView) v.findViewById(R.id.orderSummaryCV);
            this.orderableName = (TextView) v.findViewById(R.id.orderable_name);
            this.orderablePrice = (TextView) v.findViewById(R.id.orderablePrice);
            this.orderableDescription = (TextView) v.findViewById(R.id.orderable_description);
            this.orderableRemove = (TextView) v.findViewById(R.id.remove_orderable_text);

        }



    }




    public OrderSummaryAdapter(ArrayList<Orderable> orderablesList){
        mDataSet = orderablesList;
    }

    @Override
    public OrderSummaryAdapter.OrderHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View v= LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.ordersummary_card,viewGroup,false);

        OrderHolder oh = new OrderHolder((CardView)v);
        return oh;


    }

    @Override
    public void onBindViewHolder(final OrderHolder viewHolder, int position){
        viewHolder.orderableName.setText(mDataSet.get(position).getFoodType());
        viewHolder.orderablePrice.setText("$" + String.valueOf(mDataSet.get(position).getcost()));
        viewHolder.orderableDescription.setText(mDataSet.get(position).getDescription());
        viewHolder.orderableRemove.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int newPosition = viewHolder.getAdapterPosition();
                mDataSet.remove(newPosition);
                notifyItemRemoved(newPosition);
                notifyItemChanged(newPosition,mDataSet.size());
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount(){
        return mDataSet.size();
    }




    public void removeAt(int position){

        mDataSet.remove(position);
        notifyItemRemoved(position);
        notifyItemChanged(position, mDataSet.size());

    }

}
