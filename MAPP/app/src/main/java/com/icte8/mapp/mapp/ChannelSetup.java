package com.icte8.mapp.mapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChannelSetup extends AppCompatActivity {

    private View saveButton;
    private View cancelButton;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channel_setup);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        final EditText setFilterHigh = (EditText) findViewById(R.id.inputFilterHigh);
        final EditText setGasHigh = (EditText) findViewById(R.id.inputGasAlarm);
        final EditText filterValue = (EditText) findViewById(R.id.filterHighValue);
        final EditText gasValue = (EditText) findViewById(R.id.gasHighValue);
        saveButton = findViewById(R.id.saveSetup);
        cancelButton = findViewById(R.id.cancelSetup);

        filterValue.setKeyListener(null);
        gasValue.setKeyListener(null);

        filterValue.setText(prefs.getInt("filter", 0) + "");
        gasValue.setText(prefs.getInt("gas", 0) + "");


        cancelButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View x) {
                        finish();
                    }
                }
        );
        saveButton.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {

                        try {
                            if (checkIfFilterEmpty(setFilterHigh.getText().toString().trim())) {
                                setFilterHigh.setError("Value required");
                                setFilterHigh.requestFocus();
                            } else if (checkIfGasEmpty(setGasHigh.getText().toString().trim())) {
                                setGasHigh.setError("Value required");
                                setGasHigh.requestFocus();
                            } else {
                                //save shit to db
                                int filterSetValue = Integer.parseInt(setFilterHigh.getText().toString());
                                int gasSetValue = Integer.parseInt(setGasHigh.getText().toString());

                                filterValue.setText(filterSetValue + "");
                                gasValue.setText(gasSetValue + "");

                                savePreferences("filter", "gas", filterSetValue, gasSetValue);
                                //savedValues(filterValue, gasValue);
                                // finish();
                                Toast.makeText(ChannelSetup.this, "Saved!", Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception x) {
                            System.err.println(x.getClass().getName() + ": " + x.getMessage() + "The save has been unsuccessful");
                        }
                    }
                }
        );
    }

    protected boolean checkIfFilterEmpty(String x) {
        if (x.equals(""))
            return true;
        else
            return false;

    }

    protected boolean checkIfGasEmpty(String y) {
        if (y.equals(""))
            return true;
        else
            return false;

    }

    private void savePreferences(final String filter, final String gas, final int filterValue, final int gasValue) {
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(ChannelSetup.this);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(filter, filterValue);
        editor.putInt(gas, gasValue);
        editor.apply();
    }
}

