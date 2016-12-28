package com.davidvinegar.tacoria.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.davidvinegar.tacoria.R;

import java.util.ArrayList;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class ProteinAdapter extends RecyclerView.Adapter<ProteinAdapter.ProteinChoiceHolder>{
    private ArrayList<FirstChoiceOption> mDataSet;

    public static final int STEAK = 0;
    public static final int CHICKEN = 1;

    public static class ProteinChoiceHolder extends RecyclerView.ViewHolder{

        public ProteinChoiceHolder(View v){
            super(v);
        }
    }
    public class SteakViewHolder extends ProteinAdapter.ProteinChoiceHolder {
        TextView name;
        ImageView photo;
        public SteakViewHolder(View v){
            super(v);
            this.name = (TextView)v.findViewById(R.id.steak_text);
            this.photo = (ImageView)v.findViewById(R.id.steak_photo);

        }
    }

    public class ChickenViewHolder extends ProteinAdapter.ProteinChoiceHolder {
        TextView name;
        ImageView photo;
        public ChickenViewHolder(View v){
            super(v);
            this.name = (TextView)v.findViewById(R.id.chicken_text);
            this.photo = (ImageView)v.findViewById(R.id.chicken_photo);

        }
    }

    public ProteinAdapter(ArrayList<FirstChoiceOption> proteinList){

        mDataSet = proteinList;
    }

    @Override
    public ProteinChoiceHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View v;
        if (viewType == STEAK){
            v=LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.protein_steak_card,viewGroup,false);
            return new SteakViewHolder(v);
        } else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.protein_chicken_card,viewGroup,false);
            return new ChickenViewHolder(v);
        }

    }

    @Override
    public void onBindViewHolder(ProteinAdapter.ProteinChoiceHolder viewHolder, int position){

        if(viewHolder.getItemViewType() == STEAK){
            SteakViewHolder holder = (SteakViewHolder) viewHolder;
            holder.name.setText(mDataSet.get(position).name);
            holder.photo.setImageResource(mDataSet.get(position).photoID);
        }
        else{
            ChickenViewHolder holder = (ChickenViewHolder) viewHolder;
            holder.name.setText(mDataSet.get(position).name);
            holder.photo.setImageResource(mDataSet.get(position).photoID);

        }
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
