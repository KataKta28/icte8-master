package com.icte8.mapp.mapp;


import com.google.gson.JsonObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private View signIn;
    private TextView result;
    private EditText username;
    private EditText password;
    private String pwd;


    private static final Random RANDOM = new SecureRandom();
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.usernameInput);
        password = (EditText) findViewById(R.id.passwordInput);

        try { //establish connection to server

             MongoClient mongoClient = new MongoClient("192.168.0.97", 8080);
             MongoDatabase db = mongoClient.getDatabase("backend");

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() + "Check your connection");
        }


        signIn = findViewById(R.id.signinButton);
        signIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        try {


                            if (validateUsername(username.getText().toString().trim()) && (validatePassword(password.getText().toString().trim())))
                            {
                                String usr = username.getText().toString().trim();
                                String pwd = password.getText().toString().trim();
                                //usr pass
                                JsonObject json = new JsonObject();
                                json.addProperty("name", usr);
                                json.addProperty("password", pwd);



                                Ion.with(MainActivity.this)
                                        .load("http://192.168.0.97:8080/api/authenticate")
                                        .setJsonPojoBody(json)
                                        .asJsonObject()
                                        .withResponse()
                                        .setCallback(new FutureCallback<Response<JsonObject>>() {
                                            @Override
                                            public void onCompleted(Exception e, Response<JsonObject> result) {

                                              //   Toast.makeText(MainActivity.this, result.toString(),Toast.LENGTH_LONG).show();
                                            //    startActivity(new Intent(MainActivity.this, MainScreenActivity.class));
                                                 if (result.getHeaders().code() == 404) {
                                                    Toast.makeText(MainActivity.this, "Incorrect Username or Password", Toast.LENGTH_LONG).show();
                                                } else if (result.getHeaders().code() == 200) {
                                                    startActivity(new Intent(MainActivity.this, MainScreenActivity.class));
                                                }
                                            }
                                        });





  /*


                                Ion.with(MainActivity.this)
                                        .load("http://192.168.0.97:8080/api/authenticate")
                                        .asString()
                                        .withResponse()
                                        .setCallback(new FutureCallback<Response<String>>() {
                                            @Override
                                            public void onCompleted(Exception e, Response<String> result) {




                                            }

                                        });*/


                            }

                       else
                                Toast.makeText(MainActivity.this, "Incorrect Username or Password", Toast.LENGTH_LONG).show();
                        } catch (Exception x) {
                            Toast.makeText(MainActivity.this, "Incorrect password", Toast.LENGTH_LONG).show();

                        }
                    }
                }); }

    protected boolean  validateUsername (String x){
        if (!x.equals("") )
            return true;
        else
            return false;
    }
    protected boolean validatePassword (String y){
        if (!y.equals("") && (y.length()==4))
            return true;
        else
            return false;

    }


}





