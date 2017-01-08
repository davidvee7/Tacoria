package com.davidvinegar.tacoria.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

import com.davidvinegar.tacoria.R;

/**
 * Created by davidvinegar on 1/8/17.
 */
public class ThankYouActivity extends Activity {
    public static final String EXTRA_PAGE = ThankYouActivity.class.getName() + ".PAGE";

    public static final int PAGE_SUCCESS = 0;
    public static final int PAGE_FAIL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

        int page = getIntent().getIntExtra(EXTRA_PAGE, PAGE_SUCCESS);
        ((ViewFlipper) findViewById(R.id.flipper_thankyou)).setDisplayedChild(page);

        findViewById(R.id.text_shop_more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.text_try_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
