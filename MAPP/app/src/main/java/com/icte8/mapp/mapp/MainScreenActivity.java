package com.icte8.mapp.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainScreenActivity extends AppCompatActivity {

    private View overviewButton;
    private View listAccounts;
    private View signOut;
    private View contact;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);


        overviewButton = findViewById(R.id.systemOverviewButton);
        listAccounts = findViewById(R.id.listOfAccountsButton);
        signOut = findViewById(R.id.singOutButton);
        contact = findViewById(R.id.contactButton);


        overviewButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        startActivity(new Intent(MainScreenActivity.this, SystemOverview.class));
                    }
                });

        listAccounts.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainScreenActivity.this, ListOfAccounts.class));
                    }
                });

        contact.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        startActivity(new Intent(MainScreenActivity.this, Contact.class));
                    }
                });

        signOut.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View x){

                         finish();
                        System.exit(0);
                    }
                });

    }


}
