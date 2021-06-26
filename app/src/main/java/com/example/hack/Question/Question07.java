package com.example.hack.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hack.R;

public class Question07 extends AppCompatActivity implements View.OnClickListener{
    public void openQuestion08 () {
        Intent intent = new Intent (this, Question08.class);
        startActivity (intent);
    }

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question07);
        Button goToQuestion08;

        //Next button

        goToQuestion08 = (Button) findViewById (R.id.goToQuestion08);
        goToQuestion08.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion08 ( );
            }
        });
        Button q7_1 = findViewById (R.id.q7_1);
        Button q7_2 = findViewById (R.id.q7_2);
        Button q7_3 = findViewById (R.id.q7_3);

        q7_1.setOnClickListener (this);
        q7_2.setOnClickListener (this);
        q7_3.setOnClickListener (this);
    }

    @Override
    public void onClick ( View v ) {
        switch (v.getId ()){
            case R.id.q7_1:

                break;
            case R.id.q7_2:

                break;
            case R.id.q7_3:

                break;
        }
    }
}