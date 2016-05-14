package com.icte8.mapp.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class SystemOverview extends AppCompatActivity{

private View channelSetupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system_overview);
/*    This is a change
        MongoClientURI uri = new MongoClientURI( "mongodb://username:password@www.example.com:12345/db-name" );
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase(uri.getDatabase());
// JONAS sucks diskc

//List views for Gas
/*
        //channel
        ListView myListView1 = (ListView) findViewById(R.id.listView1);
        List<String> myStringArray1 = new ArrayList<>();
        myStringArray1.add("1");
        myStringArray1.add("2");
        myStringArray1.add("3");
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myStringArray1 );
        myListView1.setAdapter(arrayAdapter1);

        //status
        ListView myListView2 = (ListView) findViewById(R.id.listView2);
        List<String> myStringArray2 = new ArrayList<>();
        myStringArray2.add("Active");
        myStringArray2.add("Active");
        myStringArray2.add("Active");
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myStringArray2 );
        myListView2.setAdapter(arrayAdapter2);


        //level
        ListView myListView3 = (ListView) findViewById(R.id.listView3);
        List<String> myStringArray3 = new ArrayList<>();
        myStringArray3.add("OK");
        myStringArray3.add("OK");
        myStringArray3.add("OK");
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myStringArray3 );
        myListView3.setAdapter(arrayAdapter3);


        //high
        ListView myListView4 = (ListView) findViewById(R.id.listView4);
        List<String> myStringArray4 = new ArrayList<>();
        myStringArray4.add("100");
        myStringArray4.add("100");
        myStringArray4.add("1");
        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myStringArray4 );
        myListView4.setAdapter(arrayAdapter4);
*/


        channelSetupButton = findViewById(R.id.setupButton);
        channelSetupButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        startActivity(new Intent(SystemOverview.this, ChannelOverview.class));

                    }
                });
    }
}
