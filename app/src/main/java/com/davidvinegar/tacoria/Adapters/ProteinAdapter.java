package com.davidvinegar.tacoria.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.davidvinegar.tacoria.R;
import com.davidvinegar.tacoria.events.ChickenEvent;
import com.davidvinegar.tacoria.events.SteakEvent;
import com.davidvinegar.tacoria.events.UnchickenEvent;
import com.davidvinegar.tacoria.events.UnsteakEvent;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class ProteinAdapter extends RecyclerView.Adapter<ProteinAdapter.ProteinChoiceHolder> {
    private ArrayList<FirstChoiceOption> mDataSet;

    public static final int STEAK = 0;
    public static final int CHICKEN = 1;

    public static class ProteinChoiceHolder extends RecyclerView.ViewHolder {
        CardView steakCard;
        CardView chickenCard;

        public ProteinChoiceHolder(View v) {
            super(v);
            steakCard = (CardView) v.findViewById(R.id.steakCV);
            chickenCard = (CardView) v.findViewById(R.id.chickenCV);

        }
    }

    public class SteakViewHolder extends ProteinAdapter.ProteinChoiceHolder {
        TextView name;
        ImageView photo;
        ImageView isSelectedButton;
        boolean steakIsSelected;

        public SteakViewHolder(View v) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.steak_text);
            this.photo = (ImageView) v.findViewById(R.id.steak_photo);
            this.isSelectedButton = (ImageView) v.findViewById(R.id.isSelectedButton);
        }
    }

    public class ChickenViewHolder extends ProteinAdapter.ProteinChoiceHolder {
        TextView name;
        ImageView photo;
        ImageView chickenIsSelectedButton;
        boolean chickenIsSelected;

        public ChickenViewHolder(View v) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.chicken_text);
            this.photo = (ImageView) v.findViewById(R.id.chicken_photo);
            this.chickenIsSelectedButton = (ImageView) v.findViewById(R.id.chickenIsSelectedButton);

        }
    }

    public ProteinAdapter(ArrayList<FirstChoiceOption> proteinList) {

        mDataSet = proteinList;
    }

    @Override
    public ProteinChoiceHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == STEAK) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.protein_steak_card, viewGroup, false);
            SteakViewHolder steakViewHolder = new SteakViewHolder(v);
            steakViewHolder.steakIsSelected = false;
            return steakViewHolder;
        } else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.protein_chicken_card, viewGroup, false);
            ChickenViewHolder chickenViewHolder = new ChickenViewHolder(v);
            chickenViewHolder.chickenIsSelected = false;
            return new ChickenViewHolder(v);
        }

    }

    @Override
    public void onBindViewHolder(ProteinAdapter.ProteinChoiceHolder viewHolder, int position) {

        if (viewHolder.getItemViewType() == STEAK) {
            final SteakViewHolder holder = (SteakViewHolder) viewHolder;
            holder.name.setText(mDataSet.get(position).name);
            holder.photo.setImageResource(mDataSet.get(position).photoID);
            holder.steakCard.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (holder.steakIsSelected) {
                        holder.isSelectedButton.setImageResource(R.drawable.plussign);
                        holder.steakIsSelected = false;
                        EventBus.getDefault().post(new UnsteakEvent());

                    } else {
                        holder.isSelectedButton.setImageResource(R.drawable.checkmark);
                        holder.steakIsSelected = true;
                        EventBus.getDefault().post(new SteakEvent());

                    }
                }
            });
        } else {
            final ChickenViewHolder holder = (ChickenViewHolder) viewHolder;
            holder.name.setText(mDataSet.get(position).name);
            holder.photo.setImageResource(mDataSet.get(position).photoID);
            holder.chickenCard.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (holder.chickenIsSelected) {
                        holder.chickenIsSelectedButton.setImageResource(R.drawable.plussign);
                        holder.chickenIsSelected = false;
                        EventBus.getDefault().post(new UnchickenEvent());
                    } else {
                        holder.chickenIsSelectedButton.setImageResource(R.drawable.checkmark);
                        holder.chickenIsSelected = true;
                        EventBus.getDefault().post(new ChickenEvent());
                    }
                }
            });
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }





    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public int getItemViewType(int position) {
        int[] mDataSetTypes = {0, 1};
        return mDataSetTypes[position];

    }
}
