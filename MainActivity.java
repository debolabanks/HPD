package com.minimanager.enesihealthapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.layout.HospitalnamesActivity;
import com.layout.StateActivity;

public class MainActivity extends AppCompatActivity  {

    private Button but3,play_game, man_care, ask_doc;
    ImageButton share_invite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        but3 = (Button) findViewById(R.id.but3);
        Button but2 = (Button) findViewById(R.id.but2);
        share_invite = (ImageButton) findViewById(R.id.share_invite);
        play_game = (Button) findViewById(R.id.play_game);
        man_care = (Button) findViewById(R.id.man_care);
        ask_doc = (Button) findViewById(R.id.ask_doc);


        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StateScreen = new Intent(MainActivity.this,StateActivity.class);
                startActivity(StateScreen);}});

        but3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent nameScreen = new Intent(MainActivity.this, HospitalnamesActivity.class);
                 startActivity(nameScreen);}});

        share_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareInvite = new Intent(MainActivity.this, InvitesTab.class);
                startActivity(shareInvite);}});

        play_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playGame = new Intent(MainActivity.this, GameActivity.class);
                startActivity(playGame);}});

        man_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent manCare = new Intent(MainActivity.this, ManagedCare.class);
                startActivity(manCare);}});

        ask_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent askDoc = new Intent(MainActivity.this, AskDoc.class);
                startActivity(askDoc);}});
}
}