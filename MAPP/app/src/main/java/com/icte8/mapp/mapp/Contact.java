package com.icte8.mapp.mapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Contact extends AppCompatActivity {

    TextView phone_no;
    private TextView service_email;
    private TextView admin_email;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

    phone_no = findViewById(R.id.contact_phone_no);

}
