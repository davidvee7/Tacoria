package com.davidvinegar.tacoria.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.davidvinegar.tacoria.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.viewMenu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://eattacoria.com/tacoria-menu-2016.pdf"));
                startActivity(browserIntent);
            }
        });

    }




    public void sendMessage(View view) {
        Intent intent = new Intent(this, OrderFirstChoiceActivity.class);
        startActivity(intent);
    }
}
