package com.icte8.mapp.mapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListOfAccounts extends AppCompatActivity {

    View saveButton;
    View btnCancel;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_accounts);

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
