package com.example.hack.ui.Challenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

import java.util.Random;

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
                System.out.println("clicked");

                int min = 1;
                int max = 10;

                Random random = new Random();

                int value = random.nextInt(max + min) + min;
                System.out.println(value);
                //Get the infos by the database

                binding.textView5.setVisibility(View.VISIBLE);
                binding.textChallenge.setVisibility(View.VISIBLE);
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

                int value = random.nextInt(max + min) + min;
                System.out.println(value);
                //Get the infos by the database


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

                int value = random.nextInt(max + min) + min;
                System.out.println(value);
                //Get the infos by the database


            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}