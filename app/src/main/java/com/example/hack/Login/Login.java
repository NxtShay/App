package com.example.hack.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hack.MainActivity;
import com.example.hack.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button buttonLogin;
    private Button buttonReg;
    private TextView attemptsInfo;


    private final String realusername = "Admin";
    private final String realpassword = "123";

    boolean isValid = false;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.etName);
        password = (EditText) findViewById(R.id.edTextTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        attemptsInfo = findViewById(R.id.textAttemptsInfo);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = username.getText().toString();
                String inputPassword = password.getText().toString();
                String pw = "";

                try {
                    pw = getPersonData(inputName);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(pw.equals("")){
                    Toast.makeText(Login.this, "No password exists for this username!", Toast.LENGTH_SHORT).show();
                }
                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter all the details correctly!", Toast.LENGTH_SHORT).show();
                } else {

                    isValid = validate(inputPassword.trim(), pw.trim());

                    if(!isValid) {
                        System.out.println(inputPassword.getClass().getName());
                        System.out.println(pw.getClass().getName());
                        System.out.println(inputPassword);
                        System.out.println(pw);

                        counter--;
                        Toast.makeText(Login.this, "Incorrect credentials entered!", Toast.LENGTH_SHORT).show();

                        attemptsInfo.setText("No. of attempts remaining: " + counter);

                        if(counter == 0){
                           buttonLogin.setEnabled(false);
                        }
                    } else{
                        Toast.makeText(Login.this, "Login was successful!", Toast.LENGTH_SHORT).show();

                        //Go to the home activity
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });

        buttonReg = (Button) findViewById(R.id.buttonregister);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistration();
            }
        });
    }

    private boolean validate(String password, String pw) {
        if (password.equals(pw)) {
            return true;
        }
        return false;
    }


    public void openRegistration() {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    public static String getPersonData(String name) throws IOException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Windows
        HttpURLConnection connection = (HttpURLConnection) new URL("http://10.0.2.2:8080/api/v1/user/password/" + name).openConnection();
        //Linux
        //HttpURLConnection connection = (HttpURLConnection) new URL("http","192.168.178.20",8080,"/api/v1/user/password/" + name).openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if(responseCode == 200){
            String response = "";
            Scanner scanner = new Scanner(connection.getInputStream());
            while(scanner.hasNextLine()){
                response += scanner.nextLine();
                response += "\n";
            }
            scanner.close();

            System.out.println(response);
            return response;
        }

        // an error happened
        return null;
    }
}