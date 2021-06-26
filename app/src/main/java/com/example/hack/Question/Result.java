package com.example.hack.Question;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;

import com.example.hack.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.Math;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static com.example.hack.Login.Login.globalUserName;

public class Result extends AppCompatActivity {

    public int Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        try {
            String result = getQuizData(globalUserName);
            JSONObject json = new JSONObject(result);
            calculateFootprint(json);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

    }

    public void calculateFootprint(JSONObject json) throws JSONException {
        if (!json.isNull("peopleInHouse")) {
            switch (json.getInt("peopleInHouse")) {
                case 1:
                    Score = 14;
                    break;
                case 2:
                    Score = 12;
                    break;
                case 3:
                    Score = 10;
                    break;
                case 4:
                    Score = 8;
                    break;
                case 5:
                    Score = 6;
                    break;
                case 6:
                    Score = 4;
                    break;
                default:
                    Score = 2;
                    break;
            }
        }


        if (!json.isNull("electricity")) {
            if (json.getBoolean("electricity")) {
                Score = Score + 1;
            } else {
                Score = Score + 20;
            }
        }
        if (!json.isNull("heating")) {
            if (json.getBoolean("heating")) {
                Score = Score + 1;
            } else {
                Score = Score + 20;
            }
        }
        if (!json.isNull("car")) {
            if (json.getString("car") == "Hybrid or Electrical") {
                Score = Score + 1;
            } else {
                Score = Score + 0;
            }
        }
        if (!json.isNull("kilometers")) {
            switch (json.getInt("kilometers")) {
                case 1:
                    Score = Score + 4;
                    break;
                case 2:
                    Score = Score + 6;
                    break;
                case 3:
                    Score = Score + 10;
                    break;
                default:
                    Score = Score + 12;
                    break;
            }
        }
        if (!json.isNull("holidayCar")) {
            if (json.getInt("holidayCar") == 0) {
                Score = Score;
            } else {
                Score = (int) (Score + json.getInt("holidayCar") * 0.1);
            }
        }
        if (!json.isNull("holidayPlain")) {
            if (json.getInt("holidayPlain") == 0) {
                Score = Score;
            } else {
                Score = Score + json.getInt("holidayPlain") * 6;
            }
        }
        if (!json.isNull("holidayTrain")) {
            if (json.getInt("holidayTrain") == 0) {
                Score = Score;
            } else {
                Score = Score + json.getInt("holidayTrain") * 6;
            }
        }
        if (!json.isNull("food")) {
            switch (json.getString("food")) {
                case "Daily":
                    Score = Score + 12;
                    break;
                case "Twice per week":
                    Score = Score + 8;
                    break;
                default:
                    Score = Score + 2;
                    break;
            }
        }

        boolean recycGlass = false;
        boolean recycPlastic = false;
        boolean recycPaper = false;
        boolean recycMetal = false;
        boolean recycFood = false;

        if (json.isNull("recyclingGlass")) {
            recycGlass = false;
        } else {
            recycGlass = json.getBoolean("recyclingGlass");
        }

        if (json.isNull("recyclingPlastic")) {
            recycPlastic = false;
        } else {
            recycPlastic = json.getBoolean("recyclingPlastic");
        }

        if (json.isNull("recyclingPaper")) {
            recycPaper = false;
        } else {
            recycPaper = json.getBoolean("recyclingPlastic");
        }

        if (json.isNull("recyclingMetal")) {
            recycMetal = false;
        } else {
            recycMetal = json.getBoolean("recyclingMetal");
        }

        if (json.isNull("recyclingFoodwaste")) {
            recycFood = false;
        } else {
            recycFood = json.getBoolean("recyclingFoodwaste");
        }


        if (recycGlass == false && recycPlastic == false && recycPaper == false && recycMetal == false && recycFood == false) {
            Score = Score + 24;
        } else if (recycGlass) {
            Score = Score + 4;
        } else if (recycPlastic) {
            Score = Score + 4;
        } else if (recycPaper) {
            Score = Score + 4;
        } else if (recycMetal) {
            Score = Score + 4;
        } else if (recycFood) {
            Score = Score + 4;
        }
        if (!json.isNull("washing")) {
            switch (json.getString("washing")) {
                case "Daily":
                    Score = Score + 3;
                    break;
                case "Twice per week":
                    Score = Score + 2;
                    break;
                default:
                    Score = Score + 1;
                    break;
            }
        }
        System.out.println(Score);
        System.out.println(Score * 0.1 + " metric CO2e");
    }

    public static String getQuizData(String name) throws IOException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        HttpURLConnection connection = (HttpURLConnection) new URL("http://10.0.2.2:8080/api/v1/user/username/" + name).openConnection();

        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            String response = "";
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
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