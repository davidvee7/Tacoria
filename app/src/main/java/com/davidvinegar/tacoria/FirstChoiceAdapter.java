package com.davidvinegar.tacoria;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class FirstChoiceAdapter extends RecyclerView.Adapter<FirstChoiceAdapter.ViewHolder>{
    private String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(TextView v){
            super(v);
            mTextView = v;
        }
    }

    public FirstChoiceAdapter(String[] myDataset){
        mDataSet = myDataset;
    }

    @Override
    public FirstChoiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.first_choice_textview, parent, false);
        ViewHolder vh = new ViewHolder((TextView)v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.mTextView.setText(mDataSet[position]);
    }

    @Override
    public int getItemCount(){
        return mDataSet.length;
    }
}
