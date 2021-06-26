package com.example.hack.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.hack.R;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Question01 extends AppCompatActivity  {
    private Button goToQuestion02;


    public void openQuestion02 () {
        Intent intent = new Intent (this, Question02.class);
        startActivity (intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question01);
        Button goToQuestion02;

        //Next button

        goToQuestion02 = (Button) findViewById (R.id.gooToQuestion02);
        goToQuestion02.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion02 ( );
            }
        });


    }
}
