package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.davidvinegar.tacoria.R;
import com.devmarvel.creditcardentry.library.CardValidCallback;
import com.devmarvel.creditcardentry.library.CreditCard;
import com.simplify.android.sdk.Card;
import com.simplify.android.sdk.CardEditor;
import com.simplify.android.sdk.CardToken;
import com.simplify.android.sdk.Simplify;

/**
 * Created by davidvinegar on 1/6/17.
 */
public class CreditCardInputActivity extends Activity{
    private Button buttonAuthorize;
    Simplify simplify;
    CardValidCallback cardValidCallback = new CardValidCallback() {
        @Override
        public void cardValid(CreditCard creditCard) {
            Toast.makeText(CreditCardInputActivity.this,"Card Valid and Complete", Toast.LENGTH_LONG);
        }
    };

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.getcreditcard_layout);

        simplify = new Simplify();
        simplify.setApiKey("sbpb_OWIyYzA1YzAtNzBjMC00NDgyLTgwZGQtNGRiZTQzODM3YWE3");

        Card card = new Card()
                .setNumber("5555555555554444")
                .setExpMonth("01")
                .setExpYear("99")
                .setCvc("123")
                .setAddressZip("12345");

        simplify.createCardToken(card, new CardToken.Callback() {
            @Override
            public void onSuccess(CardToken cardToken) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });


        final CardEditor cardEditor = (CardEditor)findViewById(R.id.card_editor);
        final Button checkoutButton = (Button) findViewById(R.id.checkout_button);

        cardEditor.addOnStateChangedListener(new CardEditor.OnStateChangedListener() {
            @Override
            public void onStateChange(CardEditor cardEditor) {
                checkoutButton.setEnabled(cardEditor.isValid());
            }
        });

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simplify.createCardToken(cardEditor.getCard(), new CardToken.Callback(){
                    @Override
                public void onSuccess(CardToken cardToken){

                    }

                    @Override
                public void onError(Throwable throwable){

                    }
                });
            }
        });
    }






}
