package com.davidvinegar.tacoria;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class FirstChoiceAdapter extends RecyclerView.Adapter<FirstChoiceAdapter.FirstChoiceHolder>{
    private ArrayList<FirstChoiceOption> mDataSet;

    public static final int BURRITO = 0;
    public static final int TACO = 1;
    public static final int QUESADILLA = 2;

    public static class FirstChoiceHolder extends RecyclerView.ViewHolder{
//        public TextView mTextView;
//        TextView foodName;
//        ImageView foodPhoto;
        CardView cv;

        public FirstChoiceHolder(View v){

            super(v);
//            cv = (CardView)v.findViewById(R.id.cv);
//            foodName = (TextView)v.findViewById(R.id.burrito_text);
//            foodPhoto = (ImageView)v.findViewById(R.id.beautiful_burrito);

        }
    }

    public class BurritoViewHolder extends FirstChoiceHolder{
        TextView name;
        ImageView photo;
        public BurritoViewHolder(View v){
            super(v);
            this.name = (TextView)v.findViewById(R.id.burrito_text);
            this.photo = (ImageView)v.findViewById(R.id.beautiful_burrito);

        }
    }

    public class TacoViewHolder extends FirstChoiceHolder{
        TextView name;
        ImageView photo;
        public TacoViewHolder(View v){
            super(v);
            this.name = (TextView)v.findViewById(R.id.taco_text);
            this.photo = (ImageView)v.findViewById(R.id.taco_photo);

        }
    }

    public FirstChoiceAdapter(ArrayList<FirstChoiceOption> firstChoiceOptionsList){
//        Log.e("TAGGG", "constructor called successfully");
//        Log.e("TAGGG2", String.valueOf(firstChoiceOptionsList.size()));
        mDataSet = firstChoiceOptionsList;
    }

    @Override
    public FirstChoiceHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View v;
        if (viewType == BURRITO){
            v=LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.firstchoice_burrito_card,viewGroup,false);
            return new BurritoViewHolder(v);
        } else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.firstchoice_taco_card,viewGroup,false);
            return new TacoViewHolder(v);
        }


//        View v = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.first_choice_textview, viewGroup, false);
//        FirstChoiceHolder vh = new FirstChoiceHolder(v);
//
//        return vh;
    }

    @Override
    public void onBindViewHolder(FirstChoiceHolder viewHolder, int position){

        if(viewHolder.getItemViewType() == BURRITO){
            BurritoViewHolder holder = (BurritoViewHolder) viewHolder;
            holder.name.setText(mDataSet.get(position).name);
            holder.photo.setImageResource(mDataSet.get(position).photoID);
        }
        else{
                TacoViewHolder holder = (TacoViewHolder) viewHolder;
                holder.name.setText(mDataSet.get(position).name);
                holder.photo.setImageResource(mDataSet.get(position).photoID);

        }

        //old ways
//        viewHolder.foodName.setText(mDataSet.get(position).name);
//        viewHolder.foodPhoto.setImageResource(mDataSet.get(position).photoID);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount(){
        return mDataSet.size();
    }

    @Override
    public int getItemViewType(int position){
        int[] mDataSetTypes = {0, 1};
        return mDataSetTypes[position];
    }
}
