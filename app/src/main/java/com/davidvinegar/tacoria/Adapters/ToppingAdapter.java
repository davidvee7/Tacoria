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
import com.davidvinegar.tacoria.events.SalsaEvent;
import com.davidvinegar.tacoria.events.UnchickenEvent;
import com.davidvinegar.tacoria.events.UnsalsaEvent;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class ToppingAdapter extends RecyclerView.Adapter<ToppingAdapter.ToppingHolder> {
    private ArrayList<FirstChoiceOption> mDataSet;

    public static final int SALSA = 0;
    public static final int LETTUCE = 1;
    public static final int CHEESE = 2;
    public static final int SOUR = 3;

    public static class ToppingHolder extends RecyclerView.ViewHolder {
        CardView salsaCard;
        CardView lettuceCard;

        public ToppingHolder(View v) {
            super(v);
            salsaCard = (CardView) v.findViewById(R.id.salsaCV);
            lettuceCard = (CardView) v.findViewById(R.id.lettuceCV);

        }
    }

    public class SalsaViewHolder extends ToppingAdapter.ToppingHolder {
        TextView name;
        ImageView photo;
        ImageView isSelectedButton;
        boolean salsaIsSelected;

        public SalsaViewHolder(View v) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.salsa_text);
            this.photo = (ImageView) v.findViewById(R.id.salsa_photo);
            this.isSelectedButton = (ImageView) v.findViewById(R.id.salsaIsSelectedButton);
        }
    }

    public class LettuceViewHolder extends ToppingAdapter.ToppingHolder {
        TextView name;
        ImageView photo;
        ImageView lettuceIsSelectedButton;
        boolean lettuceIsSelected;

        public LettuceViewHolder(View v) {
            super(v);
            this.name = (TextView) v.findViewById(R.id.lettuce_text);
            this.photo = (ImageView) v.findViewById(R.id.lettuce_photo);
            this.lettuceIsSelectedButton = (ImageView) v.findViewById(R.id.lettuceIsSelectedButton);

        }
    }

    public ToppingAdapter(ArrayList<FirstChoiceOption> toppingList) {

        mDataSet = toppingList;
    }

    @Override
    public ToppingHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == SALSA) {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.topping_salsa_cv, viewGroup, false);
            SalsaViewHolder salsaViewHolder = new SalsaViewHolder(v);
            salsaViewHolder.salsaIsSelected = false;
            return salsaViewHolder;
        } else {
            v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.topping_lettuce_cv, viewGroup, false);
            LettuceViewHolder lettuceViewHolder = new LettuceViewHolder(v);
            lettuceViewHolder.lettuceIsSelected = false;
            return new LettuceViewHolder(v);
        }

    }

    @Override
    public void onBindViewHolder(ToppingAdapter.ToppingHolder viewHolder, int position) {

        if (viewHolder.getItemViewType() == SALSA) {
            final SalsaViewHolder holder = (SalsaViewHolder) viewHolder;
            holder.name.setText(mDataSet.get(position).name);
            holder.photo.setImageResource(mDataSet.get(position).photoID);
            holder.salsaCard.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (holder.salsaIsSelected) {
                        holder.isSelectedButton.setImageResource(R.drawable.plussign);
                        holder.salsaIsSelected = false;
                        EventBus.getDefault().post(new UnsalsaEvent());

                    } else {
                        holder.isSelectedButton.setImageResource(R.drawable.checkmark);
                        holder.salsaIsSelected = true;
                        EventBus.getDefault().post(new SalsaEvent());

                    }
                }
            });
        } else {
            final LettuceViewHolder holder = (LettuceViewHolder) viewHolder;
            holder.name.setText(mDataSet.get(position).name);
            holder.photo.setImageResource(mDataSet.get(position).photoID);
            holder.lettuceCard.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (holder.lettuceIsSelected) {
                        holder.lettuceIsSelectedButton.setImageResource(R.drawable.plussign);
                        holder.lettuceIsSelected = false;
                        EventBus.getDefault().post(new UnlettuceEvent());
                    } else {
                        holder.lettuceIsSelectedButton.setImageResource(R.drawable.checkmark);
                        holder.lettuceIsSelected = true;
                        EventBus.getDefault().post(new LettuceEvent());
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
