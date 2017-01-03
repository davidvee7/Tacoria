package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.os.Bundle;

import com.davidvinegar.tacoria.Model.Bag;
import com.davidvinegar.tacoria.Model.Burrito;
import com.davidvinegar.tacoria.R;

/**
 * Created by davidvinegar on 12/28/16.
 */

//order summary should display a recyclerview of food items ordered
public class OrderSummaryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_summary_layout);
        Bundle bundle = getIntent().getExtras();
        buildOrderable(bundle);


    }

    private void buildOrderable(Bundle bundle){
        if (bundle.getString("foodtype")!= null){
            if (bundle.getString("foodType").equals("Burrito")){
                Burrito burrito = new Burrito();

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


}