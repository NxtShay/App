package com.example.hack.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hack.R;

public class Question01 extends AppCompatActivity implements View.OnClickListener {
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


        Button q1_1 = findViewById (R.id.q1_1);
        Button q1_2 = findViewById (R.id.q1_2);
        Button q1_3 = findViewById (R.id.q1_3);
        Button q1_4 = findViewById (R.id.q1_4);
        Button q1_5 = findViewById (R.id.q1_5);

        q1_1.setOnClickListener (this);
        q1_2.setOnClickListener (this);
        q1_3.setOnClickListener (this);
        q1_4.setOnClickListener (this);
        q1_5.setOnClickListener (this);

    }


    @Override
    public void onClick ( View v ) {
        switch (v.getId ()){
            case R.id.q1_1:

                break;
            case R.id.q1_2:

                break;
            case R.id.q1_3:

                break;
            case R.id.q1_4:

                break;
            case R.id.q1_5:

                break;
        }

    }
}