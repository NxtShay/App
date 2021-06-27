package com.example.hack.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import com.example.hack.R;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Question08 extends AppCompatActivity implements View.OnClickListener{
    boolean pvSystem;
    public void openQuestion09 () {
        Intent intent = new Intent (this, Question09.class);
        startActivity (intent);
    }
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question08);
        Button goToQuestion09;

        //Next button

        goToQuestion09 = (Button) findViewById (R.id.goToQuestion09);
        goToQuestion09.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion09 ( );
            }
        });
        Button q8_1 = findViewById (R.id.q8_yes);
        Button q8_2 = findViewById (R.id.q8_no);
        Button q8_3 = findViewById (R.id.q8_idk);

        q8_1.setOnClickListener (this);
        q8_2.setOnClickListener (this);
        q8_3.setOnClickListener (this);
    }

    @Override
    public void onClick ( View v ) {
        switch (v.getId ()){
            case R.id.q8_yes:
                pvSystem = true;
                break;
            case R.id.q8_no:
                pvSystem = false;
                break;
            case R.id.q8_idk:
                pvSystem = Boolean.parseBoolean (null);
                break;
        }
    }
    public void setPvSystem(String username, boolean pvSystem) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Windows
        //HttpURLConnection connection = (HttpURLConnection) new URL("http://10.0.2.2:8080/api/v1/challenge/id/" + value).openConnection();
        //Linux
        HttpURLConnection connection = (HttpURLConnection) new URL ("http","192.168.178.20",8080,"/api/v1/user/").openConnection();

        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        String jsonInputString = "{\"userName\":\""+ username+
                "\", \"pvSystem\":\"" +pvSystem+"\"}";
        System.out.println(jsonInputString);
        connection.setDoOutput(true);
        try(OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream())) {
            wr.write(jsonInputString);
            wr.flush();
        }
        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            System.out.println("PUT was successful.");
        }
        else if(responseCode == 401){
            System.out.println("Cannot PUT");
        }
    }
}