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

public class Question02 extends AppCompatActivity implements View.OnClickListener {
    boolean electricity;
    public void openQuestion03 () {
        Intent intent = new Intent (this, Question03.class);
        startActivity (intent);

    }

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question02);
        Button goToQuestion03;

        //Next button

        goToQuestion03 = (Button) findViewById (R.id.goToQuestion03);
        goToQuestion03.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion03 ( );
            }
        });

        Button q2_1 = findViewById (R.id.q2_yes);
        Button q2_2 = findViewById (R.id.q2_no);
        Button q2_3 = findViewById (R.id.q2_idk);

        q2_1.setOnClickListener (this);
        q2_2.setOnClickListener (this);
        q2_3.setOnClickListener (this);
    }

    @Override
    public void onClick ( View v ) {
        switch (v.getId ( )) {
            case R.id.q2_yes:
                electricity = true;
                break;
            case R.id.q2_no:
                electricity = false;
                break;
            case R.id.q2_idk:
                electricity = Boolean.parseBoolean (null);
                break;
        }

    }

    public static void setElectricityProvider (String username, boolean electricity ) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder ( ).permitAll ( ).build ( );
        StrictMode.setThreadPolicy (policy);

        HttpURLConnection connection = (HttpURLConnection) new URL ("http://10.0.2.2:8080/api/v1/user/").openConnection ( );
        connection.setRequestMethod ("PUT");
        connection.setRequestProperty ("Content-Type", "application/json; utf-8");
        String jsonInputString = "[{\"userName\":\"" + username +
                "\", \"electricity\":\"" + electricity + "\"}]";
        System.out.println (jsonInputString);
        connection.setDoOutput (true);
        try (OutputStreamWriter wr = new OutputStreamWriter (connection.getOutputStream ( ))) {
            wr.write (jsonInputString);
            wr.flush ( );
        }
    }
}