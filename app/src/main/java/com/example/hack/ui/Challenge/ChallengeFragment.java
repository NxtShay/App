package com.example.hack.ui.Challenge;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hack.Challenge.DisplayChallenge;
import com.example.hack.Login.Registration;
import com.example.hack.R;
import com.example.hack.databinding.FragmentChallengesBinding;
import com.example.hack.ui.home.HomeFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class ChallengeFragment extends Fragment {

    private ChallengeViewModel galleryViewModel;
    private FragmentChallengesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(ChallengeViewModel.class);

        View v = inflater.inflate(R.layout.fragment_challenges, container, false);


        binding = FragmentChallengesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textChallenge;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonchallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Fragment secoundfragment = new HomeFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_container, secoundfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/

                //generate random number for challenge and display it
                System.out.println("clickedInChallengeFragment");

                //int min = 1;
                int max = 0;
                String randomChallenge = "";
                String scoreForRandomChallenge = "0";
                try {
                    max = getNumberChallenges();
                    Random random = new Random();

                    int value = random.nextInt((max - 1 ) + 1) + 1;
                    System.out.println("value: "+value);
                    // If it worked and we got a challenge back, then we convert
                    // it to a Json, so we can
                    // easily access the challenge field
                    String challenge = getChallenge(value);

                    if (!challenge.equals("")) {
                        JSONObject json = new JSONObject(challenge);
                        randomChallenge = json.getString("challenge");
                        scoreForRandomChallenge = json.getString("score");
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

                binding.textView5.setVisibility(View.VISIBLE);
                binding.textChallenge.setText(randomChallenge);
                binding.textChallenge.setVisibility(View.VISIBLE);
                binding.textChallengeScore.setText("You would gain \n"+scoreForRandomChallenge+" points.");
                binding.textChallengeScore.setVisibility(View.VISIBLE);
                binding.buttoncompletechallenge.setVisibility(View.VISIBLE);
                binding.buttoncancelchallenge.setVisibility(View.VISIBLE);
                binding.imageofchallenge.setVisibility(View.VISIBLE);

                binding.buttonchallenge.setVisibility(View.INVISIBLE);
                binding.textchallengeyourself.setVisibility(View.INVISIBLE);
            }
        });

        binding.buttoncancelchallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Fragment secoundfragment = new HomeFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_container, secoundfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/

                //generate random number for challenge and display it
                System.out.println("challengefragment");

                int min = 1;
                int max = 10;

                Random random = new Random();

                int value = random.nextInt((max - 1) + 1) + 1;
                System.out.println(value);
                //Get the infos by the database

                binding.textView5.setVisibility(View.INVISIBLE);
                binding.textChallenge.setVisibility(View.INVISIBLE);
                binding.textChallengeScore.setVisibility(View.INVISIBLE);
                binding.buttoncompletechallenge.setVisibility(View.INVISIBLE);
                binding.buttoncancelchallenge.setVisibility(View.INVISIBLE);
                binding.imageofchallenge.setVisibility(View.INVISIBLE);

                binding.buttonchallenge.setVisibility(View.VISIBLE);
                binding.textchallengeyourself.setVisibility(View.VISIBLE);

            }
        });

        binding.buttoncompletechallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Fragment secoundfragment = new HomeFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_container, secoundfragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();*/

                //generate random number for challenge and display it
                System.out.println("clicked");

                int min = 1;
                int max = 10;

                Random random = new Random();

                int value = random.nextInt((max - 1) + 1) + 1;
                System.out.println(value);
                //Get the infos by the database

                String scoreText = (String) binding.textChallengeScore.getText();
                String score = scoreText.split(" ")[3];

                Toast.makeText(getActivity(), "Awesome! You gained "+score+" points.", Toast.LENGTH_SHORT).show();


                binding.textView5.setVisibility(View.INVISIBLE);
                binding.textChallenge.setVisibility(View.INVISIBLE);
                binding.textChallengeScore.setVisibility(View.INVISIBLE);
                binding.buttoncompletechallenge.setVisibility(View.INVISIBLE);
                binding.buttoncancelchallenge.setVisibility(View.INVISIBLE);
                binding.imageofchallenge.setVisibility(View.INVISIBLE);

                binding.buttonchallenge.setVisibility(View.VISIBLE);
                binding.textchallengeyourself.setVisibility(View.VISIBLE);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private String getChallenge(int value) throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Windows
        HttpURLConnection connection = (HttpURLConnection) new URL("http://10.0.2.2:8080/api/v1/challenge/id/" + value).openConnection();
        //Linux
        //HttpURLConnection connection = (HttpURLConnection) new URL("http","192.168.178.20",8080,"/api/v1/challenge/id/" + String.valueOf(value)).openConnection();

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


    public static Integer getNumberChallenges() throws IOException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Windows
        HttpURLConnection connection = (HttpURLConnection) new URL("http://10.0.2.2:8080/api/v1/challenge/size").openConnection();
        //Linux
        //HttpURLConnection connection = (HttpURLConnection) new URL("http","192.168.178.20",8080,"/api/v1/challenge/size/").openConnection();

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
            Integer res = Integer.parseInt(response.trim());
            return res;
        }

        // an error happened
        return null;
    }
}