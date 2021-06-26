package com.example.hack.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hack.R;

public class Question09 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question09);
        Button goToQuestion10;

        //Next button

        goToQuestion10 = (Button) findViewById (R.id.goToQuestion10);
        goToQuestion10.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion10 ( );
            }
        });

        Button q9_1 = findViewById (R.id.q9_1);
        Button q9_2 = findViewById (R.id.q9_2);
        Button q9_3 = findViewById (R.id.q9_3);
        Button q9_4 = findViewById (R.id.q9_4);
        Button q9_5 = findViewById (R.id.q6_4);


        q9_1.setOnClickListener (this);
        q9_2.setOnClickListener (this);
        q9_3.setOnClickListener (this);
        q9_4.setOnClickListener (this);
        q9_5.setOnClickListener (this);
    }

    private void openQuestion10 () {
        Intent intent = new Intent (this, Question10.class);
        startActivity (intent);
    }

    @Override
    public void onClick ( View v ) {
        switch (v.getId ()){
            case R.id.q9_1:

                break;
            case R.id.q9_2:

                break;
            case R.id.q9_3:

                break;
            case R.id.q9_4:

                break;
            case R.id.q9_5:

                break;
        }

    }
}