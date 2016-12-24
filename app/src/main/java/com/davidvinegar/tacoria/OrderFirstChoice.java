package com.davidvinegar.tacoria;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class OrderFirstChoice extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutMnaager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_order_choice_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutMnaager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutMnaager);
        String[] myDataset = {"Burrito", "Tacos", "Burrito Bowl","Kids Quesadilla"};
        mAdapter = new FirstChoiceAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
