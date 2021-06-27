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

public class Question07 extends AppCompatActivity implements View.OnClickListener{
    String food;
    public void openQuestion08 () {
        Intent intent = new Intent (this, Question08.class);
        startActivity (intent);
    }

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question07);
        Button goToQuestion08;

        //Next button

        goToQuestion08 = (Button) findViewById (R.id.goToQuestion08);
        goToQuestion08.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion08 ( );
            }
        });
        Button q7_1 = findViewById (R.id.q7_1);
        Button q7_2 = findViewById (R.id.q7_2);
        Button q7_3 = findViewById (R.id.q7_3);

        q7_1.setOnClickListener (this);
        q7_2.setOnClickListener (this);
        q7_3.setOnClickListener (this);
    }

    @Override
    public void onClick ( View v ) {
        switch (v.getId ()){
            case R.id.q7_1:
                food = "Daily";
                break;
            case R.id.q7_2:
                food = "2-3 times a week";
                break;
            case R.id.q7_3:
                food = "Once a week or less";
                break;
        }
    }
    public void setFood(String username, String food) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Windows
        //HttpURLConnection connection = (HttpURLConnection) new URL("http://10.0.2.2:8080/api/v1/challenge/id/" + value).openConnection();
        //Linux
        HttpURLConnection connection = (HttpURLConnection) new URL ("http","192.168.178.20",8080,"/api/v1/user/").openConnection();

        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        String jsonInputString = "{\"userName\":\""+ username+
                "\", \"food\":\"" +food+"\"}";
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