package com.icte8.mapp.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ChannelOverview extends AppCompatActivity {

    private View channel1Overview;
    private View channel2Overview;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_overview);

       channel1Overview = findViewById(R.id.detector1);
        channel1Overview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        startActivity(new Intent(ChannelOverview.this, ChannelSetup.class));

                    }
                });

        channel2Overview = findViewById(R.id.detector2);
        channel2Overview.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        startActivity(new Intent(ChannelOverview.this, ChannelSetup.class));

                    }
                });
    }
}
