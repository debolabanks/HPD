package com.minimanager.enesihealthapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Button more, less, bt_check, but_restart;
    TextView tx_pick, tv_title;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    int current_number, number_to_guess, tries;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        AdRequest adRequest = new AdRequest.Builder().build();

        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(GameActivity.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
// Call displayInterstitial() function
                displayInterstitial();
            }
        });

        r = new Random();
        number_to_guess = r.nextInt(51);

        bt_check = (Button)findViewById(R.id.bt_check);
        more = (Button)findViewById(R.id.more);
        less = (Button)findViewById(R.id.less);
        tx_pick = (TextView) findViewById(R.id.tx_pick);
        tv_title = (TextView) findViewById(R.id.tv_title);
        but_restart = (Button) findViewById(R.id.but_restart);
        final MediaPlayer mp= MediaPlayer.create(this, R.raw.sample);

        tries = 1;
        current_number = 0;
        tx_pick.setText("" + current_number);



        bt_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                if(current_number == number_to_guess && tries == 1) {
                    /*tv_title.setText(getString(R.string.text_awesome) + getString(R.string.advance));
                    bt_check.setEnabled(false);
                    more.setEnabled(false);
                    less.setEnabled(false);*/

                    Intent intent = new Intent(GameActivity.this, start.class);
                    startActivity(intent);
                } else if(current_number == number_to_guess && tries <= 5) {
                        tv_title.setText(getString(R.string.text_congrats) + tries + getString(R.string.text_tries) + getString(R.string.advance));
                        /*bt_check.setEnabled(false);
                        more.setEnabled(false);
                        less.setEnabled(false);*/

                    Intent intent = new Intent(GameActivity.this, start.class);
                    startActivity(intent);
                } else if(current_number == number_to_guess && tries > 5 && tries <= 8){
                    tv_title.setText(getString(R.string.text_weldone) + tries + getString(R.string.text_tries) + getString(R.string.text_tryAgain) );
                    bt_check.setEnabled(false);
                    more.setEnabled(false);
                    less.setEnabled(false);
                } else if(current_number == number_to_guess && tries > 8){
                    tv_title.setText(getString(R.string.text_better) + tries + getString(R.string.text_tries) + getString(R.string.text_tryAgain) );
                    bt_check.setEnabled(false);
                    more.setEnabled(false);
                    less.setEnabled(false);

                } else if (current_number > number_to_guess){
                    tv_title.setText("Down!" + getString(R.string.text_tryAgain));
                    tries++;

                } else if (current_number < number_to_guess){
                tv_title.setText("Up!" + getString(R.string.text_tryAgain));
                    tries++;

            }

            }
        });

        but_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 11) {
                    recreate();
                } else {
                    Intent intent = getIntent();
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    finish();
                    overridePendingTransition(0, 0);

                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }

            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_number < 50) {
                    current_number++;
                }
                tx_pick.setText("" + current_number);

            }
        });

        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_number > 0) {
                    current_number--;
                }
                tx_pick.setText("" + current_number);

            }
        });


    }

    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}
