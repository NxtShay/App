package com.example.hack.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hack.R;

public class Question06 extends AppCompatActivity implements View.OnClickListener{
    public void openQuestion07 () {
        Intent intent = new Intent (this, Question07.class);
        startActivity (intent);
    }
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question06);
        Button goToQuestion07;

        //Next button

        goToQuestion07 = (Button) findViewById (R.id.goToQuestion07);
        goToQuestion07.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion07 ( );
            }
        });

        Button q6_1 = findViewById (R.id.q6_1);
        Button q6_2 = findViewById (R.id.q6_2);
        Button q6_3 = findViewById (R.id.q6_3);
        Button q6_4 = findViewById (R.id.q6_4);


        q6_1.setOnClickListener (this);
        q6_2.setOnClickListener (this);
        q6_3.setOnClickListener (this);
        q6_4.setOnClickListener (this);

    }

    @Override
    public void onClick ( View v ) {
        switch (v.getId ()){
            case R.id.q6_1:

                break;
            case R.id.q6_2:

                break;
            case R.id.q6_3:

                break;
            case R.id.q6_4:

                break;
        }
    }
}