package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.davidvinegar.tacoria.R;
import com.devmarvel.creditcardentry.library.CardValidCallback;
import com.devmarvel.creditcardentry.library.CreditCard;
import com.devmarvel.creditcardentry.library.CreditCardForm;

/**
 * Created by davidvinegar on 1/6/17.
 */
public class CreditCardInputActivity extends Activity{
    private Button buttonAuthorize;

    CardValidCallback cardValidCallback = new CardValidCallback() {
        @Override
        public void cardValid(CreditCard creditCard) {
            Toast.makeText(CreditCardInputActivity.this,"Card Valid and Complete", Toast.LENGTH_LONG);
        }
    };

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.getcreditcard_layout);

        final CreditCardForm form = (CreditCardForm) findViewById(R.id.credit_card_form);
        form.setOnCardValidCallback(cardValidCallback);


//
//        buttonAuthorize = (Button) findViewById(R.id.button_authorize_cc);
//        buttonAuthorize.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(form.isCreditCardValid()){
//                    CreditCard card = form.getCreditCard();
//
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),"Invalid Credit Card",Toast.LENGTH_LONG);
//                }
//            }
//        });

    }




}
