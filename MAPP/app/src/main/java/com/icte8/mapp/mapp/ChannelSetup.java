package com.icte8.mapp.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;

public class ChannelSetup extends AppCompatActivity {


    private View saveButton;
    private View cancelButton;
    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_setup);


        final EditText setFilterHigh = (EditText) findViewById(R.id.inputFilterHigh);
        final EditText  setGasHigh = (EditText) findViewById(R.id.inputGasAlarm);
        saveButton = findViewById(R.id.saveSetup);
        cancelButton = findViewById(R.id.cancelSetup);

        cancelButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View x){
                        finish();
                    }
                }
        );


        saveButton.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {

                        try{
                            if(filterValue(setFilterHigh.getText().toString())){
                                setFilterHigh.setError("Invalid input");
                                setFilterHigh.requestFocus();
                            } else if (gasValue(setGasHigh.getText().toString())){
                               setGasHigh.setError("Invalid input");
                                setGasHigh.requestFocus();
                            }else {


                            //here we push to the database

                        }}
                        catch(Exception x){
                            System.err.println( x.getClass().getName() + ": " + x.getMessage() + "The save has been unsuccessful");
                        }
                    }  } ); }




    protected boolean filterValue(String setFilterHigh) {
        if(setFilterHigh!=null){
            return true;
        }
        else
        {
            return false;
        }}
    protected boolean gasValue(String setGasHigh) {
        if(setGasHigh!=null){
            return false;
        }else
        {
            return true;
        }}
}

