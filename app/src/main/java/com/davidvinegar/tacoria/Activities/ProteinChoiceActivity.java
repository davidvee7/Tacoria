package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.davidvinegar.tacoria.Adapters.FirstChoiceOption;
import com.davidvinegar.tacoria.Adapters.ProteinAdapter;
import com.davidvinegar.tacoria.R;
import com.davidvinegar.tacoria.events.SteakEvent;
import com.davidvinegar.tacoria.events.UnsteakEvent;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class ProteinChoiceActivity extends Activity {
    private RecyclerView mProteinRecyclerView;
    private RecyclerView.Adapter mProteinAdapter;
    private RecyclerView.LayoutManager mProteinLayoutManager;
    private ArrayList<FirstChoiceOption> proteinOptionsList;

    String foodType;
    boolean hasSteak;
    boolean hasChicken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.protein_choice_activity_layout);

        mProteinRecyclerView = (RecyclerView) findViewById(R.id.protein_recyclerView);
        mProteinLayoutManager = new LinearLayoutManager(this);
        mProteinRecyclerView.setLayoutManager(mProteinLayoutManager);

        mProteinRecyclerView.setHasFixedSize(true);

        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("foodType") != null) {
            this.foodType = bundle.getString("foodType");
        }

        initializeData();
        EventBus.getDefault().register(this);

        mProteinAdapter = new ProteinAdapter(proteinOptionsList);
        mProteinRecyclerView.setAdapter(mProteinAdapter);
        Button continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OrderSummaryActivity.class);
                intent.putExtra("foodType", ProteinChoiceActivity.this.foodType);
                intent.putExtra("hasSteak", ProteinChoiceActivity.this.hasSteak);
                intent.putExtra("hasChicken", ProteinChoiceActivity.this.hasChicken);
                startActivity(intent);
            }
        });
    }

    private void initializeData() {
        proteinOptionsList = new ArrayList<>();
        FirstChoiceOption steak = new FirstChoiceOption("Steak", R.drawable.steak);
        FirstChoiceOption chicken = new FirstChoiceOption("Chicken", R.drawable.chicken);

        proteinOptionsList.add(steak);
        proteinOptionsList.add(chicken);
    }


    public void onEvent(SteakEvent event) {

        hasSteak = true;
    }

    public void onEvent(UnsteakEvent event) {
        hasSteak = false;
    }

}
