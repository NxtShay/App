package com.example.hack.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hack.R;

public class Question05 extends AppCompatActivity {
    public void openQuestion06 () {
        Intent intent = new Intent (this, Question06.class);
        startActivity (intent);
    }
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_question05);
        Button goToQuestion06;

        //Next button

        goToQuestion06 = (Button) findViewById (R.id.goToQuestion06);
        goToQuestion06.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion06 ( );
            }
        });
    }
}