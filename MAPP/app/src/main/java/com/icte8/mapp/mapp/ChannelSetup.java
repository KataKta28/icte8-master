package com.icte8.mapp.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

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
                            if (checkIfFilterEmpty(setFilterHigh.getText().toString().trim())){
                                setFilterHigh.setError("Value required");
                                setFilterHigh.requestFocus();
                            } else if (checkIfGasEmpty(setGasHigh.getText().toString().trim())){
                                    setGasHigh.setError("Value required");
                                    setGasHigh.requestFocus();
                            } else {
                                //save shit to db
                                finish();
                                Toast.makeText(ChannelSetup.this, "Saved!", Toast.LENGTH_LONG).show();
                            }
                        }
                        catch(Exception x){
                            System.err.println( x.getClass().getName() + ": " + x.getMessage() + "The save has been unsuccessful");
                        }
                    }  } ); }

    protected boolean checkIfFilterEmpty (String x){
      if (x.equals("") )
            return true;
        else
            return false;

}
    protected boolean checkIfGasEmpty (String y){
        if (y.equals(""))
            return true;
        else
            return false;

    }

}

