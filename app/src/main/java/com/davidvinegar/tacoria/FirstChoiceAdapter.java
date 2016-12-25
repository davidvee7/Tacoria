package com.davidvinegar.tacoria;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class FirstChoiceAdapter extends RecyclerView.Adapter<FirstChoiceAdapter.FirstChoiceHolder>{
    private ArrayList<FirstChoiceOption> firstChoiceOptions;

    public static class FirstChoiceHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        TextView foodName;
        ImageView foodPhoto;
        CardView cv;

        public FirstChoiceHolder(View v){

            super(v);
            cv = (CardView)v.findViewById(R.id.cv);
            foodName = (TextView)v.findViewById(R.id.burrito_text);
            foodPhoto = (ImageView)v.findViewById(R.id.beautiful_burrito);

        }
    }

    FirstChoiceAdapter(List<FirstChoiceOption> firstChoiceOptionsList){
        Log.e("TAGGG", "constructor called successfully");
        Log.e("TAGGG2", String.valueOf(firstChoiceOptionsList.size()));
        this.firstChoiceOptions = firstChoiceOptions;
    }

    @Override
    public FirstChoiceHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.first_choice_textview, parent, false);
        FirstChoiceHolder vh = new FirstChoiceHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(FirstChoiceHolder holder, int position){
        holder.foodName.setText(firstChoiceOptions.get(position).name);
        holder.foodPhoto.setImageResource(firstChoiceOptions.get(position).photoID);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount(){
        return firstChoiceOptions.size();
    }
}
