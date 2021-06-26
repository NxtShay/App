package com.example.hack.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hack.MainActivity;
import com.example.hack.R;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLOutput;

public class Registration extends AppCompatActivity  {

    private EditText regUsername;
    private EditText regPassword;
    private EditText regPrenom;
    private EditText regLastName;
    private Button regButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        regUsername = (EditText) findViewById(R.id.rUserName);
        regPassword = (EditText) findViewById(R.id.rPasswort);
        regPrenom = (EditText) findViewById(R.id.rPrenom);
        regLastName = (EditText) findViewById(R.id.rLastName);
        regButton = findViewById(R.id.buttonSubmit);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String finalusername = regUsername.getText().toString();
                String finalpassword = regPassword.getText().toString();
                String finalprenom = regPrenom.getText().toString();
                String finallastname = regLastName.getText().toString();

                if (finalusername.isEmpty() || finalpassword.isEmpty() || finalprenom.isEmpty() || finallastname.isEmpty()) {
                    Toast.makeText(Registration.this, "Please enter all the details correctly!", Toast.LENGTH_SHORT).show();
                    System.out.println("Test2");
                } else {
                    System.out.println("Test");
                    try {
                        System.out.println("Test");
                        setPersonData(finalusername, finalpassword, finalprenom, finallastname);
                    } catch (IOException e) {
                        Toast.makeText(Registration.this, "Registration was not successful!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    Toast.makeText(Registration.this, "Registration was successful!", Toast.LENGTH_SHORT).show();

                    //Go to the home activity
                    Intent intent = new Intent(Registration.this, Login.class);
                    startActivity(intent);
                }
            }
        });
    }

    public static void setPersonData(String username, String password, String firstname, String lastname) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Windows
        HttpURLConnection connection = (HttpURLConnection) new URL("http://10.0.2.2:8080/api/v1/user/").openConnection();
        //Linux
        //HttpURLConnection connection = (HttpURLConnection) new URL("http","192.168.178.20",8080,"/api/v1/user/").openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; utf-8");
        String jsonInputString = "[{\"userName\":\""+ username+
                "\", \"userPassword\":\"" +password+
                "\", \"firstName\":\"" + firstname+
                "\", \"lastName\":\"" + lastname+"\"}]";
        System.out.println(jsonInputString);
        connection.setDoOutput(true);
        try(OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream())) {
            wr.write(jsonInputString);
            wr.flush();
        }
        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            System.out.println("POST was successful.");
        }
        else if(responseCode == 401){
            System.out.println("Wrong password.");
        }
    }
}