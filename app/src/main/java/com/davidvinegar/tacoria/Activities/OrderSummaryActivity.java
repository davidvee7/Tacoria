package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.os.Bundle;

import com.davidvinegar.tacoria.Model.Bag;
import com.davidvinegar.tacoria.Model.Orderable;
import com.davidvinegar.tacoria.R;

import java.util.ArrayList;

/**
 * Created by davidvinegar on 12/28/16.
 */

//order summary should display a recyclerview of food items ordered
public class OrderSummaryActivity extends Activity {

    private ArrayList<Orderable> orderSummaryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_summary_layout);
        Bundle bundle = getIntent().getExtras();
        buildOrderable(bundle);
        buildOrderSummary();


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
        for (Orderable orderable: Bag.getInstance().getBag()){
            orderable.getcost();
        }
    }


}