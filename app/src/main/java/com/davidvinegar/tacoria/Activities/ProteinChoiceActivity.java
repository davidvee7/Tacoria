package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.davidvinegar.tacoria.Adapters.FirstChoiceOption;
import com.davidvinegar.tacoria.Adapters.ProteinAdapter;
import com.davidvinegar.tacoria.R;

import java.util.ArrayList;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class ProteinChoiceActivity extends Activity {
    private RecyclerView mProteinRecyclerView;
    private RecyclerView.Adapter mProteinAdapter;
    private RecyclerView.LayoutManager mProteinLayoutManager;
    private ArrayList<FirstChoiceOption> proteinOptionsList;

    private String[] mDataSet = {"Steak", "Chicken"};



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.protein_choice_activity_layout);

        mProteinRecyclerView = (RecyclerView) findViewById(R.id.protein_recyclerView);
        mProteinLayoutManager = new LinearLayoutManager(this);
        mProteinRecyclerView.setLayoutManager(mProteinLayoutManager);

        mProteinRecyclerView.setHasFixedSize(true);



        initializeData();
        mProteinAdapter = new ProteinAdapter(proteinOptionsList);
        mProteinRecyclerView.setAdapter(mProteinAdapter);
    }

    private void initializeData (){
        proteinOptionsList = new ArrayList<>();
        FirstChoiceOption steak = new FirstChoiceOption("Steak", R.drawable.steak);
        FirstChoiceOption chicken = new FirstChoiceOption("Chicken", R.drawable.chicken);

        proteinOptionsList.add(steak);
        proteinOptionsList.add(chicken);
    }


}
