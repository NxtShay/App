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

import static com.example.hack.Login.Login.globalUserName;

public class Question01 extends AppCompatActivity  {
    private Button goToQuestion02;
    EditText numberOfPeopleInHouse;
    int peopleInHouse;

    public void openQuestion02 () {
        Intent intent = new Intent (this, Question02.class);
        startActivity (intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question01);
        Button goToQuestion02;

        String peopleInHouseString = numberOfPeopleInHouse.getText ().toString ();
        int peopleInHouse = Integer.parseInt (peopleInHouseString);


        numberOfPeopleInHouse = findViewById (R.id.numberOfPeopleInHouse);
        //Next button

        goToQuestion02 = (Button) findViewById (R.id.gooToQuestion02);
        goToQuestion02.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion02 ( );
            }
        });


    }
    public static void setPeopleInHouse(int peopleInHouse) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        HttpURLConnection connection = (HttpURLConnection) new URL ("http://10.0.2.2:8080/api/v1/user/").openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        String jsonInputString = "{\"userName\":\""+ globalUserName+
                "\", \"peopleInHouse\":\"" +peopleInHouse+"\"}";
        System.out.println(jsonInputString);
        connection.setDoOutput(true);
        try(OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream())) {
            wr.write(jsonInputString);
            wr.flush();
        }
    }
}