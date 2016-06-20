package com.icte8.mapp.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ListOfAccounts extends AppCompatActivity {

    View saveButton;
    View btnCancel;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_accounts);

        final LinearLayout lm = (LinearLayout) findViewById(R.id.llVert);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams userllParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.HORIZONTAL);

        int noOfAccounts = 10;

        for (int i = 0 ; i < noOfAccounts; i++) {
            int userindex = i+1;

            LinearLayout userll = new LinearLayout(this);
            userllParams.setMargins(50, 25, 0, 50); // Doesn't work... Want more space between buttons

            final TextView accountTv = new TextView(this);
            accountTv.setId(userindex);
            accountTv.setText("Account no. " + userindex);
            accountTv.setMinWidth(getWindowManager().getDefaultDisplay().getWidth() / 3);
            accountTv.setMaxWidth(getWindowManager().getDefaultDisplay().getWidth() / 2);

            final TextView roleTv = new TextView(this);
            roleTv.setId(userindex);
            roleTv.setText("Role of " + userindex);
            roleTv.setMinWidth(getWindowManager().getDefaultDisplay().getWidth() / 4);
            roleTv.setMaxWidth(getWindowManager().getDefaultDisplay().getWidth() / 2);

            final Button accountBtn = new Button(this);
            accountBtn.setId(userindex);
            accountBtn.setText("Edit " + userindex);
            accountBtn.setWidth(100);

            final int index = i;

            accountBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("TAG", "index: " + index);

                    Toast.makeText(getApplicationContext(), "Clicked button index: " + index, Toast.LENGTH_SHORT).show();

                    //   startActivity(new Intent(ChannelOverview.this, ChannelSetup.class));

                }
            });

            userll.addView(accountTv,userllParams);
            userll.addView(roleTv, userllParams);
            userll.addView(accountBtn, userllParams);
            assert lm != null;
            lm.addView(userll, params);

        }



/**

 final TextView user1 = (TextView) findViewById(R.id.username1);
 final TextView user2 = (TextView) findViewById(R.id.username2);
 final TextView user3 = (TextView) findViewById(R.id.username3);
 final TextView user4 = (TextView) findViewById(R.id.username4);
 final TextView user5 = (TextView) findViewById(R.id.username5);
 final TextView user6 = (TextView) findViewById(R.id.username6);
 final TextView user7 = (TextView) findViewById(R.id.username7);

 final TextView userRole1 = (TextView) findViewById(R.id.userRole1);
 final TextView userRole2 = (TextView) findViewById(R.id.userRole2);
 final TextView userRole3 = (TextView) findViewById(R.id.userRole3);
 final TextView userRole4 = (TextView) findViewById(R.id.userRole4);
 final TextView userRole5 = (TextView) findViewById(R.id.userRole5);
 final TextView userRole6 = (TextView) findViewById(R.id.userRole6);
 final TextView userRole7 = (TextView) findViewById(R.id.userRole7);

 Button btnAccountSetup1 = (Button) findViewById(R.id.btnUser1);
 Button btnAccountSetup2 = (Button) findViewById(R.id.btnUser2);
 Button btnAccountSetup3 = (Button) findViewById(R.id.btnUser3);
 Button btnAccountSetup4 = (Button) findViewById(R.id.btnUser4);
 Button btnAccountSetup5 = (Button) findViewById(R.id.btnUser5);
 Button btnAccountSetup6 = (Button) findViewById(R.id.btnUser6);
 Button btnAccountSetup7 = (Button) findViewById(R.id.btnUser7);

 **/

        btnCancel = (Button) findViewById(R.id.cancelSetup);

        btnCancel.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );
    }
}
