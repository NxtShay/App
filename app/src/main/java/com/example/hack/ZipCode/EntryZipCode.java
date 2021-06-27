package com.example.hack.ZipCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hack.Question.Question01;
import com.example.hack.R;

public class EntryZipCode extends AppCompatActivity {

    private Button goToQuestion01;
    EditText enterZipCode;
    String zipCode;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_entry_zip_code);

        String zipCode = enterZipCode.getText ().toString ();

        goToQuestion01 = (Button) findViewById (R.id.goToQuestion01);
        goToQuestion01.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View v ) {
                openQuestion01 ( );
            }
        });
    }

    public void openQuestion01 () {
        Intent intent = new Intent(this, Question01.class);
        startActivity (intent);
    }
}