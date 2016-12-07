package com.minimanager.enesihealthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class AskDoc extends AppCompatActivity {

    TextView med_quest,tx_phone,tx_mail;
    Button med_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_doc);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        med_quest = (TextView)findViewById(R.id.med_quest);
        tx_phone = (TextView)findViewById(R.id.tx_phone);
        tx_mail = (TextView)findViewById(R.id.tx_mail);
        med_submit = (Button)findViewById(R.id.med_submit);

        med_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
