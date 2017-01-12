package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.davidvinegar.tacoria.Adapters.OrderSummaryAdapter;
import com.davidvinegar.tacoria.Model.Bag;
import com.davidvinegar.tacoria.Model.Orderable;
import com.davidvinegar.tacoria.R;

import java.text.DecimalFormat;

/**
 * Created by davidvinegar on 12/28/16.
 */

//order summary should display a recyclerview of food items ordered
public class OrderSummaryActivity extends Activity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    Bag bag;
    Button continueCheckoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_summary_layout);

        Bundle bundle = getIntent().getExtras();
        buildOrderable(bundle);
        buildOrderSummary();
        this.bag = Bag.getInstance();

        mRecyclerView = (RecyclerView) findViewById(R.id.order_summary_recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setHasFixedSize(true);


        OrderSummaryAdapter mAdapter = new OrderSummaryAdapter(bag.getOrderablesList());
        mRecyclerView.setAdapter(mAdapter);

        continueCheckoutButton = (Button) findViewById(R.id.continue_To_Checkout);
        Button addFoodButton = (Button) findViewById(R.id.add_food_button);

        double totalCost = bag.getBagTotalCostWithTax();
        DecimalFormat df = new DecimalFormat("0.00");

        TextView totalCostText = (TextView) findViewById(R.id.your_total_amount);
        String totalCostFormatted = df.format(totalCost);
        totalCostText.setText(totalCostFormatted);

        double totalTax = bag.getBagTax();
        TextView totalTaxText = (TextView) findViewById(R.id.your_tax_amount);

        String formattedTax = df.format(totalTax);

        totalTaxText.setText(formattedTax);

        addFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OrderFirstChoiceActivity.class);
                startActivity(intent);
            }
        });

        continueCheckoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CreditCardInputActivity.class);
                startActivity(intent);
            }
        });


    }

    private void buildOrderable(Bundle bundle) {
        if (bundle.getString("foodType") != null) {
            if (bundle.getString("foodType").equals("Burrito")) {
                Orderable burrito = new Orderable();

                if (bundle.getBoolean("hasSteak") == true) {
                    burrito.addSteak();
                }
                if (bundle.getBoolean("hasChicken") == true) {
                    burrito.addChicken();
                }
                if (bundle.getBoolean("hasSalsa") == true) {
                    burrito.addSalsa();
                }
                if (bundle.getBoolean("hasLettuce") == true) {
                    burrito.addLettuce();
                }
                if (bundle.getBoolean("hasCheese") == true) {
                    burrito.addCheese();
                }
                burrito.setFoodType("Burrito");
                Bag bag = Bag.getInstance();
                bag.addItemToBag(burrito);
            } else if (bundle.getString("foodType").equals("Tacos")) {
                Orderable taco = new Orderable();

                if (bundle.getBoolean("hasSteak") == true) {
                    taco.addSteak();
                }
                if (bundle.getBoolean("hasChicken") == true) {
                    taco.addChicken();
                }

                if (bundle.getBoolean("hasSalsa") == true) {
                    taco.addSalsa();
                }
                if (bundle.getBoolean("hasLettuce") == true) {
                    taco.addLettuce();
                }
                if (bundle.getBoolean("hasCheese") == true) {
                    taco.addCheese();
                }
                taco.setFoodType("Tacos");
                Bag bag = Bag.getInstance();
                bag.addItemToBag(taco);

            }
        }


    }

    private void buildOrderSummary() {
        for (Orderable orderable : Bag.getInstance().getOrderablesList()) {
            orderable.getcost();
        }
    }


    @Override
    public void onBackPressed() {
        if (bag.getSizeOrderablesList() > 1) {
            bag.removeLastItem();
            bag.removeLastItem();
        }
        super.onBackPressed();
    }

}