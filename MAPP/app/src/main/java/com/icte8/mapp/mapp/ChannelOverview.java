package com.icte8.mapp.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ChannelOverview extends AppCompatActivity {

//    private View channel1Overview;
//    private View channel2Overview;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_overview);

        final LinearLayout lm = (LinearLayout) findViewById(R.id.chnOverviewll);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        int detectNo = 3;

            for (int i = 0 ; i < detectNo; i++) {
                int id = i+1;
                LinearLayout ll = new LinearLayout(this);
                ll.setOrientation(LinearLayout.VERTICAL);
                ll.setGravity(Gravity.CENTER_HORIZONTAL);
                params.setMargins(0, 10, 0, 0); // Doesn't work... Want more space between buttons

                final Button chnOverviewBtn = new Button(this);
                chnOverviewBtn.setId(id);
                chnOverviewBtn.setText("Detector " + id);
                chnOverviewBtn.setLayoutParams(params);

                final int index = i;

                chnOverviewBtn.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("TAG", "index: " + index);

                        Toast.makeText(getApplicationContext(), "Clicked button index: " + index, Toast.LENGTH_LONG).show();

                        startActivity(new Intent(ChannelOverview.this, ChannelSetup.class));

                    }
                });

                ll.addView(chnOverviewBtn, params);
                assert lm != null;
                lm.addView(ll);

            }




/**
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
 **/

    }
}
