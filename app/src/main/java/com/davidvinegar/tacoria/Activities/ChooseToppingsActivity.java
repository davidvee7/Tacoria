package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.davidvinegar.tacoria.Adapters.FirstChoiceOption;
import com.davidvinegar.tacoria.Adapters.ToppingAdapter;
import com.davidvinegar.tacoria.R;
import com.davidvinegar.tacoria.events.ChickenEvent;
import com.davidvinegar.tacoria.events.SteakEvent;
import com.davidvinegar.tacoria.events.UnchickenEvent;
import com.davidvinegar.tacoria.events.UnsteakEvent;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by davidvinegar on 1/12/17.
 */
public class ChooseToppingsActivity extends Activity{

    private RecyclerView mToppingsRecyclerView;
    private RecyclerView.Adapter mToppingsAdapter;
    private RecyclerView.LayoutManager mToppingsLayoutManager;
    private ArrayList<FirstChoiceOption> toppingsList;

    String foodType;
    boolean hasSteak;
    boolean hasChicken;
    boolean hasLettuce;
    boolean hasCheese;
    boolean hasSalsa;
    boolean hasSourCream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toppings_activity_layout);

        mToppingsRecyclerView = (RecyclerView) findViewById(R.id.toppings_recyclerView);
        mToppingsLayoutManager = new LinearLayoutManager(this);
        mToppingsRecyclerView.setLayoutManager(mToppingsLayoutManager);

        mToppingsRecyclerView.setHasFixedSize(true);

        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("foodType") != null) {

            this.foodType = bundle.getString("foodType");
        }
        this.hasChicken = bundle.getBoolean("hasChicken");
        this.hasSteak = bundle.getBoolean("hasSteak");

        initializeData();
        EventBus.getDefault().register(this);

        mToppingsAdapter = new ToppingAdapter(toppingsList);
        mToppingsRecyclerView.setAdapter(mToppingsAdapter);
        Button continueButton = (Button) findViewById(R.id.toppingsContinueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OrderSummaryActivity.class);
                intent.putExtra("foodType", ChooseToppingsActivity.this.foodType);
                intent.putExtra("hasSteak", ChooseToppingsActivity.this.hasSteak);
                intent.putExtra("hasChicken", ChooseToppingsActivity.this.hasChicken);
                startActivity(intent);
            }
        });
    }

    private void initializeData() {
        toppingsList = new ArrayList<>();
        FirstChoiceOption salsa = new FirstChoiceOption("Salsa", R.drawable.salsa);
        FirstChoiceOption lettuce = new FirstChoiceOption("Lettuce", R.drawable.lettuce);
        FirstChoiceOption cheese = new FirstChoiceOption("Cheese", R.drawable.cheese);
        FirstChoiceOption sourCream = new FirstChoiceOption("Sour Cream",R.drawable.sourcream);

        toppingsList.add(salsa);
        toppingsList.add(lettuce);
        toppingsList.add(cheese);
        toppingsList.add(sourCream);
    }


    public void onEvent(SteakEvent event) {

        hasSteak = true;
    }

    public void onEvent(UnsteakEvent event) {
        hasSteak = false;
    }

    public void onEvent(ChickenEvent event){
        hasChicken = true;
    }

    public void onEvent(UnchickenEvent event){
        hasChicken = false;
    }

}
