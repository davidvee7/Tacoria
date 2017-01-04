package com.davidvinegar.tacoria.Activities;
//helpful http://arjunu.com/2015/10/android-recyclerview-with-different-cardviews/

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.davidvinegar.tacoria.Adapters.FirstChoiceAdapter;
import com.davidvinegar.tacoria.Adapters.FirstChoiceOption;
import com.davidvinegar.tacoria.R;
import com.davidvinegar.tacoria.events.BurritoEvent;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by davidvinegar on 12/23/16.
 */
public class OrderFirstChoiceActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutMnaager;
    private ArrayList<FirstChoiceOption> firstChoiceOptionList;

    private String[] mDataSet = {"Burrito", "Tacos", "Quesadillas Suiza"};

    TextView foodName;
    ImageView foodPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        EventBus firstChoiceEventBus = EventBus.getDefault();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_order_choice_activity_layout);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutMnaager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutMnaager);

        mRecyclerView.setHasFixedSize(true);



        initializeData();
        mAdapter = new FirstChoiceAdapter(firstChoiceOptionList, this.getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
        EventBus.getDefault().register(this);
    }

    private void initializeData (){
        firstChoiceOptionList = new ArrayList<>();
        FirstChoiceOption burrito = new FirstChoiceOption("Burrito", R.drawable.burrito);
        FirstChoiceOption tacos = new FirstChoiceOption("Tacos", R.drawable.tacos);

        firstChoiceOptionList.add(burrito);
        firstChoiceOptionList.add(tacos);
    }

    public void onEvent(BurritoEvent event){
        Log.v("burrito event", "successfully got to burrito event");

        Intent intent = new Intent(getApplicationContext(),ProteinChoiceActivity.class);
        intent.putExtra("foodType","Burrito");
        EventBus.getDefault().unregister(this);

        startActivity(intent);

    }

}
