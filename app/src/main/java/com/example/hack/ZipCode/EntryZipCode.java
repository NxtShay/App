package com.example.hack.ZipCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hack.Question.Question01;
import com.example.hack.R;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static com.example.hack.Login.Login.globalUserName;

public class EntryZipCode extends AppCompatActivity {

    private Button goToQuestion01;
    EditText enterZipCode;




    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_entry_zip_code);

        String zipCode = enterZipCode.getText().toString();


        goToQuestion01 = (Button) findViewById (R.id.goToQuestion01);
        goToQuestion01.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion01 ( );
            }
        });
    }

    public void openQuestion01 () {
        Intent intent = new Intent(this, Question01.class);
        startActivity (intent);
    }
    public void getZipCode(String zipCode) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Windows
        HttpURLConnection connection = (HttpURLConnection) new URL("http://10.0.2.2:8080/api/v1/challenge/id/" ).openConnection();
        //Linux
        //HttpURLConnection connection = (HttpURLConnection) new URL("http","192.168.178.20",8080,"/api/v1/user/").openConnection();

        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        String jsonInputString = "{\"userName\":\""+ globalUserName+
                "\", \"zipCode\":\"" +zipCode+"\"}";
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
            System.out.println("Cannot update score");
        }
    }
}