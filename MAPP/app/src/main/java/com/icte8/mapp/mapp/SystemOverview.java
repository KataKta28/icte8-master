package com.icte8.mapp.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SystemOverview extends AppCompatActivity{

private View channelSetupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system_overview);

            populateFilterView();
            populateGasView();


        channelSetupButton = findViewById(R.id.setupButton);
        channelSetupButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        startActivity(new Intent(SystemOverview.this, ChannelOverview.class));

                    }
                });
    }

    private void populateFilterView() {
                //Create list of hardcoded items
            String[] myItems = {"       1         Bla          bla",
                                "       2         bla          bla",
                                "       3         BLa         Blaa"};
                //Build adapter
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this, //context
                    R.layout.listview, //Layout to use to display stuff
                    myItems); // Items to be displayed
            //Listview configuration
            ListView list = (ListView) findViewById(R.id.filterListView);
            list.setAdapter(adapter);

         }

    private void populateGasView() {
        //Create list of hardcoded items
        String[] myItems = {"       1         Bla          bla",
                "       2         bla          bla",
                "       3         BLa         Blaa"};
        //Build adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, //context
                R.layout.listview, //Layout to use to display stuff
                myItems); // Items to be displayed
        //Listview configuration
        ListView list = (ListView) findViewById(R.id.gasListView);
        list.setAdapter(adapter);


    }
 }
