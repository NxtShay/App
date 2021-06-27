package com.example.hack.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hack.R;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Question05 extends AppCompatActivity {
    EditText q5_1;
    public void openQuestion06 () {
        Intent intent = new Intent (this, Question06.class);
        startActivity (intent);
    }
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question05);
        Button goToQuestion06;
        String kilometer = q5_1.getText ().toString ();
        int kilometers = Integer.parseInt (kilometer);

        //Next button

        goToQuestion06 = (Button) findViewById (R.id.goToQuestion06);
        goToQuestion06.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion06 ( );
            }
        });
    }
    public void updateUserScore(String username, int kilometers) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Windows
        //HttpURLConnection connection = (HttpURLConnection) new URL("http://10.0.2.2:8080/api/v1/challenge/id/" + value).openConnection();
        //Linux
        HttpURLConnection connection = (HttpURLConnection) new URL ("http","192.168.178.20",8080,"/api/v1/user/").openConnection();

        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        String jsonInputString = "{\"userName\":\""+ username+
                "\", \"kilometers\":\"" +kilometers+"\"}";
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