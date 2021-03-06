package com.icte8.mapp.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.net.URL;

public class MainScreenActivity extends AppCompatActivity {

    private View overviewButton;
    private View listAccounts;
    private View signOut;
    private View contact;
    public String myToken;

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
                        try {

                            Intent intent= getIntent();
                            String myToken = intent.getStringExtra("key");
                            Log.d("2nd token", myToken);
                            JsonObject json2 = new JsonObject();
                            json2.addProperty("token", myToken);

                        /*
                            String myToken = getIntent().getStringExtra("key");
                            Log.d("2nd token", myToken);

                                    .asString()
                                    .setCallback(new FutureCallback<String>() {
                                        @Override
                                        public void onCompleted(Exception e, String result) {

                                            System.out.println("Result from Ovi: " + result.toString());

                                        }
                                    });



                            JsonObject jsonToken = new JsonObject();
                            jsonToken.addProperty("jwt", myToken);
 */
                            Ion.with(MainScreenActivity.this)
                                    .load("http://192.168.0.52:8080/api/memberinfo")
                                    .setHeader("Authorization", myToken)
                                    .asString()
                                    .withResponse()
                                    .setCallback(new FutureCallback<Response<String>>() {
                                        @Override
                                        public void onCompleted(Exception e, Response<String> result) {

                                            System.out.println("Answer is: "+result);
                                        }
                                    });

                            startActivity(new Intent(MainScreenActivity.this, SystemOverview.class));
                        } catch (Exception x) {
                            Toast.makeText(MainScreenActivity.this, "Data cannot be retrieved", Toast.LENGTH_LONG).show();
                        }
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
