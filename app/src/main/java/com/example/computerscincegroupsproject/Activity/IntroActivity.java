package com.example.computerscincegroupsproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.computerscincegroupsproject.R;
import com.example.computerscincegroupsproject.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {

    private ActivityIntroBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        NavHostFragment hostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        navController= hostFragment.getNavController();

        NavigationUI.setupWithNavController(binding.bottomNavigationView , navController);


    }
}