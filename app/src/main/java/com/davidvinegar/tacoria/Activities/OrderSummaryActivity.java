package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.davidvinegar.tacoria.Adapters.OrderSummaryAdapter;
import com.davidvinegar.tacoria.Model.Bag;
import com.davidvinegar.tacoria.Model.Orderable;
import com.davidvinegar.tacoria.R;

/**
 * Created by davidvinegar on 12/28/16.
 */

//order summary should display a recyclerview of food items ordered
public class OrderSummaryActivity extends Activity {

//    private ArrayList<Orderable> orderSummaryList;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_summary_layout);

        Bundle bundle = getIntent().getExtras();
        buildOrderable(bundle);
        buildOrderSummary();
        Bag bag = Bag.getInstance();

        mRecyclerView = (RecyclerView) findViewById(R.id.order_summary_recyclerview);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setHasFixedSize(true);



        OrderSummaryAdapter mAdapter = new OrderSummaryAdapter(bag.getOrderablesList());
        mRecyclerView.setAdapter(mAdapter);

    }

    private void buildOrderable(Bundle bundle){
        if (bundle.getString("foodtype")!= null){
            if (bundle.getString("foodType").equals("Burrito")){
                Orderable burrito = new Orderable();

                if (bundle.getBoolean("hasSteak") == true){
                    burrito.addSteak();
                }
                if (bundle.getBoolean("hasChicken") == true){
                    burrito.addChicken();
                }
                Bag bag = Bag.getInstance();
                bag.addItemToBag(burrito);
            }
        }
    }

    private void buildOrderSummary(){
        for (Orderable orderable: Bag.getInstance().getOrderablesList()){
            orderable.getcost();
        }
    }


}