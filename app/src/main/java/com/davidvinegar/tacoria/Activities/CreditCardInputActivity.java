package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.davidvinegar.tacoria.R;
import com.devmarvel.creditcardentry.library.CreditCard;
import com.devmarvel.creditcardentry.library.CreditCardForm;

/**
 * Created by davidvinegar on 1/6/17.
 */
public class CreditCardInputActivity extends Activity{
    private LinearLayout linearLayout;
    private CreditCardForm form;
    private Button buttonAuthorize;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.getcreditcard_layout);
        linearLayout = (LinearLayout)findViewById(R.id.credit_linear_layer);

        form = new CreditCardForm(this);
        linearLayout.addView(form);

        buttonAuthorize = (Button) findViewById(R.id.button_authorize_cc);
        buttonAuthorize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(form.isCreditCardValid()){
                    CreditCard card = form.getCreditCard();

                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid Credit Card",Toast.LENGTH_LONG);
                }
            }
        });

    }

}
