package com.example.hack.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hack.R;

public class Question08 extends AppCompatActivity implements View.OnClickListener{
    public void openQuestion09 () {
        Intent intent = new Intent (this, Question09.class);
        startActivity (intent);
    }
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question08);
        Button goToQuestion09;

        //Next button

        goToQuestion09 = (Button) findViewById (R.id.goToQuestion09);
        goToQuestion09.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion09 ( );
            }
        });
        Button q8_1 = findViewById (R.id.q8_yes);
        Button q8_2 = findViewById (R.id.q8_no);
        Button q8_3 = findViewById (R.id.q8_idk);

        q8_1.setOnClickListener (this);
        q8_2.setOnClickListener (this);
        q8_3.setOnClickListener (this);
    }

    @Override
    public void onClick ( View v ) {
        switch (v.getId ()){
            case R.id.q8_yes:

                break;
            case R.id.q8_no:

                break;
            case R.id.q8_idk:

                break;
        }
    }
}