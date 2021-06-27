package com.example.hack.ui.MoreFunctions;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hack.Question.Result;
import com.example.hack.databinding.FragmentMorefunctionsBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static com.example.hack.Login.Login.globalUserName;

public class MoreFunctionsFragment extends Fragment {

    private MoreFunctionsViewModel slideshowViewModel;
    private FragmentMorefunctionsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(MoreFunctionsViewModel.class);

        binding = FragmentMorefunctionsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMorefunctions;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        try {
            String res = getUserData(globalUserName);
            JSONObject json = new JSONObject(res);

            binding.textProfileUserScore.setText("Score:\n"+json.getString("userScore"));
            binding.textProfileUserName.setText("Profile of:\n"+json.getString("userName"));
            binding.textProfileFirstName.setText("Prenum:\n"+json.getString("firstName"));
            binding.textProfileLastName.setText("Surname:\n"+json.getString("lastName"));

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }





        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static String getUserData(String name) throws IOException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Windows
        //HttpURLConnection connection = (HttpURLConnection) new URL("http://10.0.2.2:8080/api/v1/user/username/" + name).openConnection();
        //Linux
        HttpURLConnection connection = (HttpURLConnection) new URL("http","192.168.178.20",8080,"/api/v1/user/username/"+name).openConnection();

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