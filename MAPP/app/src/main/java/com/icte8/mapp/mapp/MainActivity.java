package com.icte8.mapp.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.BsonInt32;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class MainActivity extends AppCompatActivity {
    private View signIn;
    private TextView result;
    private EditText username;
    private EditText password;
    private String pwd;


    private static final Random RANDOM = new SecureRandom();
    private static  final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.usernameInput);
        password = (EditText) findViewById(R.id.passwordInput);

        result = (TextView) findViewById(R.id.textView1);


        /*
        try {
            MongoClientURI uri = new MongoClientURI( "localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase(uri.getDatabase());
            System.out.println(db.getCollection("detector_data").find());
            BasicDBObject query = new BasicDBObject();
            BasicDBObject field = new BasicDBObject();
            field.put("serial", 1);
            DBCursor cursor = db.getCollection("detector_data").find(query, field);

            int channel = 1;
            DBObject searchByChannel = new BasicDBObject("channel", new BsonInt32(channel));
            DBObject found = collectionCall.find(searchByChannel);

            MongoClient mongoClient = new MongoClient("localhost", 27017);
            DB db = mongoClient.getDB("icte8LAD_db");
            System.out.println("Successfully connected to Database");

            DBCollection collectionCall = db.getCollection("detector_data");
            System.out.println("Collection collected succesfully");

            BasicDBObject key = new BasicDBObject();
            BasicDBObject value = new BasicDBObject();
            value.put("channel", 1);

            DBCursor cursor = collectionCall.find(key, value);
            while (cursor.hasNext()) {
                System.out.println("Hallo" + cursor.next());
            }

        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() + "HALLOOOOOOO");
        }*/
        signIn = findViewById(R.id.signinButton);
        signIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        try {

                            if (validateUsername(username.getText().toString().trim()) && (validatePassword(password.getText().toString().trim())))

                            {
                                //  startActivity(new Intent(MainActivity.this, MainScreenActivity.class));
                                pwd = password.getText().toString();
                                result.setText(computeHash(pwd));

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

    public String computeHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.reset();
            byte[] b = password.getBytes("UTF-8");
            md.update(b);
            byte[] digest = md.digest();
            String s = "";
            for (int i=0; i< digest.length; i++){
                s += Integer.toString((digest[i] & 0xff ) + 0x100, 16 ).substring(1);
            }
            return s;
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }




    /*

    ////////////////////////////

    public static byte[] generateSalt(){
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return salt;
    }
    //hash the password
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
    }*/

}





