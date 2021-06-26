package com.example.hack.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hack.R;

public class Question04 extends AppCompatActivity implements View.OnClickListener{
    public void openQuestion05 () {
        Intent intent = new Intent (this, Question05.class);
        startActivity (intent);
    }
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question04);
        Button goToQuestion05;

        //Next button

        goToQuestion05 = (Button) findViewById (R.id.goToQuestion05);
        goToQuestion05.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion05 ( );
            }
        });

        Button q4_1 = findViewById (R.id.q4_1);
        Button q4_2 = findViewById (R.id.q4_2);
        Button q4_3 = findViewById (R.id.q4_3);
        Button q4_4 = findViewById (R.id.q4_4);
        Button q4_5 = findViewById (R.id.q4_5);

        q4_1.setOnClickListener (this);
        q4_2.setOnClickListener (this);
        q4_3.setOnClickListener (this);
        q4_4.setOnClickListener (this);
        q4_5.setOnClickListener (this);
    }

    @Override
    public void onClick ( View v ) {
        switch (v.getId ()){
            case R.id.q4_1:

                break;
            case R.id.q4_2:

                break;
            case R.id.q4_3:

                break;
            case R.id.q4_4:

                break;
            case R.id.q4_5:

                break;
        }
    }
}