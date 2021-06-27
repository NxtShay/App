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

public class Question03 extends AppCompatActivity implements View.OnClickListener{
    boolean heating;
    public void openQuestion04 () {
        Intent intent = new Intent (this, Question04.class);
        startActivity (intent);

    }

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question03);
        Button goToQuestion04;

        //Next button

        goToQuestion04 = (Button) findViewById (R.id.goToQuestion04);
        goToQuestion04.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion04 ( );
            }
        });
        Button q3_1 = findViewById (R.id.q3_yes);
        Button q3_2 = findViewById (R.id.q3_no);
        Button q3_3 = findViewById (R.id.q3_idk);

        q3_1.setOnClickListener (this);
        q3_2.setOnClickListener (this);
        q3_3.setOnClickListener (this);
    }

    @Override
    public void onClick ( View v ) {
        switch (v.getId ()){
            case R.id.q3_yes:
                heating = true;
                break;
            case R.id.q3_no:
                heating = false;
                break;
            case R.id.q3_idk:
                heating = Boolean.parseBoolean (null);
                break;
        }

    }
    public static void setHeatingProvider (String username, boolean heating ) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder ( ).permitAll ( ).build ( );
        StrictMode.setThreadPolicy (policy);

        HttpURLConnection connection = (HttpURLConnection) new URL ("http://10.0.2.2:8080/api/v1/user/").openConnection ( );
        connection.setRequestMethod ("PUT");
        connection.setRequestProperty ("Content-Type", "application/json; utf-8");
        String jsonInputString = "[{\"userName\":\"" + username +
                "\", \"heating\":\"" + heating + "\"}]";
        System.out.println (jsonInputString);
        connection.setDoOutput (true);
        try (OutputStreamWriter wr = new OutputStreamWriter (connection.getOutputStream ( ))) {
            wr.write (jsonInputString);
            wr.flush ( );
        }
    }
}