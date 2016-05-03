package com.icte8.mapp.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class MainActivity extends AppCompatActivity {
    private View signIn;
    //stuff needed for hashing the password
    private static final Random RANDOM = new SecureRandom();
    private static  final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = (EditText) findViewById(R.id.usernameInput);
        final EditText password = (EditText) findViewById(R.id.passwordInput);



        signIn = findViewById(R.id.signinButton);
        signIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {

/*                        if(validateUsername(username.getText().toString())){
                            username.setError("Invalid Username");
                            username.requestFocus();
                        } else if (validatePassword(password.getText().toString())){
                            password.setError("Invalid Password");
                            password.requestFocus();
                        }else {

                           //start activity goes here ..............corecteaza acoladele dupa
                        }}*/
                        startActivity(new Intent(MainActivity.this, MainScreenActivity.class));




    }  } ); }

//This is where we will check the values against the DB

    protected boolean validateUsername(String username) {
        if(username!=null && username.length()<5){
            return true;
        }
        else
        {
            return false;
        }}
    protected boolean validatePassword(String password) {
        if(password!=null && password.length()==4){
            return false;
        }else
        {
            return true;
        }}


    public static byte[] generateSalt(){
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return salt;
    }

    public static byte[] hash(char[] password, byte[] salt){
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
    try {
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return skf.generateSecret(spec).getEncoded();
    }
    catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
        throw new AssertionError("Error while hashing a password: "+ e.getMessage(), e );
    }
    finally{
        spec.clearPassword();
    }
    }

}





